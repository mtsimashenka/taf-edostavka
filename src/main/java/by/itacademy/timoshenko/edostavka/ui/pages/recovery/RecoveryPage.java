package by.itacademy.timoshenko.edostavka.ui.pages.recovery;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RecoveryPage {

    protected static final Logger logger = LogManager.getLogger();
    public static int DEFAULT_WAIT_SECONDS = 10;


    public Boolean isDisplayedTitleRecoveryPageText() {
        WebElement element = Driver.getWebElementByXpath(By.xpath(RecoveryLocators.TITLE_RECOVERY));
        return element.isDisplayed();
    }

    public String getSubmitButtonText() {
        return Driver.getWebElementByXpath(By.xpath(RecoveryLocators.BUTTON_SUBMIT)).getText();
    }

    public String getCredentialText(String input) {
        return Driver.getWebElementByXpath(By.xpath(String.format(RecoveryLocators.LABEL_CREDENTIAL, input))).getText();
    }

    public void fillInputCredential(String input, String value) {
        Driver.getWebElementByXpath(By.xpath(String.format(RecoveryLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickSubmitButton() {
        logger.info("clickSubmitButton start");
        WebElement element = Driver.getWebElementByXpath(By.xpath(RecoveryLocators.BUTTON_SUBMIT));
        Waits.enableElement(Driver.getDriver(), element);
        WebElement visibleElement = Waits.waitForElementToBeVisible(Driver.getDriver(), By.xpath(RecoveryLocators.BUTTON_SUBMIT), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(Driver.getDriver(), visibleElement, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
        logger.info("BUTTON_SUBMIT clicked");
    }

    public void clickInputCredential(String input) {
        logger.info("clickInputCredential start");
        Driver.getWebElementByXpath(By.xpath(String.format(RecoveryLocators.INPUT_CREDENTIAL, input))).click();
        logger.info("INPUT_CREDENTIAL clicked");
    }

    public String getErrorMessageText() {
        WebElement visibleElement = Waits.waitForElementToBeVisible(Driver.getDriver(), By.xpath(RecoveryLocators.ERROR_MESSAGE_CREDENTIAL), DEFAULT_WAIT_SECONDS);
        return visibleElement.getText();
    }
}
