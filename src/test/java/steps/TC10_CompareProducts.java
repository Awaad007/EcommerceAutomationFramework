package steps;

import Pages.ComparePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static utilities.JsonReader.getJsonValue;

public class TC10_CompareProducts {
    ProductDetailsPage productObject;
    ComparePage compareObject;
    SearchPage searchObject;
    String searchData = "ProductData.json";
    @Given("user click on compare button")
    public void userClickOnCompareButton() {
        productObject = new ProductDetailsPage(Hooks.driver);
        productObject.userClickOnCompareBtn();

    }

    @When("navigate to compare screen")
    public void navigateToCompareScreen() {
        productObject.userNavigateToComparePage();
    }
    @And("user add second product to compare list")
    public void userAddSecondProductToCompareList() {
        searchObject = new SearchPage(Hooks.driver);
        searchObject.userEnterProductName(getJsonValue("productName", searchData)).userClickOnSearchBtn().userTapOnCompareBtn().userNavigateToCompareScreen();
    }

    @And("user comparing products")
    public void userComparingProducts() {
        compareObject = new ComparePage(Hooks.driver);
        compareObject.CompareProduct();
    }

    @And("taps on remove button")
    public void tapsOnRemoveButton() {
        compareObject.clickOnRemoveBtn();
    }

    @Then("placeholder message should appear to user")
    public void placeholderMessageShouldAppearToUser() {
        compareObject.assertThatProductRemoved();
    }
}
