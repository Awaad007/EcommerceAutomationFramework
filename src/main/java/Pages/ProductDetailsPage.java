package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    //locator
    By productTitle = By.xpath("//div[@class='col-sm-4']//h1");
    By productImage = By.id("main-product-img-4");
    By writeReviewLink = By.linkText("Write a review");
    By yourReviewTxt = By.id("input-review");
    By radioBtn = By.xpath("//input[@value='3']");
    By continueBtn = By.id("button-review");
    By wishListBtn = By.xpath("//button[contains(@data-original-title,'Wish')]");
    By compareBtn = By.xpath("//button[contains(@data-original-title,'Compare')]");
    By wishListLink = By.linkText("wish list");
    By compareLink = By.linkText("product comparison");
    By addToCartBtn = By.id("button-cart");
    By addToCartLink = By.linkText("shopping cart");
    By message = By.xpath("//div[contains(@class,'alert-success')]");

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
    public void userClickOnWishListBtn(){
        clickOnButton(wishListBtn);
    }
    public void userNavigateToWishListPage(){
        clickOnButton(wishListLink);
    }
    public void userClickOnCompareBtn(){
        clickOnButton(compareBtn);
    }
    public void userNavigateToComparePage(){
        clickOnButton(compareLink);
    }
    public void userClickOnAddToCartBtn(){
        clickOnButton(addToCartBtn);
    }
    public void userNavigateToAddToCartPage(){
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
