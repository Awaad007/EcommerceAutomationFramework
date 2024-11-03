package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By nameTxt = By.id("input-name");
    By emailTxt = By.id("input-email");
    By enquiryTxt = By.id("input-enquiry");
    By submitBtn = By.cssSelector("input[type=submit]");
    By successMessage = By.xpath("//div[@id='content']//p");
    String contactUsData = "ContactUsData.json";

    //methods
    public void userAddFullName() {
        setElementText(nameTxt, jsonReader("fullName", contactUsData));
    }

    public void userAddEnquiry() {
        setElementText(enquiryTxt, jsonReader("enquiry", contactUsData));
    }

    public void userEnterEmail() {
        setElementText(emailTxt, jsonReader("emailAddress", contactUsData));
    }

    public void userClickOnSubmitBtn() {
        clickOnButton(submitBtn);
    }

    //assert
    public boolean successMessageDisplayed() {
        find(successMessage).isDisplayed();
        return true;
    }
}
