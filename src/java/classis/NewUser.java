/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classis;

import entity.Customer;
import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import resource.SessionRequestContent;
import session.CustomerFacade;
import session.UserFacade;
import util.EncriptPass;

/**
 *
 * @author jvm
 */
public class NewUser {
    private UserFacade userFacade;
    private CustomerFacade customerFacade;
    private SessionRequestContent sessionRequestContent;
    
    public NewUser(SessionRequestContent sessionRequestContent) {
        this.sessionRequestContent=sessionRequestContent;
        Context context; 
        try {
            context = new InitialContext();
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
            this.customerFacade = (CustomerFacade) context.lookup("java:module/CustomerFacade");
            
        } catch (NamingException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, "Не удалось найти сессионый бин", ex);
        }
    }

    public boolean registerUser() {
        String name=sessionRequestContent.getRequestParameterValue("name");
        String surname=sessionRequestContent.getRequestParameterValue("surname");
        String phone=sessionRequestContent.getRequestParameterValue("phone");
        String city=sessionRequestContent.getRequestParameterValue("city");
        String money=sessionRequestContent.getRequestParameterValue("money");
        String login=sessionRequestContent.getRequestParameterValue("login");
        String password1=sessionRequestContent.getRequestParameterValue("password1");
        String password2=sessionRequestContent.getRequestParameterValue("password2");
        if(login.isEmpty() || password1.isEmpty() || !password1.equals(password2)){
           sessionRequestContent.setRequestAttributes("info", "Не корректно введены данные!");
           sessionRequestContent.setRequestAttributes("name", name);
           sessionRequestContent.setRequestAttributes("surname", surname);
           sessionRequestContent.setRequestAttributes("phone", phone);
           sessionRequestContent.setRequestAttributes("city", city);
           sessionRequestContent.setRequestAttributes("money", money);
           sessionRequestContent.setRequestAttributes("login", login);
           return false; 
        }else{
            Customer customer = new Customer(name, surname, new Long(money), phone, city);
            customerFacade.create(customer);
            EncriptPass ep = new EncriptPass();
            String salts = ep.getSalts();
            ep.setEncriptPassword(password1, salts);
            String password = ep.getEncriptPassword();
            User user = new User(login, password, salts, customer);
            userFacade.create(user);
            sessionRequestContent.setRequestAttributes("info", "Пользователь успешно добавлен!");
           return true;
        }
            
        
    }
    
}
