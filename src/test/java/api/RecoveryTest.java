package api;

import by.itacademy.timoshenko.edostavka.api.RecoveryPage;
import by.itacademy.timoshenko.edostavka.utils.Utils;

import static api.config.ApiConfigTest.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryTest {

    @Test
    public void testRecovery() {
        RecoveryPage recoveryPage = new RecoveryPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(PHONE_NUMBER_LABEL, recoveryPage.getMessagePhone()),
                () -> assertEquals(SURNAME_LABEL, recoveryPage.getMessageSurname()),
                () -> assertEquals(STATUS_CODE_ERROR, recoveryPage.getStatusCode()),
                () -> assertEquals(SURNAME_FIELD, recoveryPage.getInvalidFieldSurname()),
                () -> assertEquals(PHONE_FIELD, recoveryPage.getInvalidFieldPhone())
        );
    }

    @Test
    public void testMessageWithCredential() {
        RecoveryPage recoveryPage = new RecoveryPage(Utils.generateRandomPhoneNumber(), SURNAME_CORRECT);

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(SURNAME_AND_PHONE_LABEL, recoveryPage.getMessagePhone()),
                () -> assertEquals(EMPTY_INPUT, recoveryPage.getWhatToDo()),
                () -> assertEquals(null, recoveryPage.getPreorderGroupGuid()),
                () -> assertEquals(STATUS_CODE_ERROR_WITH_CREDENTIAL, recoveryPage.getStatusCode())
        );
    }

    @Test
    public void testMessageWithIncorrectCredential() {
        RecoveryPage recoveryPage = new RecoveryPage(INCORRECT_PHONE, INCORRECT_PASSWORD);

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(SURNAME_ERROR, recoveryPage.getMessagePhone()),
                () -> assertEquals(SURNAME_FIELD, recoveryPage.getInvalidFieldPhone()),
                () -> assertEquals(STATUS_CODE_ERROR, recoveryPage.getStatusCode())
        );
    }
}
