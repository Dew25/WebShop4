/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ResourceBundle;
import resource.SessionRequestContent;

/**
 *
 * @author jvm
 */
public class EmptyPage implements CurrentPage{

    public EmptyPage() {
    }

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.error");
        return page;
    }
    
}
