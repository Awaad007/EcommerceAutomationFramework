package Common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

public class PageBase {

    public WebDriver driver;
    public Select select;
    public Actions action;
    public JavascriptExecutor jse;
    public PageBase(WebDriver driver){
        this.driver = driver;

    }
    protected void setElementText(By textElementText, String value){
        WebElement element = driver.findElement(textElementText);
        element.sendKeys(value);
    }
    protected void clickOnButton(By button){

        WebElement element = driver.findElement(button);
        element.click();
    }
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    public void scrollToBottom(){
        jse.executeScript("scrollBy(0,2500)");
    }

    public String jsonReader(String obj, String fileNme) {
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
