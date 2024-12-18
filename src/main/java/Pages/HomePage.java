package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase {

    //locators
    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Login");
    private final By logoutLink = By.linkText("Logout");
    private final By myAccountLink = By.linkText("My account");
    private final By contactUsLink = By.linkText("Contact Us");
    private final By myAccountDropDown = By.cssSelector("a[class=dropdown-toggle]");
    private final By currencyDropDown = By.id("form-currency");
    private final By euroCurrency = By.name("EUR");
    private final By deskTopDropDown = By.linkText("Desktops");
    private final By macOption = By.linkText("Mac (1)");
    public By currencyLogo = By.xpath("//button[@class='btn btn-link dropdown-toggle']//strong");
    public By productName = By.xpath("//div[@id='content']//h2");

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
    }

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

    public void clickOnCurrencyDropDown() {
        clickOnButton(currencyDropDown);
    }

    public void selectEuro() {
        clickOnButton(euroCurrency);
    }

    public void hoverOverDesktop() {
        WebElement deskDropDown = driver.findElement(deskTopDropDown);
        action.moveToElement(deskDropDown).build().perform();
    }

    public void selectMacOption() {
        WebElement macOpt = driver.findElement(macOption);
        action.moveToElement(macOpt).click().build().perform();
    }

    //assert
    public boolean assertThatUserLoggedIn() {
        clickOnButton(myAccountDropDown);
        find(logoutLink).isDisplayed();
        return true;
    }

    public String assertThatCurrencyIsEuro() {
        return find(currencyLogo).getText();
    }

    public boolean asserThatUserNavigatedToProduct() {
        find(productName).isDisplayed();
        return true;
    }


}
