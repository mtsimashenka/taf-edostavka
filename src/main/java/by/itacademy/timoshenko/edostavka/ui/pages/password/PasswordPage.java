package by.itacademy.timoshenko.edostavka.ui.pages.password;


import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {
    public static int DEFAULT_WAIT_SECONDS = 4;
    private WebDriver driver;

    public PasswordPage() {
        driver = Driver.getDriver();
    }

    public String getTitlePasswordText() {
        return driver.findElement(By.xpath(PasswordLocators.TITLE_PASSWORD)).getText();
    }

    public String getLabelCredentialText(String input) {
        return driver.findElement(By.xpath(String.format(PasswordLocators.LABEL_CREDENTIAL, input))).getText();
    }

    public String getSubmitButtonText() {
        return driver.findElement(By.xpath(PasswordLocators.SUBMIT_BUTTON)).getText();
    }

    public String getSubmitButtonRegistrationText() {
        return driver.findElement(By.xpath(PasswordLocators.SUBMIT_BUTTON_REGISTRATION)).getText();
    }

    public String getSubmitButtonEnterWithPhoneText() {
        return driver.findElement(By.xpath(PasswordLocators.SUBMIT_BUTTON_ENTER_PHONE)).getText();
    }

    public String getLinkForgetPasswordText() {
        return driver.findElement(By.xpath(PasswordLocators.LINK_FORGET_PASSWORD)).getText();
    }

    public String getErrorMessageText() {
        return driver.findElement(By.xpath(PasswordLocators.ERROR_MESSAGE_CREDENTIAL)).getText();
    }

    public void fillInputCredential(String input, String value) {
        driver.findElement(By.xpath(String.format(PasswordLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickSubmitButton() {
        WebElement element = driver.findElement(By.xpath(PasswordLocators.SUBMIT_BUTTON));
        Waits.enableElement(driver, element);
        Waits.waitForElementToBeVisible(driver, By.xpath(PasswordLocators.SUBMIT_BUTTON), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(driver, element, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
    }

    public void clickLinkForgetPassword() {
        WebElement element = driver.findElement(By.xpath(PasswordLocators.LINK_FORGET_PASSWORD));
        WebElement visibleElement = Waits.waitForElementToBeVisible(driver, By.xpath(PasswordLocators.LINK_FORGET_PASSWORD), DEFAULT_WAIT_SECONDS);
        WebElement clickableElement = Waits.waitForElementToBeClickable(driver, visibleElement, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
    }
}
