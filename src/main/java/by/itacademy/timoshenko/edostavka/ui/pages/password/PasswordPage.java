package by.itacademy.timoshenko.edostavka.ui.pages.password;


import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordPage {
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

    public void fillInputWithoutPassword(String input, String value) {
        driver.findElement(By.xpath(String.format(PasswordLocators.INPUT_CREDENTIAL, input))).sendKeys(value);
    }

    public void clickSubmitButton() {
        WebElement element = driver.findElement(By.xpath(PasswordLocators.SUBMIT_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled');", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(d -> element.isDisplayed());
        element.click();
    }

    public void clickLinkForgetPassword() {
        WebElement element = driver.findElement(By.xpath(PasswordLocators.LINK_FORGET_PASSWORD));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> element.isDisplayed());
        element.click();
    }
}
