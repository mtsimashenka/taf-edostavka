package by.itacademy.timoshenko.edostavka.ui.pages.recovery;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RecoveryPage {
    public static int DEFAULT_WAIT_SECONDS = 10;
    private WebDriver driver;

    public RecoveryPage() {
        driver = Driver.getDriver();
    }

    public Boolean isDisplayedTitleRecoveryPageText() {
        WebElement element = driver.findElement(By.xpath(RecoveryLocators.TITLE_RECOVERY));
        return element.isDisplayed();
    }

    public String getSubmitButtonText() {
        return driver.findElement(By.xpath(RecoveryLocators.BUTTON_SUBMIT)).getText();
    }

    public String getCredentialText(String input) {
        return driver.findElement(By.xpath(String.format(RecoveryLocators.LABEL_CREDENTIAL, input))).getText();
    }

    public void fillInputCredential(String input, String value) {
        driver.findElement(By.xpath(String.format(RecoveryLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickSubmitButton() {
        WebElement element = driver.findElement(By.xpath(RecoveryLocators.BUTTON_SUBMIT));
        Waits.enableElement(driver, element);
        WebElement visibleElement = Waits.waitForElementToBeVisible(driver, By.xpath(RecoveryLocators.BUTTON_SUBMIT), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(driver, visibleElement, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
    }

    public void clickInputCredential(String input) {
        driver.findElement(By.xpath(String.format(RecoveryLocators.INPUT_CREDENTIAL, input))).click();
    }

    public String getErrorMessageText() {
        return Waits.waitForTextToBePresent(driver, By.xpath(RecoveryLocators.ERROR_MESSAGE_CREDENTIAL), DEFAULT_WAIT_SECONDS);
    }
}
