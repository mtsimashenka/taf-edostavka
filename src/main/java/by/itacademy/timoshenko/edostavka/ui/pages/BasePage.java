package by.itacademy.timoshenko.edostavka.ui.pages;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    private String MAIN_PAGE_URL = "https://edostavka.by";
    private static final String SUBMIT_BUTTON_COOKIE_LOCATOR = "//button[@class='btn btn_size_medium btn_colour_black cookies_button__qWM6Y']";
    private static final String SUBMIT_BUTTON_LOGIN_LOCATOR = "//button[@class='touchable_button__GJNQZ actions_action__button__OiPrx']";

    protected WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }

    public void open() {
        Driver.getUrl(MAIN_PAGE_URL);
        clickCloseCookie();
        clickLoginProfile();
    }

    public void clickCloseCookie() {
        logger.info("clickCloseCookie start");
        Driver.getWebElement(By.xpath(SUBMIT_BUTTON_COOKIE_LOCATOR)).click();
        logger.info("SUBMIT_BUTTON_COOKIE_LOCATOR clicked");
    }

    public void clickLoginProfile() {
        logger.info("clickLoginProfile start");
        Driver.getWebElement(By.xpath(SUBMIT_BUTTON_LOGIN_LOCATOR)).click();
        logger.info("SUBMIT_BUTTON_LOGIN_LOCATOR clicked");
    }
}
