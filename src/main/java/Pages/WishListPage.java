package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends PageBase {

    //locators
    //Dynamic locator for choosing specific product to be removed form wishList
    private final By message = By.xpath("//div[contains(@class,'alert-success')]");

    private By getRemoveBtnLocator(String productName) {
        return By.xpath("//a[.='" + productName + "']/ancestor::tr//a[@class='btn btn-danger']");
    }

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void clickOnRemoveBtn(String productName) {
        By removeBtn = getRemoveBtnLocator(productName);
        clickOnButton(removeBtn);
    }

    //assert
    public boolean assertThatProductIsRemoved() {
        find(message).isDisplayed();
        return true;
    }
}
