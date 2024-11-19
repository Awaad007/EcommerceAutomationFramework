package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComparePage extends PageBase {
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    //locators
    By allRows = By.tagName("tr");
    By allCol = By.tagName("td");
    By removeBtn = By.xpath("//a[contains(@href,'remove=44')]");
    By message = By.xpath("//div[contains(@class,'alert-success')]");

    //methods
    public void CompareProduct() {
        List<WebElement> rows = elementsList(allRows);
        List<WebElement> columns = elementsList(allCol);

        for (WebElement row : rows) {
            System.out.println(row.getText() + "\t");
            for (WebElement col : columns) {
                System.out.println(col.getText() + "\t");
            }
        }
    }

    public void clickOnRemoveBtn() {
        clickOnButton(removeBtn);
    }


    //assert
    public boolean assertThatProductRemoved() {
        find(message).isDisplayed();
        return true;
    }


}
