package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    //locators

    private final By emailTxt = By.id("input-email");
    private final By passwordTxt = By.id("input-password");
    private final By loginBtn = By.cssSelector("input[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //methods

    public void userEnterEmail(String email) {
        setElementText(emailTxt, email);
    }

    public void userEnterPassword(String pass) {
        setElementText(passwordTxt, pass);
    }

    public void clickOnLoginBtn() {
        clickOnButton(loginBtn);
    }

}
