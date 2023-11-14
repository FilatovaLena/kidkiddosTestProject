package Pages;

public class LoginPage extends BasePage{

    public static final String LOGIN_HEADER = "//*[text() = 'Login']";

    public boolean isLoginHeaderVisible(){
     return elementExists(LOGIN_HEADER);

    }



}
