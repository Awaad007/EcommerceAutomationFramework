package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends PageBase {


    //locators
    private final By quantityField = By.xpath("//input[contains(@name,'quantity')]");
    private final By updateBtn = By.xpath("//button[@data-original-title='Update']");
    private final By estimateShippingLink = By.xpath("//a[@href='#collapse-shipping']");
    private final By selectCountry = By.id("input-country");
    private final By selectState = By.id("input-zone");
    private final By postalCodeField = By.id("input-postcode");
    private final By quotesBtn = By.id("button-quote");
    private final By radioBtn = By.name("shipping_method");
    private final By applyShippingBtn = By.id("button-shipping");
    private final By checkoutBtn = By.linkText("Checkout");
    private final By message = By.xpath("//div[contains(@class,'alert-success')]");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void changeProductQuantity(String productQuantity) {
        clearElementText(quantityField);
        setElementText(quantityField, productQuantity);
    }

    public void clickOnUpdateBtn() {
        clickOnButton(updateBtn);
    }

    public ShoppingCartPage clickOnEstimationShippingLink() {
        clickOnButton(estimateShippingLink);
        return this;
    }

    public ShoppingCartPage selectCountry(String country) {
        WebElement countryList = driver.findElement(selectCountry);
        wait.until(ExpectedConditions.visibilityOf(countryList));
        select = new Select(countryList);
        select.selectByVisibleText(country);
        return this;
    }

    public ShoppingCartPage selectState(String state) {
        WebElement stateList = driver.findElement(selectState);
        wait.until(ExpectedConditions.visibilityOf(stateList));
        select = new Select(stateList);
        select.selectByVisibleText(state);
        return this;
    }

    public ShoppingCartPage setPostalCode(String postalCode) {
        setElementText(postalCodeField, postalCode);
        return this;
    }

    public ShoppingCartPage clickOnQuoteBtn() {
        clickOnButton(quotesBtn);
        return this;
    }

    public void checkRadioBtn() {
        clickOnButton(radioBtn);
    }

    public void clickOnApplyShipping() {
        clickOnButton(applyShippingBtn);
    }

    public void userClickOnCheckoutBtn() {
        clickOnButton(checkoutBtn);
    }

    //assert
    public boolean assertThatShippingEstimateApplied() {
        find(message).isDisplayed();
        return true;
    }

}
