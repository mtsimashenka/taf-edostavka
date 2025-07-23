package by.itacademy.timoshenko.edostavka.ui.pages.registration;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    protected static final Logger logger = LogManager.getLogger();
    public static int DEFAULT_WAIT_SECONDS = 10;

    public String getTitleRegistrationText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.TITLE_REGISTRATION)).getText();
    }

    public String getSubmitButtonText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.BUTTON_SUBMIT)).getText();
    }

    public String getCommitPasswordText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.COMMIT_PASSWORD)).getText();
    }

    public String getLabelPhoneNumberText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.LABEL_PHONE_NUMBER)).getText();
    }

    public String getLinkImAgreeText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.LINK_I_AGREE)).getText();
    }

    public String getCheckBoxText(String input) {
        return Driver.getWebElement(By.xpath(String.format(RegistrationLocators.CHECKBOX_LABEL, input))).getText();
    }

    public String getLabelCredentialText(String input) {
        return Driver.getWebElement(By.xpath(String.format(RegistrationLocators.LABEL_CREDENTIALS, input))).getText();
    }

    public String getErrorMessageText(String input) {
        return Driver.getWebElement(By.xpath(String.format(RegistrationLocators.ERROR_MESSAGE_CREDENTIAL, input))).getText();
    }

    public String getErrorMessagePhoneText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.ERROR_MESSAGE_PHONE)).getText();
    }

    public String getErrorMessagePasswordText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.ERROR_MESSAGE_PASSWORD)).getText();
    }

    public String getErrorMessageAgreementText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.ERROR_MESSAGE_AGREEMENT)).getText();
    }

    public String getTitleCreateAccountText() {
        return Driver.getWebElement(By.xpath(RegistrationLocators.TITLE_CREATE_ACCOUNT)).getText();
    }

    public void fillInputCredential(String input, String value) {
        Driver.getWebElement(By.xpath(String.format(RegistrationLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickCheckBox(String input) {
        logger.info("clickCheckBox  start");
        Driver.getWebElement(By.xpath(String.format(RegistrationLocators.CHECKBOX_LABEL, input))).click();
        logger.info("CHECKBOX_LABEL clicked");
    }

    public void clickCheckBoxAgreementButton() {
        Driver.getWebElement(By.xpath(String.format(RegistrationLocators.CHECK_BOX_BUTTON_SUBMIT))).click();
    }

    public void clickNextSubmitButton() {
        logger.info("clickNextSubmitButton start");
        WebElement element = Driver.getWebElement(By.xpath(RegistrationLocators.NEXT_BUTTON_SUBMIT));
        Waits.enableElement(Driver.getDriver(), element);
        WebElement visibleElement = Waits.waitForElementToBeVisible(Driver.getDriver(), By.xpath(RegistrationLocators.NEXT_BUTTON_SUBMIT), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(Driver.getDriver(), visibleElement, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
        logger.info("NEXT_BUTTON_SUBMIT clicked");
    }

    public void clickSubmitSelectAllButton() {
        Driver.getWebElement(By.xpath(String.format(RegistrationLocators.SELECT_ALL_BUTTON_SUBMIT))).click();
    }

    public void clickAgreementSubmitButton() {
        Driver.getWebElement(By.xpath(String.format(RegistrationLocators.AGREEMENT_BUTTON_SUBMIT))).click();
    }

    public void clickSubmitButton() {
         Driver.getWebElement(By.xpath(RegistrationLocators.BUTTON_SUBMIT)).click();
    }
}
