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

    String registerData = "RegisterCredentials.json";


    //methods
    public void userSetFirstName() {
        System.out.println(jsonReader("firstName", registerData));
        setElementText(firstNameTxt, jsonReader("firstName", registerData));
    }

    public void userSetLastName() {
        setElementText(lastNameTxt, jsonReader("lastName", registerData));
    }

    public void userSetEmailAddress() {
        setElementText(emailAddressTxt, jsonReader("emailAddress", registerData));
    }

    public void userSetPhoneNumber() {
        setElementText(telephoneNum, jsonReader("telephoneNumber", registerData));
    }

    public void userSetPassword() {
        System.out.println(jsonReader("password", registerData));
        setElementText(passwordTxt, jsonReader("password", registerData));
    }

    public void userSetConfirmationPassword() {
        setElementText(confirmPasswordTxt, jsonReader("password", registerData));
    }

    public void userClickOnRegisterBtn() {
        clickOnButton(confirmPolicyCheckBox);
        clickOnButton(submitBtn);

    }

    public String asserThatUserHasRegister() {
        return find(successMessage).getText();
    }
}
