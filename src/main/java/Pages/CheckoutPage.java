package Pages;

import Common.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By newAddressRadioBtn = By.xpath("//input[contains(@value,'new')]");
    By firstNameTxtField = By.id("input-payment-firstname");
    By lastNameTxtField = By.id("input-payment-lastname");
    By addressTxtField = By.id("input-payment-address-1");
    By cityTxtField = By.id("input-payment-city");
    By postalCodeTxtField = By.id("input-payment-postcode");
    By selectCountry = By.id("input-payment-country");
    By selectState = By.id("input-payment-zone");
    By continueBillingBtn = By.id("button-payment-address");
    By continueDetailsBtn = By.id("button-shipping-address");
    By continueDeliveryBtn = By.id("button-shipping-method");
    By continuePaymentBtn = By.id("button-payment-method");
    By checkTerms = By.xpath("//input[contains(@name,'agree')]");
    By confirmBtn = By.id("button-confirm");
    By confirmationMsn = By.xpath("//div[@id= 'content']/child::h1");
    //methods

    public CheckoutPage userSelectNewAddress() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // Temporarily disable implicit wait
        try {
            // Wait for up to 5 seconds for the radio button to appear in the DOM
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement radioButton = shortWait.until(ExpectedConditions.presenceOfElementLocated(newAddressRadioBtn));

            if (radioButton.isDisplayed()) {
                System.out.println("Radio button is visible. Clicking on it.");
                radioButton.click(); // Perform the click directly
            }
        } catch (TimeoutException e) {
            System.out.println("Radio button is not present. Proceeding with creating a new address.");
        }
        finally {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Restore implicit wait
    }
        return this;
    }

    public CheckoutPage userEnterFirstName(String firstName){
        setElementText(firstNameTxtField,firstName);
        return this;
    }
    public CheckoutPage userEnterLastName(String lastName){
        setElementText(lastNameTxtField,lastName);
        return this;
    }
    public CheckoutPage userEnterAddress(String address){
        setElementText(addressTxtField,address);
        return this;
    }

    public CheckoutPage userEnterCity(String city){
        setElementText(cityTxtField,city);
        return this;
    }

    public CheckoutPage userEnterPostalCode(String postalCode){
        setElementText(postalCodeTxtField,postalCode);
        return this;
    }

    public CheckoutPage selectCountry(String country){
        WebElement countryList = driver.findElement(selectCountry);
        select = new Select(countryList);
        select.selectByVisibleText(country);
        return this;
    }
    public CheckoutPage selectState(String state){
        WebElement stateList = driver.findElement(selectState);
        select = new Select(stateList);
        select.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage clickBillingContinueBtn(){
        clickOnButton(continueBillingBtn);
        return this;
    }
    public CheckoutPage clickDetailsContinueBtn(){
        WebElement element = find(continueDetailsBtn);
        wait.until(ExpectedConditions.visibilityOf(element));
        clickOnButton(continueDetailsBtn);
        return this;
    }
    public CheckoutPage clickDeliveryContinueBtn(){
        WebElement element = find(continueDeliveryBtn);
        wait.until(ExpectedConditions.visibilityOf(element));
        clickOnButton(continueDeliveryBtn);
        return this;
    }
    public CheckoutPage clickPaymentContinueBtn(){
        WebElement element = find(continuePaymentBtn);
        wait.until(ExpectedConditions.visibilityOf(element));
        clickOnButton(continuePaymentBtn);
        return this;
    }

    public CheckoutPage checkTermsBox(){
        clickOnButton(checkTerms);
        return this;
    }

    public CheckoutPage clickOnConfirmOrderBtn(){
        clickOnButton(confirmBtn);
        return this;
    }

    //assert
    public String assertThatOrderPlacedSuccessfully(){
        wait.until(ExpectedConditions.urlToBe("https://awesomeqa.com/ui/index.php?route=checkout/success"));
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOf(find(confirmationMsn)));
        return confirmationMessage.getText();
    }
}
