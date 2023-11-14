package Pages;
import Consts.Consts;


public class HomePage extends BasePage {

    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String LOGO_ICON = "//*[@class = 'icon icon-login']";
    private static final String BY_LANGUAGE_MENU = "//*[@class = ' icon icon--wide icon-chevron-down']";

    public void navigateToHomePage() {
        webDriver.get(Consts.HOME_PAGE_URL);

    }

    public boolean isLogoVisible() {

        boolean isVisible = elementExists(LOGO_IMG);

        return isVisible;
    }

    public LoginPage openLoginPage() {
        clickElementByXpath(LOGO_ICON);
        return new LoginPage();

    }

    public ResultPage openLanguageMenu() {
        clickElementByXpath(BY_LANGUAGE_MENU);
        return new ResultPage();
    }
}