/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import entity.User;
import java.util.ResourceBundle;
import resource.SessionRequestContent;

/**
 *
 * @author jvm
 */
public class LogoutPage implements CurrentPage{

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        sessionRequestContent.sessionLogout();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.index");
        return page;
    }
    
}
