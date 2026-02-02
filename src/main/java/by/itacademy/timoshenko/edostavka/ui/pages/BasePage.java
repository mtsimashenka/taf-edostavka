package by.itacademy.timoshenko.edostavka.ui.pages;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static by.itacademy.timoshenko.edostavka.utils.UIConfig.*;


public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }

    public void openLoginForm() {
        Driver.getUrl(MAIN_PAGE_URL);
        clickCloseCookie();
        clickLoginProfile();
    }

    public void openHomePage() {
        Driver.getUrl(MAIN_PAGE_URL);
        clickCloseCookie();
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
