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

    //method
    public String assertThatProductNameIsDisplayed(){
        return find(productTitle).getText();
    }

}
