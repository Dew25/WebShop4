
package route;

import command.CurrentPage;
import command.ProductPage;


/**
 *
 * @author jvm
 */
public enum PageEnum {
   
    PRODUCT{
        {
           this.page = new ProductPage();
        }
    };
    CurrentPage page;
    
    public CurrentPage getCurrentPage(){
        return page;
    }
    
}
