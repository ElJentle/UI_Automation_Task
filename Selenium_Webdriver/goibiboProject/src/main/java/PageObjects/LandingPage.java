package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    //instantiate webdriver
    public WebDriver driver;

    public LandingPage (WebDriver driver) {
        this.driver = driver;
    }

    //locate element on webpage
    private By clickHotels = By.xpath("//*[@id=\"root\"]/div[1]/header/ul/li[2]/a");
    public HotelsMenuPage clickHotels() throws InterruptedException {
        //click on Hotels
        Thread.sleep(1000);
        driver.findElement(clickHotels).click();
        return new HotelsMenuPage(driver);
    }

}
