package api.test;

import by.itacademy.timoshenko.edostavka.api.RegistrationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    @Test
    public void testRegistration() {
        RegistrationPage registrationPage = new RegistrationPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals("password", registrationPage.getPasswordText()),
                () -> assertEquals(422, registrationPage.getStatusCode()),
                () -> assertEquals("Поле имя обязательно для заполнения", registrationPage.getErrorNameMessage())
        );
    }
}
