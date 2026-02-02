package by.itacademy.timoshenko.edostavka.api;

import by.itacademy.timoshenko.edostavka.utils.ApiConfig;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class RecoveryApiClient {

    private Response response;

    public RecoveryApiClient(String phone, String surname) {
        this.response = sendRecoveryRequest(phone, surname);
    }

    private Response sendRecoveryRequest(String phone, String surname) {
        Response response = given()
                .header("Web-User-Agent", ApiConfig.USER_AGENT)
                .header("apiToken", ApiConfig.API_TOKEN_RECOVERY)
                .body(Map.of("phone", phone, "surname", surname))
                .when().post(ApiConfig.RECOVERY_URL);
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
