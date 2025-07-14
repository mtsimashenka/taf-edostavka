package ui.test;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.pages.BasePage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected Faker faker;

    public BaseTest() {
        this.faker = new Faker();
    }

    @BeforeEach
    public void openHomePageAndCloseCookie() {
        BasePage basePage = new BasePage();
        basePage.open();
    }

    @AfterEach
    public void quitAndNullDriver() {
        Driver.quit();
    }
}
