/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import entity.Product;
import java.util.List;
import java.util.ResourceBundle;
import resource.SessionRequestContent;

/**
 *
 * @author jvm
 */
public class LoginPage implements CurrentPage{
        

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.login");
        return page;
    }
}
