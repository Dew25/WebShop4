/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import resource.SessionRequestContent;

/**
 *
 * @author jvm
 */
public interface CurrentPage {
    String execute(SessionRequestContent sessionRequestContent);
}
