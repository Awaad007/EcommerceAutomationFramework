package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase {
    //locators
    private final By nameTxt = By.id("input-name");
    private final By emailTxt = By.id("input-email");
    private final By enquiryTxt = By.id("input-enquiry");
    private final By submitBtn = By.cssSelector("input[type=submit]");
    private final By successMessage = By.xpath("//div[@id='content']//p");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    //methods
    public void userAddFullName(String name) {
        setElementText(nameTxt, name);
    }

    public void userAddEnquiry(String enquiry) {
        setElementText(enquiryTxt, enquiry);
    }

    public void userEnterEmail(String emailAddress) {
        setElementText(emailTxt, emailAddress);
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
