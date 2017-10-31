/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import entity.Product;
import entity.User;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import resource.SessionRequestContent;
import session.UserFacade;
import util.EncriptPass;

/**
 *
 * @author jvm
 */
public class CheckLoginPage implements CurrentPage{
   
    private UserFacade userFacade;
    private SessionRequestContent sessionRequestContent;
    
    public CheckLoginPage() {
        Context context; 
        try {
            context = new InitialContext();
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
        } catch (NamingException ex) {
            Logger.getLogger(CheckLoginPage.class.getName()).log(Level.SEVERE, "Не удалось найти сессионый бин", ex);
        }
    }

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        this.sessionRequestContent=sessionRequestContent;
        String login = sessionRequestContent.getRequestParameterValue("login");
        String enterPassword = sessionRequestContent.getRequestParameterValue("password");
        if(login == null || login.isEmpty() || enterPassword == null || enterPassword.isEmpty()){
            return getPage("error","Неверный логин или пароль","page.login");
        }else{
            User regUser=userFacade.findByLogin(login);
            if(regUser == null){
                return getPage("error","Неверный логин или пароль","page.login");
            }
            EncriptPass ep = new EncriptPass();
            ep.setEncriptPassword(enterPassword, regUser.getSalts());
            String password = ep.getEncriptPassword();
            if(!regUser.getPassword().equals(password)){
                return getPage("error","Неверный логин или пароль","page.login");
            }
            this.sessionRequestContent.setSessionAttributes("regUser", regUser);
            return getPage("info","Добро пожаловать, "+regUser.getCustomer().getName()+"!","page.index");
        } 
    }
    
        private String getPage(String key,String value,String keyPage){
            this.sessionRequestContent.setRequestAttributes(key, value);
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
            String page = resourceBundle.getString(keyPage);
            return page;
        }
   
    
}
