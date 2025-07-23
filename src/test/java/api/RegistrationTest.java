package api;

import by.itacademy.timoshenko.edostavka.api.RegistrationPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {
    public final String STATUS_CODE = "422";
    public final String PASSWORD_FIELD = "password";
    public final String NAME_LABEL = "Поле имя обязательно для заполнения";

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
