package steps;

import Pages.HomePage;
import Pages.MyAccountPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC03_UserCanUpdatePassword {
    MyAccountPage accountObject;

    @Given("user tap on change password button")
    public void userTapOnChangePasswordButton() {
        accountObject = new MyAccountPage(Hooks.driver);
        accountObject.clickOnChangePasswordPage();
    }

    @When("user enter new password")
    public void userEnterNewPassword() {
        accountObject.enterNewPassword();
    }

    @And("user confirm new password")
    public void userConfirmNewPassword() {
        accountObject.confirmNewPassword();
    }

    @And("user click on change password button")
    public void userClickOnChangePasswordButton() {
        accountObject.clickOnChangePasswordBtn();
    }

    @Then("password should be changed successfully")
    public void passwordShouldBeChangedSuccessfully() {
        boolean reveal = accountObject.assertThatPasswordChanged();
        Assert.assertTrue(reveal);
    }
}
