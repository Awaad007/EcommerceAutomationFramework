package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By firstNameTxt = By.id("input-firstname");
    By lastNameTxt = By.id("input-lastname");
    By emailAddressTxt = By.id("input-email");
    By telephoneNum = By.id("input-telephone");
    By passwordTxt = By.id("input-password");
    By confirmPasswordTxt = By.name("confirm");
    By confirmPolicyCheckBox = By.cssSelector("input[type=checkbox]");
    By submitBtn = By.cssSelector("input[type=submit]");
    public By successMessage = By.xpath("//div[@id='content']//h1");

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

    public String asserThatUserHasRegister() {
        return find(successMessage).getText();
    }
}
