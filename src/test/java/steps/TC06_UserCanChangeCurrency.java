package steps;

import Pages.ContactUsPage;
import Pages.HomePage;
import connector.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC06_UserCanChangeCurrency {
    HomePage homeObject;

    @Given("user at home page and click on currency dropdown")
    public void userAtHomePageAndClickOnCurrencyDropdown() {
        homeObject = new HomePage(Hooks.driver);
        homeObject.clickOnCurrencyDropDown();
    }
    @When("user select euro as new currency")
    public void userSelectEuroAsNewCurrency() {
        homeObject.selectEuro();
    }

    @Then("website currency should be updated to euro successfully")
    public void websiteCurrencyShouldBeUpdatedToEuroSuccessfully() {
        String currencyText = homeObject.assertThatCurrencyIsEuro();
        Assert.assertEquals(currencyText,"€");
    }
}
