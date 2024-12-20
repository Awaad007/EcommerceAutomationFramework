package steps;

import Pages.ProductDetailsPage;
import Pages.WishListPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static utilities.JsonReader.getJsonValue;

public class TC09_AddProductToWishList {
    ProductDetailsPage productObject;
    WishListPage wishObject;
    String productData = "ProductData.json";
    @Given("user at product screen and click on add to wishlist button")
    public void userAtProductScreenAndClickOnAddToWishlistButton() {
        productObject = new ProductDetailsPage(Hooks.driver);
        productObject.userClickOnWishListBtn();
    }

    @When("user click on wishlist page link")
    public void userClickOnWishlistPageLink() {
        productObject.userNavigateToWishListPage();
    }

    @And("user tap on remove button")
    public void userTapOnRemoveButton() {
        wishObject = new WishListPage(Hooks.driver);
        wishObject.clickOnRemoveBtn(getJsonValue("verifyProductName",productData));
    }

    @Then("success message should appear to user")
    public void successMessageShouldAppearToUser() {
        boolean isDisplayed = wishObject.assertThatProductIsRemoved();
        Assert.assertTrue(isDisplayed);
    }
}
