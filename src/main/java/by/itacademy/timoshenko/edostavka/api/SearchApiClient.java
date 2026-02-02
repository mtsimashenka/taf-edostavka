package by.itacademy.timoshenko.edostavka.api;

import static by.itacademy.timoshenko.edostavka.utils.ApiConfig.*;
import static io.restassured.RestAssured.given;

public class SearchApiClient {

    public String doSearch(String query) {
        return given()
                .queryParam("query", query)
                .when().get(SEARCH_URL).then()
                .extract()
                .response()
                .body()
                .asString();
    }
}
