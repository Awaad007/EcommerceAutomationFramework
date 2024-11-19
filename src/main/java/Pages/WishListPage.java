package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    String productData = "DynamicData.json";

    public String productName = jsonReader("ProductName", productData);

    //locators
    //Dynamic locator for choosing specific product to be removed form wishList
    By removeBtn = By.xpath("//a[.='"+productName+"']/ancestor::tr//a[@class='btn btn-danger']");
    By message = By.xpath("//div[contains(@class,'alert-success')]");
    //methods
    public void clickOnRemoveBtn(){
        clickOnButton(removeBtn);
    }
    public boolean assertThatProductIsRemoved(){
        find(message).isDisplayed();
        return true;
    }
}
