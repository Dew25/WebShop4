
package command;

import resource.SessionRequestContent;
import route.PageEnum;

/**
 *
 * @author jvm
 */
public class PageFactory {

    public PageFactory() {
    }
    
    public CurrentPage definePage(SessionRequestContent sessionRequestContent){
        CurrentPage current = new EmptyPage();
        String page = sessionRequestContent.getRequestParameterValue("page");
        if(page == null || page.isEmpty()){
            return current;
        }
        try {
            PageEnum pageEnum = PageEnum.valueOf(page.toUpperCase());
            current = pageEnum.getCurrentPage();
            return current;
        } catch (IllegalArgumentException e) {
            sessionRequestContent.setRequestAttributes("error","Не существует страницы "+page);
            return current = new EmptyPage();
        }
        
    }
    
    
}
