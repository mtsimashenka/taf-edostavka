package by.itacademy.timoshenko.edostavka.ui.pages.password;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PasswordPage {

    protected static final Logger logger = LogManager.getLogger();
    public static int DEFAULT_WAIT_SECONDS = 4;

    public String getTitlePasswordText() {
        return Driver.getWebElement(By.xpath(PasswordLocators.TITLE_PASSWORD)).getText();
    }

    public String getLabelCredentialText(String input) {
        return Driver.getWebElement(By.xpath(String.format(PasswordLocators.LABEL_CREDENTIAL, input))).getText();
    }

    public String getSubmitButtonText() {
        return Driver.getWebElement(By.xpath(PasswordLocators.SUBMIT_BUTTON)).getText();
    }

    public String getSubmitButtonRegistrationText() {
        return Driver.getWebElement(By.xpath(PasswordLocators.SUBMIT_BUTTON_REGISTRATION)).getText();
    }

    public String getSubmitButtonEnterWithPhoneText() {
        return Driver.getWebElement(By.xpath(PasswordLocators.SUBMIT_BUTTON_ENTER_PHONE)).getText();
    }

    public String getLinkForgetPasswordText() {
        return Driver.getWebElement(By.xpath(PasswordLocators.LINK_FORGET_PASSWORD)).getText();
    }

    public String getErrorMessageText() {
        return Driver.getWebElement(By.xpath(PasswordLocators.ERROR_MESSAGE_CREDENTIAL)).getText();
    }

    public void fillInputCredential(String input, String value) {
        Driver.getWebElement(By.xpath(String.format(PasswordLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickSubmitButton() {
        logger.info("clickSubmitButton start");
        WebElement element = Driver.getWebElement(By.xpath(PasswordLocators.SUBMIT_BUTTON));
        Waits.enableElement(Driver.getDriver(), element);
        WebElement visibleElement = Waits.waitForElementToBeVisible(Driver.getDriver(), By.xpath(PasswordLocators.SUBMIT_BUTTON), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(Driver.getDriver(), visibleElement, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
        logger.info("SUBMIT_BUTTON clicked");
    }

    public void clickLinkForgetPassword() {
        logger.info("clickLinkForgetPassword start");
        WebElement visibleElement = Waits.waitForElementToBeVisible(Driver.getDriver(), By.xpath(PasswordLocators.LINK_FORGET_PASSWORD), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(Driver.getDriver(), visibleElement, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
        logger.info("LINK_FORGET_PASSWORD clicked");
    }
}
