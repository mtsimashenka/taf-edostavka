package by.itacademy.timoshenko.edostavka.ui.pages.recovery;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.pages.password.PasswordLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoveryPage {
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled');", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(d -> element.isDisplayed());
        element.click();
    }

    public void clickInputCredential(String input) {
        driver.findElement(By.xpath(String.format(RecoveryLocators.INPUT_CREDENTIAL, input))).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(By.xpath(RecoveryLocators.ERROR_MESSAGE_CREDENTIAL)).getText();
    }
}
