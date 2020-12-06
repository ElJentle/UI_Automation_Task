package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        // Input project URL = monosnap login URL
        driver.get("https://monosnap.com/");
        // waiting for globally
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maximize window
        driver.manage().window().maximize();
        // get page title
        System.out.println(driver.getTitle());
        // signin navigation
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]/span")).click();
        // Locate email field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("jentleesuong@yahoo.com");
        // Locate password field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("jentleesuong2020");
        // Click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();

        //*[@id="store"]/div[4]/div/div[1]/div/div[3]/div[3]
        //*[@id="store"]/div[4]/div/div[1]/div/div[1]/div[2]

        Thread.sleep(2000);
    }
    @Test(priority = 0)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl ().contains ("https://monosnap.com/list/5fc3b45c8a2e603563a86ae1"))
            //Pass
            System.out.println ("The Page URL contains /list/5fc3b45c8a2e603563a86ae1");
        else
            //Fail
            System.out.println ("The Page URL does not contain /list/5fc3b45c8a2e603563a86ae1.");
    }

    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the setting button
        driver.findElement (By.xpath ("//*[@id=\"store\"]/div[4]/div/div[1]/div/div[3]/div[3]")).click ();
        Thread.sleep (5000);
        //click on the logout button
        driver.findElement (By.xpath ("//*[@id=\"store\"]/div[4]/div/div[1]/div/div[1]/div[2]")).click ();
        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://monosnap.com"))
            //Pass
            System.out.println ("The Login page URL contains /signin");
        else
            //Fail
            System.out.println ("The Login URL does not contain /signin");
        Thread.sleep (4000);
    }

    @Test(priority = 1)
    public void testNegativeLogin(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]/span")).click();
        // Locate email field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("jentleesuong@gmail.com");
        // Locate password field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("jentleesuong2020");
        // Click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();
        String expectedErrorMessage = "Wrong email or password\n" +
                "Please check if you've typed your email and password correctly.";
        String actualErrorMessage = driver.findElement(By.xpath ("//*[@id=\"root\"]/div[1]/div/div/div/div")).getText();
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