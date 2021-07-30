package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelBookingPage {
    public WebDriver driver;

    public HotelBookingPage (WebDriver driver) {
        this.driver = driver;
    }

    //locate element on webpage
    //private By chooseName = By.xpath("//*[@id=\"root\"]/div[2]/div/section[2]/div[2]/div/div[2]/div/div[1]");

    private By selectName = By.xpath("//*[@id=\"root\"]/div[2]/div/section[2]/div[2]/div/div[2]/div/div[1]"); //("//*[@id=\"root\"]/div[2]/div/section[2]/div[2]/div/div[2]/div/div[1]"); // "//*[@id=\"root\"]/div[2]/div/section[2]/div[2]/div/div[2]/div/div[1]/div[1]/div");
    private By hotelName = By.xpath("//*[@id=\"root\"]/div[2]/div/section[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div[2]/h4"); //("//*[@id=\"root\"]/section[1]/section[3]/section/div/div[2]/h1");
    private By selectRM = By.xpath("//*[@id=\"3\"]/div[2]/div[1]/div[2]/div[2]");
    private By verifyNM = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h4");
    private By firstNM = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/input");
    private By lastNM = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[3]/input");
    private By gtEmail = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[1]/input");
    private By CCNumDD = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[3]/div[1]/div/select");
    private By CCNum = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[3]/div[1]/div/select/option[162]");
    private By phoneNUM = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[3]/div[1]/div/input");
    private By goPayment = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button");



    //select a hotel
    public void selectName() {
        driver.findElement(selectName).click();
    }
    //get hotel name
    public  String getHotelName() {
       String result = driver.findElement(hotelName).getText().split(" ")[2];
        System.out.println(result);
        return null;
    }
    //select room button
    public void selectRoom() throws InterruptedException{
        driver.findElement(selectRM).click();
    }
    //verify room name
    public String verifyRoomName () {
      String resultName =  driver.findElement(verifyNM).getText().split("")[2];
      System.out.println(resultName);
      return null;
    }
    //first name field
    public void enterFirstName (String fname) {
        driver.findElement(firstNM).sendKeys(fname);
    }
    //last name field
    public void enterLastName(String lname) {
        driver.findElement(lastNM).sendKeys(lname);
    }
    //email field
    public void enterEmail(String mail) {
        driver.findElement(gtEmail).sendKeys(mail);
    }
    //phone number field
    public void selectCountryCode() throws InterruptedException {
        driver.findElement(CCNumDD).click();
        driver.findElement(CCNum).click();
    }
    public void enterPhone(String phone) {
        driver.findElement(phoneNUM).sendKeys(phone);
    }
    //proceed to payment
    public CreditCardPage paymentButton() {
        driver.findElement(goPayment).click();
        return new CreditCardPage (driver);
    }
}
