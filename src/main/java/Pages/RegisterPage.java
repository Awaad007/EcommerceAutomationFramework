package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {


    //locators
    private final By firstNameTxt = By.id("input-firstname");
    private final By lastNameTxt = By.id("input-lastname");
    private final By emailAddressTxt = By.id("input-email");
    private final By telephoneNum = By.id("input-telephone");
    private final By passwordTxt = By.id("input-password");
    private final By confirmPasswordTxt = By.name("confirm");
    private final By confirmPolicyCheckBox = By.cssSelector("input[type=checkbox]");
    private final By submitBtn = By.cssSelector("input[type=submit]");
    public By successMessage = By.xpath("//div[@id='content']//h1");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void userSetFirstName(String firstname) {
        setElementText(firstNameTxt, firstname);
    }

    public void userSetLastName(String lastName) {
        setElementText(lastNameTxt, lastName);
    }

    public void userSetEmailAddress(String emailAddress) {
        setElementText(emailAddressTxt, emailAddress);
    }

    public void userSetPhoneNumber(String telephoneNumber) {
        setElementText(telephoneNum, telephoneNumber);
    }

    public void userSetPassword(String password) {
        setElementText(passwordTxt, password);
    }

    public void userSetConfirmationPassword(String confirmPassword) {
        setElementText(confirmPasswordTxt, confirmPassword);
    }

    public void userClickOnRegisterBtn() {
        clickOnButton(confirmPolicyCheckBox);
        clickOnButton(submitBtn);

    }

    //assert
    public String asserThatUserHasRegister() {
        return find(successMessage).getText();
    }
}
