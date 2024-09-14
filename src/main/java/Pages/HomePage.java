package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    //locators
    By registerLink = By.linkText("Register");
    By loginLink = By.linkText("Login");
    By logoutLink = By.linkText("Logout");
    By myAccountLink = By.linkText("My account");
    By contactUsLink = By.linkText("Contact Us");
    By myAccountDropDown = By.cssSelector("a[class=dropdown-toggle]");
    By currencyDropDown = By.id("form-currency");
    By euroCurrency = By.name("EUR");
    public By CurrencyLogo = By.xpath("//button[@class='btn btn-link dropdown-toggle']//strong");

    //methods
    public void openRegisterPage() {
        clickOnButton(myAccountDropDown);
        clickOnButton(registerLink);
    }

    public void openLoginPage() {
        clickOnButton(myAccountDropDown);
        clickOnButton(loginLink);
    }

    public void openMyAccountPage() {
        clickOnButton(myAccountLink);
    }

    public void openContactUsPage() {
        scrollToBottom();
        clickOnButton(contactUsLink);
    }

    public void clickOnCurrencyDropDown(){
        clickOnButton(currencyDropDown);
    }
    public void selectEuro(){
        clickOnButton(euroCurrency);
    }

    //assert
    public boolean assertThatUserLoggedIn() {
        clickOnButton(myAccountDropDown);
        find(logoutLink).isDisplayed();
        return true;
    }

    public String assertThatCurrencyIsEuro(){
        return find(CurrencyLogo).getText();
    }


}
