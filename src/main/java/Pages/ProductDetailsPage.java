package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {


    //locator
    private final By productTitle = By.xpath("//div[@class='col-sm-4']//h1");
    private final By productImage = By.id("main-product-img-4");
    private final By writeReviewLink = By.linkText("Write a review");
    private final By yourReviewTxt = By.id("input-review");
    private final By radioBtn = By.xpath("//input[@value='3']");
    private final By continueBtn = By.id("button-review");
    private final By wishListBtn = By.xpath("//button[contains(@data-original-title,'Wish')]");
    private final By compareBtn = By.xpath("//button[contains(@data-original-title,'Compare')]");
    private final By wishListLink = By.linkText("wish list");
    private final By compareLink = By.linkText("product comparison");
    private final By addToCartBtn = By.id("button-cart");
    private final By addToCartLink = By.linkText("shopping cart");
    private final By message = By.xpath("//div[contains(@class,'alert-success')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    //method
    public void clickOnWriteReview() {
        clickOnButton(writeReviewLink);
    }

    public void writeProductReview(String reviewText) {
        setElementText(yourReviewTxt, reviewText);
    }

    public void userClickOnRadioBtn() {
        clickOnButton(radioBtn);
    }

    public void userClickOnContinueBtn() {
        clickOnButton(continueBtn);
    }

    public void userClickOnWishListBtn() {
        clickOnButton(wishListBtn);
    }

    public void userNavigateToWishListPage() {
        clickOnButton(wishListLink);
    }

    public void userClickOnCompareBtn() {
        clickOnButton(compareBtn);
    }

    public void userNavigateToComparePage() {
        clickOnButton(compareLink);
    }

    public void userClickOnAddToCartBtn() {
        clickOnButton(addToCartBtn);
    }

    public void userNavigateToAddToCartPage() {
        clickOnButton(addToCartLink);
    }

    //assert
    public String assertThatProductNameIsDisplayed() {
        return find(productTitle).getText();
    }

    public boolean assertThatProductReviewIsSubmitted() {
        find(message).isDisplayed();
        return true;
    }

}
