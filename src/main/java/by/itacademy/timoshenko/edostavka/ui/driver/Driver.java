package by.itacademy.timoshenko.edostavka.ui.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Driver {
    private static final Logger logger = LogManager.getLogger(Driver.class);
    private static Duration DEFAULT_IMPLICITLY_WAIT_SECONDS = Duration.ofSeconds(4);
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT_SECONDS);
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebElement getWebElement(By byXpath) {
        logger.info(String.format("Получение элемента по локатору %s", byXpath));
        return driver.findElement(byXpath);
    }

    public static void getUrl(String URL) {
        driver.get(URL);
    }
}
