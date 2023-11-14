package Utils;

import Pages.BasePage;
import org.example.Main;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static Consts.Consts.HOME_PAGE_URL;

public class UseCaseBase {

    protected static WebDriver webDriver;
    private static BasePage page;


    @BeforeAll
    public static void setupMain(){
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver();
        webDriver.get(HOME_PAGE_URL);
        page.setWebDriver(webDriver);
    }

//    @AfterAll
//    public static void classTearDown() {
//        SharedDriver.closeDriver();
//        webDriver = null;
//    }

//    @AfterEach
//    public void testTearDown() {
//
//        webDriver.get(HOME_PAGE_URL);
//    }


}
