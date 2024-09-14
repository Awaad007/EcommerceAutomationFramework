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
    String changePasswordData = "ChangePassword.json";

    //Methods
    public void clickOnChangePasswordPage() {
        clickOnButton(changePasswordLink);
    }

    public void enterNewPassword() {
        setElementText(newPasswordTxt, jsonReader("newPassword", changePasswordData));
    }

    public void confirmNewPassword() {
        setElementText(confirmPasswordTxt, jsonReader("confirmPassword", changePasswordData));
    }

    public void clickOnChangePasswordBtn() {
        clickOnButton(changePasswordBtn);
    }

    public boolean assertThatPasswordChanged() {
        find(notificationBar).isDisplayed();
        return true;
    }

}
