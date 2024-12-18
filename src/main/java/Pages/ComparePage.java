package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ComparePage extends PageBase {

    //locators
    private final By allRows = By.tagName("tr");
    private final By allCol = By.tagName("td");
    private final By removeBtn = By.xpath("//a[contains(@href,'remove=44')]");
    private final By message = By.xpath("//div[contains(@class,'alert-success')]");

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void CompareProduct() {
        wait.until(ExpectedConditions.urlToBe("https://awesomeqa.com/ui/index.php?route=product/compare"));
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
