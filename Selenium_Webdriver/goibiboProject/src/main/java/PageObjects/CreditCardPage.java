package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditCardPage {

    public WebDriver driver;

    public CreditCardPage (WebDriver driver) {
        this.driver = driver;
    }

    //locate element on webpage
    private By cardNum = By.name("cardnumber");
    private By cardNam = By.name("ccname");
    private By cardExp = By.name("cardExpiry");
    private By cardCVV = By.name("cardCVV");
    private By cardAddress = By.xpath("//*[@id=\"card\"]/div[2]/div/div[4]/div/div/div[2]/div[1]/div[1]/input");
    private By cardZC = By.xpath("//*[@id=\"card\"]/div[2]/div/div[4]/div/div/div[2]/div[1]/div[2]/div[1]/input");
    private By cardCity = By.xpath("//*[@id=\"card\"]/div[2]/div/div[4]/div/div/div[2]/div[1]/div[2]/div[2]/input");
    private By cardState = By.xpath("//*[@id=\"card\"]/div[2]/div/div[4]/div/div/div[2]/div[2]/div[1]/div[1]/input");
    private By cardCDD = By.xpath("//*[@id=\"card\"]/div[2]/div/div[4]/div/div/div[2]/div[2]/div[1]/div[2]/select");
    private By cardCountry = By.xpath("//*[@id=\"card\"]/div[2]/div/div[4]/div/div/div[2]/div[2]/div[1]/div[2]/select/option[162]");
    private By payment = By.xpath("//*[@id=\"card\"]/div[2]/div/div[5]/div[3]/div[2]/button");
    private By getErrMsg = By.xpath("//*[@id=\"card\"]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/p");


    //Input card details
    public void enterCardNum (String cardNo) {
        driver.findElement(cardNum).sendKeys(cardNo);
    }
    public void enterCardNam (String cardName) {
        driver.findElement(cardNam).sendKeys(cardName);
    }
    public void enterCardExp (String expiring) {
        driver.findElement(cardExp).sendKeys(expiring);
    }
    public void enterCardCVV (String cvv) {
        driver.findElement(cardCVV).sendKeys(cvv);
    }
    //Card address details
    public void enterCardAddress (String cAddr) {
        driver.findElement(cardAddress).sendKeys(cAddr);
    }
    public void enterCardZC (String cZip) {
        driver.findElement(cardZC).sendKeys(cZip);
    }
    public void enterCardCity ( String cCity) {
        driver.findElement(cardCity).sendKeys(cCity);
    }
    public void enterCardState (String cState) {
        driver.findElement(cardState).sendKeys(cState);
    }
    public void enterCardCountry () {
        driver.findElement(cardCDD).click();
        driver.findElement(cardCountry).click();
    }
    //initiate payment
    public void clickPayment () {
        driver.findElement(payment).click();
    }
    //locate error message
    public void getErrorMessage() {
        switch (driver.findElement(getErrMsg).getText().split("")[2]) { }
    }

    //return page
    public LandingPage landingPage() {
        return new LandingPage (driver);
    }
}