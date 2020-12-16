package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class setUps {

    public static LoginPage loginPage;

    //Create a WebDriver Object
    public WebDriver driver;

    public setUps (WebDriver driver) {
        this.driver = driver;
    }

    @BeforeTest
    public void setUp(){
        //importation of chromeDriver
        System.setProperty ("webdriver.chrome.driver", "resources/chromeDriver.exe");
        //instantiate a webDriver object
        driver = new ChromeDriver();
        //maximize window size
        driver.manage().window().maximize();
        //launch the application URL and wait
        driver.get ("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //instantiate login page after launching the browser - handle
        new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
