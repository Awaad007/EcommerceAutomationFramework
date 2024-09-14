package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //locators

    By emailTxt = By.id("input-email");
    By passwordTxt = By.id("input-password");
    By loginBtn = By.cssSelector("input[type='submit']");
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
