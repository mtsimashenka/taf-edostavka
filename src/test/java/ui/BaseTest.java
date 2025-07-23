package ui;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.pages.BasePage;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected Faker faker;

    public BaseTest() {
        this.faker = new Faker();
    }

    @BeforeEach
    public void openHomePageAndCloseCookie() {
        BasePage basePage = new BasePage();
        basePage.openLoginForm();
    }

    @AfterEach
    public void quitAndNullDriver() {
        Driver.quit();
    }
}
