/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import classis.NewUser;
import java.util.ResourceBundle;
import resource.SessionRequestContent;

/**
 *
 * @author jvm
 */
public class NewUserPage implements CurrentPage{

    public NewUserPage() {
    }

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        NewUser newUser = new NewUser(sessionRequestContent);
        if(newUser.registerUser()){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
            String page = resourceBundle.getString("page.login");
            return page;
        }else{
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
            String page = resourceBundle.getString("page.registration");
            return page;
        }
        
    }
    
}
