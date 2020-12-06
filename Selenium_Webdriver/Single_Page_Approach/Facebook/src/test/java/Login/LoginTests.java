package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    // import the selenium webDriver
    private WebDriver driver;
    // import chromeDriver
    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromeDriver.exe");
        driver = new ChromeDriver();
        // Input project URL = facebook login URL
        driver.get("https://www.facebook.com/login");
        // waiting for globally
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maximize window
        driver.manage().window().maximize();
        // get page title
        System.out.println(driver.getTitle());
        // Locate username field
        driver.findElement(By.id("email")).sendKeys("07068578879");
        // Locate password field
        driver.findElement(By.id("pass")).sendKeys("09076368799");
        // Click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 0)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl ().contains ("https://web.facebook.com"))
            //Pass
            System.out.println ("The Page URL contains //web.");
        else
            //Fail
            System.out.println ("The Page URL does not contain //web.");
    }

    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the account button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[1]/span/div/div[1]/i")).click ();
        Thread.sleep (5000);
        //click on the logout button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div")).click ();
        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://www.facebook.com/login"))
            //Pass
            System.out.println ("The Login page URL contains /login");
        else
            //Fail
            System.out.println ("The Login URL does not contain /login");
    }

    @Test(priority = 1)
    public void testNegativeLogin(){
        driver.findElement (By.id ("email")).sendKeys ("97887586070");
        driver.findElement (By.id ("pass")).sendKeys ("09076368799.");
        driver.findElement (By.name ("login")).click ();
        String expectedErrorMessage = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        String actualErrorMessage = driver.findElement(By.xpath ("//*[@id=\"email_container\"]/div[2]")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    // initiate the test run command
    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setup();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}