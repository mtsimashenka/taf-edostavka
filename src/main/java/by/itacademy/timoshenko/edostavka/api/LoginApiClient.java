package by.itacademy.timoshenko.edostavka.api;
import by.itacademy.timoshenko.edostavka.utils.ApiConfig;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class LoginApiClient {

    private final Response response;

    public LoginApiClient(String phone, String password) {
        this.response = sendAuthRequest(phone, password);
    }

    private static Response sendAuthRequest(String phone, String password) {
        return given()
                .header("apitoken", ApiConfig.API_TOKEN)
                .header("web-user-agent", ApiConfig.USER_AGENT)
                .contentType("application/json")
                .body(Map.of("phone", phone, "password", password))
                .post(ApiConfig.BASE_URL);
    }

    public int getStatusCode() {
        return response.statusCode(); // ← используем сохранённый ответ!
    }

    public String getInvalidField() {
        return response.path("invalidField[0]");
    }

    public String getMessage() {
        return response.path("message[0]");
    }
}
