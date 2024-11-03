package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By searchFieldTxt = By.name("search");
    By searchBtn = By.cssSelector(".input-group-btn");
    By dropDownList = By.id("ui-id-1");
    By allCategoriesDropDown = By.name("category_id");
    By productTitle = By.partialLinkText("MacBook Air");

    String searchData = "ProductData.json";
    public String productName = jsonReader("verifyProductName", searchData);

    //methods
    public void userEnterProductName() {
        setElementText(searchFieldTxt, jsonReader("productName", searchData));
    }

    public void userClickOnSearchBtn() {
        clickOnButton(searchBtn);
    }

    public void selectCategory() {
        WebElement catDropDown = driver.findElement(allCategoriesDropDown);
        select = new Select(catDropDown);
        select.selectByVisibleText("Desktops");
    }

    public void userClickOnProductTitle() {
        clickOnButton(productTitle);
    }

}
