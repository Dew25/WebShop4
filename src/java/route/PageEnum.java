
package route;

import command.CurrentPage;
import command.CheckLoginPage;
import command.LoginPage;
import command.LogoutPage;
import command.NewUserPage;
import command.ProductPage;
import command.RegistrationPage;


/**
 *
 * @author jvm
 */
public enum PageEnum {
   
    PRODUCT{
        {
           this.page = new ProductPage();
        }
    },
    LOGIN{
        {
           this.page = new LoginPage();
        }
    },
    CHECKLOGIN{
        {
           this.page = new CheckLoginPage();
        }
    },
    LOGOUT{
        {
           this.page = new LogoutPage();
        }
    },
    NEWUSER{
        {
           this.page = new NewUserPage();
        }
    },
    REGISTRATION{
        {
           this.page = new RegistrationPage();
        }
    };
    CurrentPage page;
    
    public CurrentPage getCurrentPage(){
        return page;
    }
    
}
