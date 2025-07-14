package by.itacademy.timoshenko.edostavka.ui.pages;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private String MAIN_PAGE_URL = "https://edostavka.by";
    private static final String SUBMIT_BUTTON_COOKIE_LOCATOR = "//button[@class='btn btn_size_medium btn_colour_black cookies_button__qWM6Y']";
    private static final String SUBMIT_BUTTON_LOGIN_LOCATOR = "//button[@class='touchable_button__GJNQZ actions_action__button__OiPrx']";

    protected WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
        clickCloseCookie();
        clickLoginProfile();
    }

    public void clickCloseCookie() {
        driver.findElement(By.xpath(SUBMIT_BUTTON_COOKIE_LOCATOR)).click();
    }

    public void clickLoginProfile() {
        driver.findElement(By.xpath(SUBMIT_BUTTON_LOGIN_LOCATOR)).click();
    }
}
