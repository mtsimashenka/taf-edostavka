package api;

import by.itacademy.timoshenko.edostavka.api.RegistrationApiClient;
import org.junit.jupiter.api.Test;
import static api.config.ApiConfigTest.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    @Test
    public void testRegistration() {
        RegistrationApiClient client = new RegistrationApiClient(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY_PHONE);

        assertAll(
                "Проверка пустых полей",
                () -> assertEquals(PASSWORD_FIELD, client.getPasswordText()),
                () -> assertEquals(STATUS_CODE_ERROR, client.getStatusCode()),
                () -> assertEquals(NAME_LABEL, client.getErrorNameMessage())
        );
    }

    @Test
    void shouldReturn422WhenEmailIsInvalid() {
        RegistrationApiClient client = new RegistrationApiClient(
                REGISTRATION_SURNAME, REGISTRATION_NAME, REGISTRATION_PATRONYMIC,
                INVALID_EMAIL, CORRECT_PASSWORD, VALID_PHONE
        );

        assertAll(
                "Проверка невалидного email",
                () -> assertEquals(STATUS_CODE_ERROR, client.getStatusCode()),
                () -> assertEquals(EMAIL_FIELD, client.getEmailField())
        );
    }
}
