import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

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
