package Common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.List;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Select select;
    protected Actions action;
    protected JavascriptExecutor jse;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void setElementText(By textElementText, String value) {
        WebElement element = driver.findElement(textElementText);
        element.sendKeys(value);
    }

    protected void clickOnButton(By button) {

        WebElement element = driver.findElement(button);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void clearElementText(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> elementsList(By locator) {
        return driver.findElements(locator);
    }

    protected void scrollToBottom() {
        jse.executeScript("scrollBy(0,2500)");
    }

    protected String jsonReader(String obj, String fileNme) {
        File srcFile = new File(System.getProperty("user.dir") +
                "/src/main/java/data/" + fileNme);
        JSONParser parser = new JSONParser();
        String value = null;
        try {
            JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
            for (Object jsonObj : jArray) {
                JSONObject person = (JSONObject) jsonObj;
                value = (String) person.get(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
