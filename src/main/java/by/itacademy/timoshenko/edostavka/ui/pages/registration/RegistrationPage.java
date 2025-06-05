package by.itacademy.timoshenko.edostavka.ui.pages.registration;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage() {
        driver = Driver.getDriver();
    }

    public String getTitleRegistrationText() {
        return driver.findElement(By.xpath(RegistrationLocators.TITLE_REGISTRATION)).getText();
    }

    public String getSubmitButtonText() {
        return driver.findElement(By.xpath(RegistrationLocators.BUTTON_SUBMIT)).getText();
    }

    public String getCommitPasswordText() {
        return driver.findElement(By.xpath(RegistrationLocators.COMMIT_PASSWORD)).getText();
    }

    public String getLabelPhoneNumberText() {
        return driver.findElement(By.xpath(RegistrationLocators.LABEL_PHONE_NUMBER)).getText();
    }

    public String getLinkImAgreeText() {
        return driver.findElement(By.xpath(RegistrationLocators.LINK_I_AGREE)).getText();
    }

    public String getCheckBoxText(String input) {
        return driver.findElement(By.xpath(String.format(RegistrationLocators.CHECKBOX_LABEL, input))).getText();
    }

    public String getLabelCredentialText(String input) {
        return driver.findElement(By.xpath(String.format(RegistrationLocators.LABEL_CREDENTIALS, input))).getText();
    }

    public String getErrorMessageText(String input) {
        return driver.findElement(By.xpath(String.format(RegistrationLocators., input))).getText();
    }

    public void clickSubmitButton() {
        driver.findElement(By.xpath(RegistrationLocators.BUTTON_SUBMIT)).click();
    }
}
