package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    // import the selenium webDriver
    private WebDriver driver;
    // import chromeDriver
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromeDriver.exe");
        driver = new ChromeDriver();
        // Input project URL = Deydam login URL
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