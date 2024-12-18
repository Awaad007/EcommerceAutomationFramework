package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends PageBase {

    String productData = "DynamicData.json";
    public String productName = jsonReader("ProductName", productData);

    //locators
    //Dynamic locator for choosing specific product to be removed form wishList
    private final By removeBtn = By.xpath("//a[.='" + productName + "']/ancestor::tr//a[@class='btn btn-danger']");
    private final By message = By.xpath("//div[contains(@class,'alert-success')]");

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void clickOnRemoveBtn() {
        clickOnButton(removeBtn);
    }

    //assert
    public boolean assertThatProductIsRemoved() {
        find(message).isDisplayed();
        return true;
    }
}
