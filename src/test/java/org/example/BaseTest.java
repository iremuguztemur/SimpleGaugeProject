package org.example;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeScenario
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");

        String baseUrl = "https://google.com.tr/";

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Firefox dimension
        //driver.manage().window().setSize(new Dimension(1024, 768));
    }


    @AfterScenario
    public void tearDown() {
        driver.quit();
    }


}