package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static DashboardPage dashboardPage;

    private WebDriver driver;

    //using by as a to identify the login fields
    private By username = By.id("textUsername");
    private By password = By.id("textPassword");
    private By loginButton = By.id("btnLogin");
    private By companyLogo = By.xpath("//*[@id=\"divLogo\"]/img");
    private By forgotPassword = By.xpath("//*[@id=\"forgotPasswordLink\"]/a");
    private By loginPanel = By.xpath("/html//div[@id='logInPanelHeading']");

    public void verifyCompanyLogo (){
        //find the company logo element and verify
        driver.findElement (companyLogo).isDisplayed();
    }
    public void verifyForgotPassword (){
        //find the forgot password element
        driver.findElement(forgotPassword).isDisplayed();
    }
    public void verifyLoginPanel (){
        //find the username element and enter the username
        List<WebElement> list = (List<WebElement>) driver.findElement(loginPanel);
    }
    public void enterUsername (String uName){
        //find the username element and enter username
        driver.findElement(username).sendKeys("uName");
    }
    public void enterPassword (String pwd) {
        //find the password element and enter password
        driver.findElement(password).sendKeys("pwd");
    }
    public DashboardPage clickLoginButton (){
        //find and click on the login button
        driver.findElement(loginButton).click();
        return new DashboardPage (driver);
    }
    public String getLoginPageURL(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/"));
        return driver.getCurrentUrl();
    }

    public String pageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("OrangeHRM"));
        return driver.getTitle();
    }

}
