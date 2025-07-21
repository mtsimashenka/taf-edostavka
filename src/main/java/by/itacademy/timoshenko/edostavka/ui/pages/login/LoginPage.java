package by.itacademy.timoshenko.edostavka.ui.pages.login;


import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static int DEFAULT_WAIT_SECONDS = 4;
    public final static String PHONE_NUMBER_INCORRECT = "2222";
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
        driver.findElement(By.xpath(LoginLocators.INPUT_PHONE)).sendKeys(Utils.generateRandomPhoneNumber());
    }

    public void fillInputIncorrectNumberPhone() {
        driver.findElement(By.xpath(LoginLocators.INPUT_PHONE)).sendKeys(PHONE_NUMBER_INCORRECT);
    }

    public String getErrorMessageText() {
        return driver.findElement(By.xpath(LoginLocators.ERROR_MESSAGE_NUMBER_PHONE)).getText();
    }

    public void clickSubmitButtonEnterWithPassword() {
        driver.findElement(By.xpath(LoginLocators.SUBMIT_BUTTON_ENTER_WITH_PASSWORD)).click();
    }

    public void clickSubmitButtonRegistration() {
        WebElement element = driver.findElement(By.xpath(LoginLocators.SUBMIT_BUTTON_REGISTRATION));
        WebElement clickableElement = Waits.waitForElementToBeClickable(driver, element, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
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
