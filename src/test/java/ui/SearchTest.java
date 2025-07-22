package ui;

import by.itacademy.timoshenko.edostavka.ui.pages.search.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    public static String TITLE_SEARCH = "Поиск товаров";
    protected SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        searchPage = new SearchPage();
    }

    @Test
    public void checkAllTextSearchPage() {
        Assertions.assertEquals(TITLE_SEARCH, searchPage.getSearchInputTextTitle());
    }

    @Test
    public void checkInputProduct() {
        searchPage.clickInputSearch();
        searchPage.inputProductInSearch();
    }
}
