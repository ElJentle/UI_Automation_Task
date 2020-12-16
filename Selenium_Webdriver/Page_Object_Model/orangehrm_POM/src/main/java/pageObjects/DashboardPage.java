package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    //using By to locate dashboardPage elements
    private By welcome = By.id("welcome");
    private By logoutButton = By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a");
    private By pendingLeaveRequest = By.xpath("");

    //confirm the dashboard URL
    public String getDashboardPageUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
        return driver.getCurrentUrl();
    }

    public void clickWelcome () throws InterruptedException {
        Thread.sleep(10000);
        //find the welcome element and click on the welcome button
        driver.findElement(welcome).click();
    }

    public LoginPage clickLogout() throws InterruptedException {
        Thread.sleep(3000);
        //find the logout and click on the logout button
        driver.findElement(logoutButton).click();
        return new LoginPage (driver);
    }

    public void getLeaveRequest() throws InterruptedException {
        Thread.sleep(3000);
        //find the logout and click on the logout button
        driver.findElement(pendingLeaveRequest).getText();
    }
}
