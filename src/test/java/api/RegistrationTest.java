package api;

import by.itacademy.timoshenko.edostavka.api.RegistrationPage;
import org.junit.jupiter.api.Test;

import static api.config.ApiConfigTest.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    @Test
    public void testRegistration() {
        RegistrationPage registrationPage = new RegistrationPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(PASSWORD_FIELD, registrationPage.getPasswordText()),
                () -> assertEquals(STATUS_CODE, registrationPage.getStatusCode()),
                () -> assertEquals(NAME_LABEL, registrationPage.getErrorNameMessage())
        );
    }
}
