import Pages.HomePage;
import Pages.LoginPage;
import Pages.ResultPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class HomePageTest extends UseCaseBase {
    private static HomePage homePage;


    @BeforeAll
    public static void classSetup(){
        homePage  = new HomePage();

   }

   @BeforeEach
   public void beforeTest(){
        homePage.navigateToHomePage();
   }
    @Test
    public void homePageLoadTest(){
        boolean success = homePage.isLogoVisible();
        assertTrue(success);

    }

    @Test
    public void openLoginPageTest(){
     LoginPage loginPage = homePage.openLoginPage();
     boolean isLoaded = loginPage.isLoginHeaderVisible();
     assertTrue(isLoaded);
    }

    @Test
    public void openBookByLanguageDropMenu() throws InterruptedException {

        webDriver.findElement(By.xpath("//*[@aria-controls = 'SiteNavLabel-books-by-language']")).click();
        Thread.sleep(1000);
        assertNotNull(webDriver.findElement(By.xpath("//*[text()= 'English Only']")));
        webDriver.findElement(By.xpath("//*[text()= 'English Only']")).click();
        Thread.sleep(1000);
        assertNotNull(webDriver.findElement(By.xpath("//h1[. ='English Only']")));
//        assertNotNull(webDriver.findElement(By.xpath("//*[@class = 'section-header text-center']")));
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("window.scrollBy(0,1400)"); //(x,y) x=righ left y=up down
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//i[@class='_close-icon']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[.=\"I Love to Sleep in My Own Bed (Children's Bedtime Story - English Only)\"]")).click();
        Thread.sleep(1000);
        assertNotNull(webDriver.findElement(By.xpath("//h1[. =\"I Love to Sleep in My Own Bed (Children's Bedtime Story - English Only)\"]")));

        webDriver.findElement(By.xpath("//*[@id ='SingleOptionSelector-0']")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@value =\"Hardcover\"]")).click();
        String Value = webDriver.findElement(By.xpath("//*[@id ='SingleOptionSelector-0']")).getAttribute("value");

        assertEquals("Hardcover", Value);


        webDriver.findElement(By.xpath("//*[@id ='Quantity']")).click();
        Thread.sleep(1000);

        WebElement bookAmount = webDriver.findElement(By.xpath("//*[@id ='Quantity']"));
        assertNotNull(bookAmount);

        bookAmount.clear();
        Thread.sleep(2000);
        bookAmount.sendKeys("5");

        String bookNumber=bookAmount.getAttribute("value");
        assertEquals("5", bookNumber);


        webDriver.findElement(By.xpath("//*[@id ='AddToCartText-product-template']")).click();
        Thread.sleep(1000);

        WebElement AddToCartPage = webDriver.findElement(By.xpath("//h1[. ='Your cart']"));
        assertNotNull(AddToCartPage);

        webDriver.findElement(By.xpath("//input[@class =\"cart__qty-input\"]")).click();
        Thread.sleep(1000);

        WebElement addedBookAmount = webDriver.findElement(By.xpath("//input[@class =\"cart__qty-input\"]"));
        assertNotNull(addedBookAmount);

        addedBookAmount.clear();
        Thread.sleep(2000);
        addedBookAmount.sendKeys("6");

        JavascriptExecutor jvs = (JavascriptExecutor)webDriver;
        jvs.executeScript("window.scrollBy(0,1200)"); //(x,y) x=righ left y=up down
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//*[@class=\"btn btn--secondary cart__update cart__update--large small--hide\"]")).click();
        Thread.sleep(1000);

        WebElement updatedBookAmount = webDriver.findElement(By.xpath("//input[@class =\"cart__qty-input\"]"));
        String updatedBookNumber= updatedBookAmount.getAttribute("value");
        assertEquals("6", updatedBookNumber);

//        WebElement totalPrice = webDriver.findElement(By.xpath("//span[@class = \"cbb-price-digits\"]"));
//        WebElement totalPrice = webDriver.findElement(By.xpath("//span[text() = '203.94']"));
//        String updatedTotalPrice = totalPrice.getAttribute("price");
//        assertEquals("203.94", updatedTotalPrice);

        webDriver.findElement(By.xpath("//span[text() = '203.94']")).click();
        Thread.sleep(1000);
        assertNotNull(webDriver.findElement(By.xpath("//span[text() = '203.94']")));
    }



    }


