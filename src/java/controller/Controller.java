/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import command.CurrentPage;
import command.PageFactory;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resource.SessionRequestContent;
import session.ProductFacade;

/**
 *
 * @author jvm
 */
@WebServlet(name = "Controller", loadOnStartup = 1, urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
//@EJB private ProductFacade productFacade;
//    @Override
//    public void init() throws ServletException {
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
//        String key1 =resourceBundle.getString("key1");
//        getServletContext().setAttribute("info", "Сработал метод init(). key1="+key1);
//    }

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        SessionRequestContent sessionRequestContent = new SessionRequestContent();
        sessionRequestContent.extractValues(request);
        String page = null;
        PageFactory factory= new PageFactory();
        CurrentPage currentPage = factory.definePage(sessionRequestContent);
        page = currentPage.execute(sessionRequestContent);
        sessionRequestContent.insertAttributes(request);
        if(page != null){
            request.getRequestDispatcher(page).forward(request, response);
        }else{
            request.getSession().setAttribute("error", "Произошла ошибка: обращение к несуществующей странице");
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
            page = resourceBundle.getString("page.error");
            response.sendRedirect(request.getContextPath()+page);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
