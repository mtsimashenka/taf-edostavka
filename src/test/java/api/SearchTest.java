package api;

import by.itacademy.timoshenko.edostavka.api.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest {

    @Test
    public void test() {
        String search = "сникерс";
        SearchPage searchPage = new SearchPage();
        String body = searchPage.doSearch(search);

        Assertions.assertTrue(body.contains(search), "по запросу" + search + "не найден");
    }
}
