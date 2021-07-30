package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelsMenuPage {
    //instantiate webdriver
    public WebDriver driver;

    public HotelsMenuPage (WebDriver driver) {
        this.driver = driver;
    }


    //locate element on webpage
    private By autoArea = By.xpath("//*[@id=\"downshift-1-menu\"]");
    private By selectCountryType = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/div[1]/div[1]/h4");
    private By checkIn = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/div[3]/div/div[1]/div/div");
    private By inDate = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div/div[2]/div/div/ul[2]/li[26]");
    private By checkOut = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[4]/div/div");
    private By outDate = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[4]/div[2]/div/div/div[2]/div/div/ul[2]/li[27]"); //("//*[@id="root"]/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[4]/div[2]/div/div/div[2]/div/div/ul[2]/li[27]/span");
    private By guestNo = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/div[4]/span");
    private By oneGuest = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/span[1]");
    private By guestDone = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[4]/button");
    private By searchGo = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/button");

    //select country type
    public void countryType() {
        driver.findElement(selectCountryType).click();
    }
    //enter hotel location
    public void enterHotelArea(String hArea) throws InterruptedException{
        WebElement hotelArea = driver.findElement(By.id("downshift-1-input"));
        hotelArea.sendKeys(hArea);
    }
    public void autoSelectArea() {
        driver.findElement(autoArea).click();
    }
    //select check-in date (23 july)
    public void clickCheckIn() {
        driver.findElement(checkIn).click();
    }
    public void checkInDate() {
        driver.findElement(inDate).click();
    }
    //select check-out date ( july)
    public void clickCheckOut()  {
        driver.findElement(checkOut).click();
    }
    public void CheckOutDate() {
        driver.findElement(outDate).click();
    }
    //select number of guest (1)
    public void clickRG() {
        driver.findElement(guestNo).click();
    }
    public void selectGuest() {
        driver.findElement(oneGuest).click();
        driver.findElement(guestDone).click();
    }

    //search hotels
    public HotelBookingPage clickSearch() {
        driver.findElement(searchGo).click();
        return new HotelBookingPage(driver);
    }

}