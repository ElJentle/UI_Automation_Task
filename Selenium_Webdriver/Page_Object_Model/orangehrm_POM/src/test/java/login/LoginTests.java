package login;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import static pageObjects.setUps.loginPage;

public class LoginTests {

    @Test (priority = 1)
    public void testAloginPanel () {
        loginPage.verifyLoginPanel ();
    }

    @Test (priority = 1)
    public void testACompanyLogo () {
        loginPage.verifyCompanyLogo ();
    }

    @Test (priority = 1)
    public void testAForgotPassword () {
        loginPage.verifyForgotPassword ();
    }

    @Test (priority = 1)
    public void testAPageTitle () throws InterruptedException {
        loginPage.enterUsername ("Admin");
        loginPage.enterPassword ("admin123");
        DashboardPage dashboardPage = loginPage.clickLoginButton ();
        //check whether the pageTitle is correct
        String pageTitle = loginPage.pageTitle();
        if (pageTitle.equalsIgnoreCase("OrangeHRM")) {
            System.out.println("The page title is " + pageTitle);
        } else {
            System.out.println("The page title is incorrect. Actual page title is " + pageTitle);
        }
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public DashboardPage getDashboardPage () {
        loginPage.verifyLoginPanel();
        return null;
    }
}
