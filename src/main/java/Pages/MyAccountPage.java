package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By changePasswordLink = By.linkText("Change your password");
    By newPasswordTxt = By.name("password");
    By confirmPasswordTxt = By.name("confirm");
    By changePasswordBtn = By.cssSelector("input[type='submit']");
    By notificationBar = By.cssSelector("div.alert");

    //Methods
    public void clickOnChangePasswordPage() {
        clickOnButton(changePasswordLink);
    }

    public void enterNewPassword(String newPassword) {
        setElementText(newPasswordTxt, newPassword);
    }

    public void confirmNewPassword(String confirmNewPassword) {
        setElementText(confirmPasswordTxt, confirmNewPassword);
    }

    public void clickOnChangePasswordBtn() {
        clickOnButton(changePasswordBtn);
    }

    public boolean assertThatPasswordChanged() {
        find(notificationBar).isDisplayed();
        return true;
    }

}
