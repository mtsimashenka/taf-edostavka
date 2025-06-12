package by.itacademy.timoshenko.edostavka.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegistrationPage {

    private Response response;

    public RegistrationPage() {
        response = getResponse();
    }

    private Response getResponse() {
        Response response = given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RF")
                .body("{\"surname\":\"ё\",\"name\":\"\",\"patronymic\":\"\",\"email\":\"\",\"password\":\"\",\"phone\":\"375\",\"targets\":[]}")
                .when().post("https://api2.edostavka.by/api/v2/registration");
        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getPasswordText() {
        return response.path("invalidField[2]");
    }

    public String getErrorNameMessage() {
        return response.path("message[1]");
    }
}
