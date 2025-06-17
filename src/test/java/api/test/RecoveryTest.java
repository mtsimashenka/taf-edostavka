package api.test;

import by.itacademy.timoshenko.edostavka.api.RecoveryPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryTest {

    @Test
    public void testRecovery() {
        RecoveryPage recoveryPage = new RecoveryPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals("Поле номер телефона обязательно для заполнения", recoveryPage.getPhoneMessage()),
                () -> assertEquals(422, recoveryPage.getStatusCode()),
                () -> assertEquals("surname", recoveryPage.getInvalidFieldSurname())
        );
    }

    @Test
    public void testMessageWithCredential() {
        RecoveryPage recoveryPage = new RecoveryPage("375292222222", "Sidorov");

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals("Пожалуйста, убедитесь, что правильно ввели фамилию и телефон", recoveryPage.getPhoneMessage()),
                () -> assertEquals(400, recoveryPage.getStatusCode())
        );
    }
}
