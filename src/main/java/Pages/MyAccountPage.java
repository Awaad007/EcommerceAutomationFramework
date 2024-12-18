package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {


    //locators
    private final By changePasswordLink = By.linkText("Change your password");
    private final By newPasswordTxt = By.name("password");
    private final By confirmPasswordTxt = By.name("confirm");
    private final By changePasswordBtn = By.cssSelector("input[type='submit']");
    private final By notificationBar = By.cssSelector("div.alert");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

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

    //assert
    public boolean assertThatPasswordChanged() {
        find(notificationBar).isDisplayed();
        return true;
    }

}
