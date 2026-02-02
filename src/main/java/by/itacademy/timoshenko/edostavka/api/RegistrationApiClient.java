package by.itacademy.timoshenko.edostavka.api;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import static by.itacademy.timoshenko.edostavka.utils.ApiConfig.*;
import static io.restassured.RestAssured.given;

public class RegistrationApiClient {

    private Response response;

    public RegistrationApiClient(String surname, String name, String patronymic,
                                 String email, String password, String phone) {
        this.response = sendRegistrationRequest(surname, name, patronymic, email, password, phone);
    }

    private Response sendRegistrationRequest(String surname, String name, String patronymic,
                                             String email, String password, String phone) {
        Map<String, Object> body = Map.of(
                "surname", surname,
                "name", name,
                "patronymic", patronymic,
                "email", email,
                "password", password,
                "phone", phone,
                "targets", List.of() // пустой список
        );
        return given()
                .header("Web-User-Agent", USER_AGENT)
                .header("apiToken", API_TOKEN_REGISTRATION)
                .contentType("application/json")
                .body(body)
                .when().post(REGISTRATION_URL);
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

    public String getEmailField() {
        return response.path("invalidField[3]");
    }
}
