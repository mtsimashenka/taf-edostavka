package api;

import org.junit.jupiter.api.Test;
import by.itacademy.timoshenko.edostavka.api.RecoveryApiClient;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import static api.config.ApiConfigTest.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryTest {

    @Test
    public void testRecovery() {
        RecoveryApiClient client = new RecoveryApiClient("", "");

        assertAll(
                "Проверка пустых полей",
                () -> assertEquals(PHONE_NUMBER_LABEL, client.getMessagePhone()),
                () -> assertEquals(SURNAME_LABEL, client.getMessageSurname()),
                () -> assertEquals(STATUS_CODE_ERROR, client.getStatusCode()),
                () -> assertEquals(SURNAME_FIELD, client.getInvalidFieldSurname()),
                () -> assertEquals(PHONE_FIELD, client.getInvalidFieldPhone())
        );
    }

    @Test
    public void testMessageWithCredential() {
        RecoveryApiClient client = new RecoveryApiClient(Utils.generateRandomPhoneNumber(), SURNAME_CORRECT);

        assertAll(
                "Проверка неверных данных",
                () -> assertEquals(SURNAME_AND_PHONE_LABEL, client.getMessagePhone()),
                () -> assertEquals(EMPTY_INPUT, client.getWhatToDo()),
                () -> assertEquals(null, client.getPreorderGroupGuid()),
                () -> assertEquals(STATUS_CODE_ERROR_WITH_CREDENTIAL, client.getStatusCode())
        );
    }

    @Test
    public void testMessageWithIncorrectCredential() {
        RecoveryApiClient client = new RecoveryApiClient(INCORRECT_PHONE, INCORRECT_PASSWORD);

        assertAll(
                "Проверка невалидной фамилии",
                () -> assertEquals(SURNAME_ERROR, client.getMessagePhone()),
                () -> assertEquals(SURNAME_FIELD, client.getInvalidFieldPhone()),
                () -> assertEquals(STATUS_CODE_ERROR, client.getStatusCode())
        );
    }
}
