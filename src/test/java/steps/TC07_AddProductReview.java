package steps;

import Pages.ProductDetailsPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC07_AddProductReview {
    ProductDetailsPage productObject;
    @Given("user at product screen and click on write review")
    public void userAtProductScreenAndClickOnWriteReview() {
        productObject = new ProductDetailsPage(Hooks.driver);
        productObject.clickOnWriteReview();
    }

    @When("user type product review")
    public void userTypeProductReview() {
        productObject.writeProductReview();
    }

    @And("user rate product")
    public void userRateProduct() {
        productObject.userClickOnRadioBtn();
    }

    @And("user click on continue button")
    public void userClickOnContinueButton() {
        productObject.userClickOnContinueBtn();
    }

    @Then("review should be submitted successfully")
    public void reviewShouldBeSubmittedSuccessfully() {
        boolean isDisplayed = productObject.assertThatProductReviewIsSubmitted();
        Assert.assertTrue(isDisplayed);
    }
}
