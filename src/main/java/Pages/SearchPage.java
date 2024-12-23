package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends PageBase {


    //locators
    private final By searchFieldTxt = By.name("search");
    private final By searchBtn = By.cssSelector(".input-group-btn");
    private final By dropDownList = By.id("ui-id-1");
    private final By allCategoriesDropDown = By.name("category_id");
    private final By productTitle = By.partialLinkText("MacBook Air");

    private final By compareBtn = By.xpath("//a[contains(@href, 'id=43&search')]/ancestor::div[2]//button[contains(@data-original-title, 'Compare')]");
    private final By compareLink = By.partialLinkText("product comparison");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public SearchPage userEnterProductName(String productName) {
        setElementText(searchFieldTxt, productName);
        return this;
    }

    public SearchPage userClickOnSearchBtn() {
        clickOnButton(searchBtn);
        return this;
    }

    public SearchPage userTapOnCompareBtn() {
        clickOnButton(compareBtn);
        return this;
    }

    public SearchPage userNavigateToCompareScreen() {
        WebElement compareElement = find(compareLink);
        wait.until(ExpectedConditions.visibilityOf(compareElement));
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
