/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import entity.Product;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import resource.SessionRequestContent;
import session.ProductFacade;

/**
 *
 * @author jvm
 */

public class ProductPage implements CurrentPage {
    
    private ProductFacade productFacade;

    public ProductPage() {
       Context context; 
        try {
            context = new InitialContext();
            this.productFacade = (ProductFacade) context.lookup("java:module/ProductFacade");
        } catch (NamingException ex) {
            Logger.getLogger(ProductPage.class.getName()).log(Level.SEVERE, "Не удалось найти сессионый бин", ex);
        }
       
    }
    
    @Override
    public String execute(SessionRequestContent sessionRequetContent) {
        
        List<Product> products = productFacade.findAll();
        sessionRequetContent.setRequestAttributes("products", products);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.product");
        return page;
    }
    
}
