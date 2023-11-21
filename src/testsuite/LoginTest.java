package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Create the package ‘testsuite’ and create the following class inside
 * the ‘testsuite’ package.
 * 1. LoginTest
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    /**
     * 3. Write down the following test into ‘LoginTest’ class
     * 1. userSholdLoginSuccessfullyWithValid Credentials
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
         //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //Verify the Products text is displayed
        String expectedResult = "Products";
        String actualResult = driver.findElement(By.xpath("//span[@class='title']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult, actualResult);
        Thread.sleep(2000);

    }

    /**
     * 2. verifyThatSixProductsAreDisplayedOnPage
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed on page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Total number of products = " + driver.findElements(By.xpath("//div[@class='inventory_item_name ']")).size());
    }
    @After
    public void setDown(){
        closeBrowser();
    }
}
