package by.itacademy.timoshenko.edostavka.ui.pages.login;


import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        driver = Driver.getDriver();
    }

    public String getTitleLoginText() {
        return driver.findElement(By.xpath(LoginLocators.TITLE_LOGIN)).getText();
    }

    public String getLabelPhoneText() {
        return driver.findElement(By.xpath(LoginLocators.LABEL_NUMBER_PHONE)).getText();
    }

    public String getLabelButtonText(String input) {
        return driver.findElement(By.xpath(String.format(LoginLocators.LABEL_BUTTONS, input))).getText();
    }

    public void clickSubmitButton() {
        driver.findElement(By.xpath(LoginLocators.SUBMIT_BUTTON)).click();
    }

    public void fillInputCorrectNumberPhone() {
        driver.findElement(By.xpath(LoginLocators.INPUT_PHONE)).sendKeys("222222222");
    }

    public void fillInputIncorrectNumberPhone() {
        driver.findElement(By.xpath(LoginLocators.INPUT_PHONE)).sendKeys("2222");
    }

    public String getErrorMessageText() {
        return driver.findElement(By.xpath(LoginLocators.ERROR_MESSAGE_NUMBER_PHONE)).getText();
    }

    public void clickSubmitButtonEnterWithPassword() {
        driver.findElement(By.xpath(LoginLocators.SUBMIT_BUTTON_ENTER_WITH_PASSWORD)).click();
    }

    public void clickSubmitButtonRegistration() {
        WebElement element = driver.findElement(By.xpath(LoginLocators.SUBMIT_BUTTON_REGISTRATION));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> element.isDisplayed());
        element.click();
    }

    public void clickSubmitButtonSupport() {
        driver.findElement(By.xpath(LoginLocators.SUBMIT_BUTTON_SUPPORT)).click();
    }

    public void clickLinkChatOnline() {
        driver.findElement(By.xpath(LoginLocators.LINK_CHAT_ONLINE)).click();
    }

    public void clickLinkTelegram() {
        driver.findElement(By.xpath(LoginLocators.LINK_TELEGRAM)).click();
    }
}
