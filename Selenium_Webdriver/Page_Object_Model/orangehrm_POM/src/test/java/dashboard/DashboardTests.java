package dashboard;

import login.LoginTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;

import static pageObjects.LoginPage.dashboardPage;
import static pageObjects.setUps.loginPage;

public class DashboardTests{

    @Test(priority = 2)
    public void testAPageTitle () throws InterruptedException {
        loginPage.enterUsername ("Admin");
        loginPage.enterPassword ("admin123");
        DashboardPage dashboardPage = loginPage.clickLoginButton ();
        //confirm that user is in dashboard using URL
        String dashboardUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals (dashboardPage.getDashboardPageUrl(), dashboardUrl, "You are on user dashboard");
        Thread.sleep (10000);
    }

    @Test(priority = 2)
    public void testPendingLeaveRequests () throws InterruptedException {
        String expectedLeaveDate = "01. Mathews 03-08-2020";
        Assert.assertEquals(expectedLeaveDate.compareToIgnoreCase(dashboardPage.getLeaveRequest())
        {
    }

    @Test (priority = 2)
    //this class extend to the SetupTests as the SetupTests class contains all the setup requirements to run our test
    public void testLogout() throws InterruptedException {
        //handler for dashboard pag
        dashboardPage.clickWelcome();
        dashboardPage.clickLogout();
        Thread.sleep (1000);
        String loginPageURL = "https://opensource-demo.orangehrmlive.com/";
        Assert.assertEquals(loginPage.getLoginPageURL(), loginPageURL, "You are not on user dashboard");
        Thread.sleep (10000);
    }
}
