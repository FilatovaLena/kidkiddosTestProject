package Pages;

public class ResultPage extends BasePage{

    public static final String LANGUAGE_DROP_MENU = "//*[@class = 'site-nav__link site-nav__link--main']";

    public boolean isDropMenuOpen() {
        return elementExists(LANGUAGE_DROP_MENU);
    }
    public boolean elementExists(String languageDropMenu){
        return elementExists(LANGUAGE_DROP_MENU);
    }
}