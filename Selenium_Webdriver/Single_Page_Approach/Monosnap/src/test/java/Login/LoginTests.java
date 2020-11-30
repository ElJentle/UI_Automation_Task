package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    // import the selenium webDriver
    private WebDriver driver;

    // import chromeDriver
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromeDriver.exe");
        driver = new ChromeDriver();
        // Input project URL = Deydam login URL
        driver.get("https://monosnap.com/");
        // waiting for globally
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maximize window
        driver.manage().window().maximize();
        // get page title
        System.out.println(driver.getTitle());
        // signin navigation
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]/span")).click();
        // Locate username field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[6]/input[1]")).sendKeys("jentleesuong@yahoo.com");
        // Locate password field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[6]/input[2]")).sendKeys("jentleesuong2020");
        // Click on the sign in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();
        Thread.sleep(20000);
        // close the browser after test
        driver.quit();
    }
    // initiate the test run command
    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setup();
    }

};