package steps;

import Pages.ProductDetailsPage;
import Pages.ShoppingCartPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static utilities.JsonReader.getJsonValue;

public class TC11_AddProductToShoppingCart {
    ProductDetailsPage productObject;
    ShoppingCartPage cartObject;
    String cartData = "ShoppingCartData.json";
    @Given("user at product screen and click on add to cart button")
    public void userAtProductScreenAndClickOnAddToCartButton() {
        productObject = new ProductDetailsPage(Hooks.driver);
        productObject.userClickOnAddToCartBtn();
    }

    @When("user click on shopping cart link")
    public void userClickOnShoppingCartLink() {
        productObject.userNavigateToAddToCartPage();
    }

    @And("user update product quantity")
    public void userUpdateProductQuantity() {
        cartObject = new ShoppingCartPage(Hooks.driver);
        cartObject.changeProductQuantity(getJsonValue("productQuantity",cartData));
    }

    @And("user click on update button")
    public void userClickOnUpdateButton() {
        cartObject.clickOnUpdateBtn();
    }

    @And("user set shipping estimation and taxes")
    public void userSetShippingEstimationAndTaxes() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cartObject.clickOnEstimationShippingLink().selectCountry(getJsonValue("country",cartData)).
                selectState(getJsonValue("state",cartData)).
                setPostalCode(getJsonValue("postalCode",cartData)).
                clickOnQuoteBtn();
    }
    @And("user check radio button")
    public void userCheckRadioButton() {
        cartObject.checkRadioBtn();
    }

    @And("user click on apply shipping")
    public void userClickOnApplyShipping() {
        cartObject.clickOnApplyShipping();

    }
    @Then("shipping estimation should be applied successfully")
    public void shippingEstimationShouldBeAppliedSuccessfully() {
        boolean isDisplayed = cartObject.assertThatShippingEstimateApplied();
        Assert.assertTrue(isDisplayed);
    }
}
