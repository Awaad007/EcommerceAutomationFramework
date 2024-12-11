package steps;

import Pages.CheckoutPage;
import Pages.ShoppingCartPage;
import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


import static utilities.JsonReader.getJsonValue;

public class TC12_OrderCheckout {
    ShoppingCartPage cartObject;
    CheckoutPage checkObject;

    String checkoutData = "CheckoutData.json";
    @Given("user at cart screen and tapping on checkout button")
    public void userAtCartScreenAndTappingOnCheckoutButton() {
        cartObject = new ShoppingCartPage(Hooks.driver);
        cartObject.userClickOnCheckoutBtn();
    }

    @When("user navigated to checkout screen and user confirm billing details")
    public void userNavigatedToCheckoutScreenAndUserConfirmBillingDetails() {
        checkObject = new CheckoutPage(Hooks.driver);
        checkObject.userSelectNewAddress().userEnterFirstName(getJsonValue("firstName",checkoutData)).
                userEnterLastName(getJsonValue("lastName",checkoutData)).
                userEnterAddress(getJsonValue("Address",checkoutData)).
                userEnterCity(getJsonValue("City",checkoutData)).
                userEnterPostalCode(getJsonValue("postalCode",checkoutData)).
                selectCountry(getJsonValue("country",checkoutData)).
                selectState(getJsonValue("state",checkoutData));
    }
    @And("user taps on continue button")
    public void userTapsOnContinueButton() {
        checkObject.clickBillingContinueBtn();
    }
    @And("user confirm delivery details")
    public void userConfirmDeliveryDetails() {
        checkObject.clickDetailsContinueBtn();
    }


    @And("user confirm delivery method")
    public void userConfirmDeliveryMethod() {
        checkObject.clickDeliveryContinueBtn();
    }

    @And("user accept terms and confirm payment method")
    public void userAcceptTermsAndConfirmPaymentMethod() {

        checkObject.checkTermsBox().clickPaymentContinueBtn();
    }

    @And("user confirm order")
    public void userConfirmOrder() {

        checkObject.clickOnConfirmOrderBtn();
    }

    @Then("order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        String orderPlacedMsn = checkObject.assertThatOrderPlacedSuccessfully();
        Assert.assertEquals(orderPlacedMsn,"Your order has been placed!");
    }

}
