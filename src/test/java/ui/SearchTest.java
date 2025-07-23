package ui;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import by.itacademy.timoshenko.edostavka.ui.pages.BasePage;
import by.itacademy.timoshenko.edostavka.ui.pages.search.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest {

    public static String PRODUCT_TEXT_SEARCH = "По запросу «Сникерс» найдено 6 товаров";
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
        Assertions.assertEquals(PRODUCT_TEXT_SEARCH, searchPage.getSearchProductText());
    }

    @AfterEach
    public void quitAndNullDriver() {
        Driver.quit();
    }
}
