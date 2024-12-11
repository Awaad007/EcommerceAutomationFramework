package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public CheckoutPage userSelectNewAddress(){
        clickOnButton(newAddressRadioBtn);
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
        clickOnButton(continueDetailsBtn);
        return this;
    }
    public CheckoutPage clickDeliveryContinueBtn(){
        clickOnButton(continueDeliveryBtn);
        return this;
    }
    public CheckoutPage clickPaymentContinueBtn(){
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
