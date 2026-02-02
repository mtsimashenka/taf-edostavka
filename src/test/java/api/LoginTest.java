package api;
import by.itacademy.timoshenko.edostavka.api.LoginApiClient;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import static api.config.ApiConfigTest.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    public void testLoginStatusCode() {
        Faker faker = new Faker();
        LoginApiClient client = new LoginApiClient("", faker.internet().password());

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(STATUS_CODE_ERROR, client.getStatusCode(), "StatusCode should be 422"),
                () -> assertEquals(PHONE_FIELD, client.getInvalidField()),
                () -> assertEquals(PHONE_LABEL, client.getMessage())
        );
    }

    @Test
    public void testMessageWithCredential() {
        Faker faker = new Faker();
        LoginApiClient client = new LoginApiClient(Utils.generateRandomPhoneNumber(), faker.internet().password());

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(STATUS_CODE_ERROR, client.getStatusCode(), "StatusCode should be 422"),
                () -> assertEquals(PHONE_LABEL, client.getMessage())
        );
    }
}
