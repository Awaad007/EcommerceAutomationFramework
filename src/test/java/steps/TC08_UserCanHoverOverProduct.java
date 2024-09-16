package steps;

import Pages.HomePage;
import connector.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC08_UserCanHoverOverProduct {
    HomePage homeObject;
    @Given("user at home page and hover over desktops")
    public void userAtHomePageAndHoverOverDesktops() {
        homeObject = new HomePage(Hooks.driver);
        homeObject.hoverOverDesktop();
    }

    @When("user select macbook")
    public void userSelectMacbook() {
        homeObject.selectMacOption();
    }
    @Then("user should be navigated to product screen")
    public void userShouldBeNavigatedToProductScreen() {
        boolean isDisplayed = homeObject.asserThatUserNavigatedToProduct();
        Assert.assertTrue(isDisplayed);
    }
}
