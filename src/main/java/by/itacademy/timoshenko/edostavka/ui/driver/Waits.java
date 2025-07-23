package by.itacademy.timoshenko.edostavka.ui.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
        public static String SCRIPT_DISABLED = "arguments[0].removeAttribute('disabled');";

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void enableElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(SCRIPT_DISABLED, element);
    }
}
