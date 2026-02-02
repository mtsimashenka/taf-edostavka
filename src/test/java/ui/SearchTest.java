package ui;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.pages.BasePage;
import by.itacademy.timoshenko.edostavka.ui.pages.search.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ui.config.UIConfigTest.*;

public class SearchTest {

    protected SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        searchPage = new SearchPage();
    }

    @BeforeEach
    public void openHomePageAndCloseCookie() {
        BasePage basePage = new BasePage();
        basePage.openHomePage();
    }

    @Test
    public void checkInputProduct() {
        searchPage.clickInputSearch();
        searchPage.inputProductInSearch();
        searchPage.enterProductInSearch();
        Assertions.assertTrue(searchPage.getSearchProductText().contains(PRODUCT_TEXT_SEARCH));
    }

    @AfterEach
    public void quitAndNullDriver() {
        Driver.quit();
    }
}
