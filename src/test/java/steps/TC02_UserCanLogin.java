package steps;

import Pages.HomePage;
import Pages.LoginPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC02_UserCanLogin {
    HomePage homeObject;
    LoginPage loginObject;

    @Given("user at home screen and click on login button")
    public void userAtHomeScreenAndClickOnLoginButton() {
        homeObject = new HomePage(Hooks.driver);
        homeObject.openLoginPage();
    }

    @When("user enters {string} address")
    public void userEntersAddress(String email) {
        loginObject = new LoginPage(Hooks.driver);
        loginObject.userEnterEmail(email);
    }

    @And("user enters {string}")
    public void userEnters(String password) {
        loginObject.userEnterPassword(password);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        loginObject.clickOnLoginBtn();
    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        boolean isDisplayed = homeObject.assertThatUserLoggedIn();
        Assert.assertTrue(isDisplayed);
    }
}
