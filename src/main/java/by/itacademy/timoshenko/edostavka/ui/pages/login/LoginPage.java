package by.itacademy.timoshenko.edostavka.ui.pages.login;


import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.driver.Waits;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    protected static final Logger logger = LogManager.getLogger();
    public static int DEFAULT_WAIT_SECONDS = 4;
    public final static String PHONE_NUMBER_INCORRECT = "2222";


    public String getTitleLoginText() {
        return Driver.getWebElement(By.xpath(LoginLocators.TITLE_LOGIN)).getText();
    }

    public String getLabelPhoneText() {
        return Driver.getWebElement(By.xpath(LoginLocators.LABEL_NUMBER_PHONE)).getText();
    }

    public String getLabelButtonText(String input) {
        return Driver.getWebElement(By.xpath(String.format(LoginLocators.LABEL_BUTTONS, input))).getText();
    }

    public void clickSubmitButton() {
        logger.info("clickSubmitButton start");
        Driver.getWebElement(By.xpath(LoginLocators.SUBMIT_BUTTON)).click();
        logger.info("SUBMIT_BUTTON clicked");
    }

    public void fillInputCorrectNumberPhone() {
        Driver.getWebElement(By.xpath(LoginLocators.INPUT_PHONE)).sendKeys(Utils.generateRandomPhoneNumber());
    }

    public void fillInputIncorrectNumberPhone() {
        Driver.getWebElement(By.xpath(LoginLocators.INPUT_PHONE)).sendKeys(PHONE_NUMBER_INCORRECT);
    }

    public String getErrorMessageText() {
        return Driver.getWebElement(By.xpath(LoginLocators.ERROR_MESSAGE_NUMBER_PHONE)).getText();
    }

    public void clickSubmitButtonEnterWithPassword() {
        logger.info("clickSubmitButtonEnterWithPassword start");
        Driver.getWebElement(By.xpath(LoginLocators.SUBMIT_BUTTON_ENTER_WITH_PASSWORD)).click();
        logger.info("SUBMIT_BUTTON_ENTER_WITH_PASSWORD clicked");
    }

    public void clickSubmitButtonRegistration() {
        logger.info("clickSubmitButtonRegistration start");
        WebElement element = Driver.getWebElement(By.xpath(LoginLocators.SUBMIT_BUTTON_REGISTRATION));
        WebElement clickableElement = Waits.waitForElementToBeClickable(Driver.getDriver(), element, DEFAULT_WAIT_SECONDS);
        clickableElement.click();
        logger.info("SUBMIT_BUTTON_REGISTRATION clicked");
    }
}
