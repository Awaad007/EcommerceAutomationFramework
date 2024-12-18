package Pages;

import Common.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase {

    //locators
    private final By newAddressRadioBtn = By.xpath("//input[contains(@value,'new')]");
    private final By firstNameTxtField = By.id("input-payment-firstname");
    private final By lastNameTxtField = By.id("input-payment-lastname");
    private final By addressTxtField = By.id("input-payment-address-1");
    private final By cityTxtField = By.id("input-payment-city");
    private final By postalCodeTxtField = By.id("input-payment-postcode");
    private final By selectCountry = By.id("input-payment-country");
    private final By selectState = By.id("input-payment-zone");
    private final By continueBillingBtn = By.id("button-payment-address");
    private final By continueDetailsBtn = By.id("button-shipping-address");
    private final By continueDeliveryBtn = By.id("button-shipping-method");
    private final By continuePaymentBtn = By.id("button-payment-method");
    private final By checkTerms = By.xpath("//input[contains(@name,'agree')]");
    private final By confirmBtn = By.id("button-confirm");
    private final By confirmationMsn = By.xpath("//div[@id= 'content']/child::h1");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    //methods

    public CheckoutPage userSelectNewAddress() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement radioButton = shortWait.until(ExpectedConditions.presenceOfElementLocated(newAddressRadioBtn));

            if (radioButton.isDisplayed()) {
                System.out.println("Radio button is visible. Clicking on it.");
                radioButton.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Radio button is not present. Proceeding with creating a new address.");
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return this;
    }

    public CheckoutPage userEnterFirstName(String firstName) {
        setElementText(firstNameTxtField, firstName);
        return this;
    }

    public CheckoutPage userEnterLastName(String lastName) {
        setElementText(lastNameTxtField, lastName);
        return this;
    }

    public CheckoutPage userEnterAddress(String address) {
        setElementText(addressTxtField, address);
        return this;
    }

    public CheckoutPage userEnterCity(String city) {
        setElementText(cityTxtField, city);
        return this;
    }

    public CheckoutPage userEnterPostalCode(String postalCode) {
        setElementText(postalCodeTxtField, postalCode);
        return this;
    }

    public CheckoutPage selectCountry(String country) {
        WebElement countryList = driver.findElement(selectCountry);
        select = new Select(countryList);
        select.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage selectState(String state) {
        WebElement stateList = driver.findElement(selectState);
        select = new Select(stateList);
        select.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage clickBillingContinueBtn() {
        clickOnButton(continueBillingBtn);
        return this;
    }

    public CheckoutPage clickDetailsContinueBtn() {
        WebElement element = find(continueDetailsBtn);
        wait.until(ExpectedConditions.visibilityOf(element));
        clickOnButton(continueDetailsBtn);
        return this;
    }

    public CheckoutPage clickDeliveryContinueBtn() {
        WebElement element = find(continueDeliveryBtn);
        wait.until(ExpectedConditions.visibilityOf(element));
        clickOnButton(continueDeliveryBtn);
        return this;
    }

    public CheckoutPage clickPaymentContinueBtn() {
        WebElement element = find(continuePaymentBtn);
        wait.until(ExpectedConditions.visibilityOf(element));
        clickOnButton(continuePaymentBtn);
        return this;
    }

    public CheckoutPage checkTermsBox() {
        clickOnButton(checkTerms);
        return this;
    }

    public CheckoutPage clickOnConfirmOrderBtn() {
        clickOnButton(confirmBtn);
        return this;
    }

    //assert
    public String assertThatOrderPlacedSuccessfully() {
        wait.until(ExpectedConditions.urlToBe("https://awesomeqa.com/ui/index.php?route=checkout/success"));
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOf(find(confirmationMsn)));
        return confirmationMessage.getText();
    }
}
