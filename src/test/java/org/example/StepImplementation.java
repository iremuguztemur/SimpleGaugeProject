package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.example.BaseTest;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.logging.Logger;
import java.util.HashSet;
import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest{

    private final static Logger logger = Logger.getLogger(StepImplementation.class.getName());
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private static By addToCart = By.xpath("//div[@class='pricebar']//button");
    private static By emailTextbox = By.id("user-name");
    private static By passwordTextbox = By.id("password");
    private static By loginButton = By.id("login-button");


    @Step("Enter email address <email>")
    public void enterEmailAddress(String email) {
        WebElement emailElement = driver.findElement(emailTextbox);
        emailElement.sendKeys(email);
    }
    @Step("Enter password <password>")
    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordTextbox);
        passwordElement.sendKeys(password);
    }
    @Step("Click on the login button")
    public void clickLoginButton() throws InterruptedException, IOException{
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshots/"+"verifyHomePage.png"));
        logger.info("Clicked on the login button");
    }
    @Step("Add first item to cart")
    public void AddItemToCart() throws InterruptedException, IOException{
        WebElement addItem = driver.findElement(addToCart);
        addItem.click();
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshots/"+"addItemToCart.png"));
        Assert.assertTrue("Item not found!", list.size() > 0);
        logger.info(list+ " Item added");
    }

    @Step("Verify the home page via <text>")
    public void textControl(String text) throws InterruptedException, IOException {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshots/"+text+"controlHomePage.png"));
        Assert.assertTrue("Text not found!", list.size() > 0);
        logger.info(text+ " text found");

    }

    @Step("Open the login page <address>")
    public void goToURL(String address) throws IOException {
        driver.get(address);
        logger.info(address+" adresine gidildi");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshots/loginPageControl.png"));
    }


}
