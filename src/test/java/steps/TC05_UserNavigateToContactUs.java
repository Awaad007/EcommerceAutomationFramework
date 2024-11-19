package steps;

import Pages.ContactUsPage;
import Pages.HomePage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static utilities.JsonReader.getJsonValue;

public class TC05_UserNavigateToContactUs {

    HomePage homeObject;
    ContactUsPage contactObject;
    String contactUsData = "ContactUsData.json";
    @Given("user at home screen and click on contact us button")
    public void userAtHomeScreenAndClickOnContactUsButton() {
        homeObject = new HomePage(Hooks.driver);
        homeObject.openContactUsPage();
    }
    @When("user enter full name")
    public void userEnterFullName() {
        contactObject = new ContactUsPage(Hooks.driver);
        contactObject.userAddFullName(getJsonValue("fullName",contactUsData));
    }

    @And("user enter email")
    public void userEnterEmail() {
        contactObject.userEnterEmail(getJsonValue("emailAddress",contactUsData));
    }
    @And("user enter enquiry")
    public void userEnterEnquiry() {
        contactObject.userAddEnquiry(getJsonValue("enquiry",contactUsData));
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
