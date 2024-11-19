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

    By compareBtn = By.xpath("//a[contains(@href, 'id=43&search')]/ancestor::div[2]//button[contains(@data-original-title, 'Compare')]");
    By compareLink = By.linkText("product comparison");

    //methods
    public SearchPage userEnterProductName(String productName) {
        setElementText(searchFieldTxt, productName);
        return this;
    }

    public SearchPage userClickOnSearchBtn() {
        clickOnButton(searchBtn);
        return this;
    }
    public SearchPage userTapOnCompareBtn(){
        clickOnButton(compareBtn);
        return this;
    }
    public SearchPage userNavigateToCompareScreen(){
        clickOnButton(compareLink);
        return this;
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
