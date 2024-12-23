package steps;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static utilities.JsonReader.getJsonValue;

public class TC04_UserCanSearchForProduct {
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    String searchData = "ProductData.json";
    public String productName = getJsonValue("verifyProductName", searchData);

    @Given("user at the home screen and enter product name in search bar")
    public void userAtTheHomeScreenAndEnterProductNameInSearchBar() {
        searchObject = new SearchPage(Hooks.driver);
        searchObject.userEnterProductName(getJsonValue("productName", searchData));
    }

    @When("user click on search button")
    public void userClickOnSearchButton() {
        searchObject.userClickOnSearchBtn();
    }

    @And("user select category")
    public void userSelectCategory() {
        searchObject.selectCategory();
    }

    @And("user click on product title")
    public void userClickOnProductTitle() {
        searchObject.userClickOnProductTitle();
    }

    @Then("user should be directed to product screen successfully")
    public void userShouldBeDirectedToProductScreenSuccessfully() {
        detailsObject = new ProductDetailsPage(Hooks.driver);
        String productTitleDisplayed = detailsObject.assertThatProductNameIsDisplayed();
        Assert.assertEquals(productTitleDisplayed, productName, "MacBook Air");
    }

}
