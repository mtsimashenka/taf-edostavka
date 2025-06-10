package by.itacademy.timoshenko.edostavka.ui.pages.registration;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        return driver.findElement(By.xpath(String.format(RegistrationLocators.ERROR_MESSAGE_CREDENTIAL, input))).getText();
    }

    public String getErrorMessagePhoneText() {
        return driver.findElement(By.xpath(RegistrationLocators.ERROR_MESSAGE_PHONE)).getText();
    }

    public String getErrorMessagePasswordText() {
        return driver.findElement(By.xpath(RegistrationLocators.ERROR_MESSAGE_PASSWORD)).getText();
    }

    public String getErrorMessageAgreementText() {
        return driver.findElement(By.xpath(RegistrationLocators.ERROR_MESSAGE_AGREEMENT)).getText();
    }

    public String getTitleCreateAccountText() {
        return driver.findElement(By.xpath(RegistrationLocators.TITLE_CREATE_ACCOUNT)).getText();
    }

    public void fillInputCredential(String input, String value) {
        driver.findElement(By.xpath(String.format(RegistrationLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickCheckBox(String input) {
        driver.findElement(By.xpath(String.format(RegistrationLocators.CHECKBOX_LABEL, input))).click();
    }

    public void clickCheckBoxAgreementButton() {
        driver.findElement(By.xpath(String.format(RegistrationLocators.CHECK_BOX_BUTTON_SUBMIT))).click();
    }

    public void clickNextSubmitButton() {
        driver.findElement(By.xpath(String.format(RegistrationLocators.NEXT_BUTTON_SUBMIT))).click();
    }

    public void clickSubmitSelectAllButton() {
        driver.findElement(By.xpath(String.format(RegistrationLocators.SELECT_ALL_BUTTON_SUBMIT))).click();
    }

    public void clickAgreementSubmitButton() {
        driver.findElement(By.xpath(String.format(RegistrationLocators.AGREEMENT_BUTTON_SUBMIT))).click();
    }


    public void clickSubmitButton() {
         driver.findElement(By.xpath(RegistrationLocators.BUTTON_SUBMIT)).click();
    }
}
