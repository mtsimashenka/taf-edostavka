package by.itacademy.timoshenko.edostavka.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RecoveryPage {
    private Response response;

    public RecoveryPage() {
        response = getResponse();
    }

    public RecoveryPage(String phone, String surname) {
        response = getResponse();
    }

    private Response getResponse() {
        Response response = given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RFs")
                .body("{\"phone\":\"\",\"surname\":\"\"}")
                .when().post("https://api2.edostavka.by/api/v2/sms-recovery");
        return getResponse();
    }

    private Response getResponse(String phone, String surname) {
        Response response = given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RFs")
                .body("{\"phone\":\"" + phone + "\",\"surname\":\"" + surname + "\"}")
                .when().post("https://api2.edostavka.by/api/v2/sms-recovery");
        return getResponse();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getPhoneMessage() {
        return response.path("message[0]");
    }

    public String getInvalidFieldSurname() {
        return response.path("invalidField[1]");
    }
}
