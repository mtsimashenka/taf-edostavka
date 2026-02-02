package by.itacademy.timoshenko.edostavka.api;
import by.itacademy.timoshenko.edostavka.utils.ApiConfig;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RecoveryPage {

    private Response response;

    public RecoveryPage() {
        response = getResponse();
    }

    public RecoveryPage(String phone, String surname) {
        response = getResponse(phone, surname);
    }

    private Response getResponse() {
        Response response = given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RF")
                .body("{\"phone\":\"\",\"surname\":\"\"}")
                .when().post("https://api2.edostavka.by/api/v2/sms-recovery");

        return getResponse(ApiConfig.DEFAULT_PHONE_NUMBER, ApiConfig.DEFAULT_SURNAME);
    }

    private Response getResponse(String phone, String surname) {
        Response response = given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RF")
                .body("{\"phone\":\"" + phone + "\",\"surname\":\"" + surname + "\"}")
                .when().post("https://api2.edostavka.by/api/v2/sms-recovery");
        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getMessagePhone() {
        return response.path("message[0]");
    }

    public String getMessageSurname() {
        return response.path("message[1]");
    }

    public String getInvalidFieldPhone() {
        return response.path("invalidField[0]");
    }

    public String getInvalidFieldSurname() {
        return response.path("invalidField[1]");
    }

    public String getWhatToDo() {
        return response.path("whatToDo[0]");
    }

    public String getPreorderGroupGuid() {
        return response.path("preorderGroupGuid[0]");
    }
}
