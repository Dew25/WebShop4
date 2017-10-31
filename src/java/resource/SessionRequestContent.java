/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jvm
 */
public class SessionRequestContent {
    private HashMap<String,Object> requestAttributes = new HashMap<>();
    private HashMap<String,String[]> requestParameters= new HashMap<>();
    private HashMap<String,Object> sessionAttributes= new HashMap<>();
    private HttpServletRequest request;

    public SessionRequestContent() {
    }
        
    public void extractValues(HttpServletRequest request){
        this.request=request;
        Enumeration attributeNames=request.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String attrName=(String) attributeNames.nextElement();
            this.requestAttributes.put(attrName, request.getAttribute(attrName));
        }
        
        this.requestParameters=(HashMap<String, String[]>) request.getParameterMap();
        Enumeration<String> parameterNames=request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name=parameterNames.nextElement();
            
        }
       
        HttpSession session = request.getSession(false);
        if(session != null){
            Enumeration sessionAttributes = session.getAttributeNames();
            while(sessionAttributes.hasMoreElements()) {
                String sessAtribute = (String) sessionAttributes.nextElement();
                this.sessionAttributes.put(sessAtribute,session.getAttribute(sessAtribute));
            }
        }
    }
    
    public void insertAttributes(HttpServletRequest request){
        if(requestAttributes != null){
            for(Map.Entry<String, Object> entry : requestAttributes.entrySet()){
                request.setAttribute(entry.getKey(), entry.getValue());
            }
        }
        HttpSession session = request.getSession(false);
        if(session != null){
            for(Map.Entry<String, Object> entry : sessionAttributes.entrySet()){
                session.setAttribute(entry.getKey(), entry.getValue());
            }
        }
    }

    public List<String> getRequestParameterValues(String parameterName) {
//        if(requestParameters.containsKey(parameterName)){
//            List<String> requestParameter=Arrays.asList(requestParameters.get(parameterName));
//            return requestParameter;
//        }
//        return null;
        return Arrays.asList(this.request.getParameter(parameterName));
    }
    
    public String getRequestParameterValue(String parameterName) {
//        if(requestParameters.containsKey(parameterName)){
//            List<String> requestParameter = Arrays.asList(requestParameters.get(parameterName));
//            return requestParameter.get(0);
//        }
        return (String) this.request.getParameter(parameterName);
    }
    
    public Object getSessionAtributeValue(String attributeName) {
//        Object sessionAttr = null;
//        if(sessionAttributes.containsKey(attributeName)){
//            sessionAttr=sessionAttributes.get(attributeName);
//        }
//        return sessionAttr;
        return this.request.getSession(false).getAttribute(attributeName);
    }

    public void setRequestAttributes(String name,Object value) {
        this.requestAttributes.put(name, value);
    }

    public void setSessionAttributes(String name,Object value) {
        this.sessionAttributes.put(name, value);
    }
    public void sessionLogout(){
        if(this.request.getSession(false) != null){
            this.request.getSession(false).invalidate();
        }
    }
    
}
