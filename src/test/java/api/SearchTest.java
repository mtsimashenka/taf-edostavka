package api;

import by.itacademy.timoshenko.edostavka.api.SearchApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static api.config.ApiConfigTest.*;

public class SearchTest {

    @Test
    public void test() {
        SearchApiClient client = new SearchApiClient();
        String body = client.doSearch(SEARCH_PRODUCT);
        Assertions.assertTrue(body.contains(SEARCH_PRODUCT), String.format("по запросу %s не найден",SEARCH_PRODUCT));
    }
}
