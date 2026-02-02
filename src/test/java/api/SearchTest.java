package api;

import by.itacademy.timoshenko.edostavka.api.SearchApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest {

    @Test
    public void test() {
        String search = "сникерс";
        SearchApiClient client = new SearchApiClient();
        String body = client.doSearch(search);

        Assertions.assertTrue(body.contains(search), "по запросу" + search + "не найден");
    }
}
