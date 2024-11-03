package steps;

import Pages.HomePage;
import Pages.RegisterPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC01_UserCanRegister{
    HomePage homeObject;
    RegisterPage registerObject;

    @Given("user at register screen")
    public void user_at_register_screen() {
        homeObject = new HomePage(Hooks.driver);
        homeObject.openRegisterPage();
        //homeObject.selectRegisterPage();
    }
    @When("user enter first name")
    public void user_enter_first_name() {
        registerObject= new RegisterPage(Hooks.driver);
        registerObject.userSetFirstName();
    }
    @And("user enter last name")
    public void user_enter_last_name() {
        registerObject.userSetLastName();
    }
    @And("user enter email address")
    public void user_enter_email_address() {
        registerObject.userSetEmailAddress();
    }
    @And("user enter phone number")
    public void userEnterPhoneNumber() {
        registerObject.userSetPhoneNumber();
    }
    @And("user enter password")
    public void user_enter_password() {
        registerObject.userSetPassword();

    }
    @And("user confirm password")
    public void user_confirm_password() {
        registerObject.userSetConfirmationPassword();
    }
    @And("click on register button")
    public void click_on_register_button() {
        registerObject.userClickOnRegisterBtn();
    }
    @Then("user should be registered successfully")
    public void user_should_be_registered_successfully() {
        String message = registerObject.asserThatUserHasRegister();
        System.out.println(message);
        Assert.assertEquals(message,"Your Account Has Been Created!");
    }

}
