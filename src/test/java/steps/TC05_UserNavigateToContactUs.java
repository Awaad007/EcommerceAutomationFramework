package steps;

import Pages.ContactUsPage;
import Pages.HomePage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC05_UserNavigateToContactUs {

    HomePage homeObject;
    ContactUsPage contactObject;

    @Given("user at home screen and click on contact us button")
    public void userAtHomeScreenAndClickOnContactUsButton() {
        homeObject = new HomePage(Hooks.driver);
        homeObject.openContactUsPage();
    }

    @When("user enter full name")
    public void userEnterFullName() {
        contactObject = new ContactUsPage(Hooks.driver);
        contactObject.userAddFullName();
    }

    @And("user enter email")
    public void userEnterEmail() {
        contactObject.userEnterEmail();
    }

    @And("user enter enquiry")
    public void userEnterEnquiry() {
        contactObject.userAddEnquiry();
    }

    @And("user click on submit button")
    public void userClickOnSubmitButton() {
        contactObject.userClickOnSubmitBtn();
    }

    @Then("user message should be received successfully")
    public void userMessageShouldBeReceivedSuccessfully() {
        boolean isDisplayed = contactObject.successMessageDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}
