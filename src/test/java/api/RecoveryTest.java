package api;

import by.itacademy.timoshenko.edostavka.api.RecoveryPage;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryTest {
    public final String SURNAME_CORRECT = "Sidorenko";
    public final String PHONE_NUMBER_LABEL = "Поле номер телефона обязательно для заполнения";
    public final String SURNAME_LABEL = "Поле фамилия обязательно для заполнения";
    public final String SURNAME_ERROR = "Фамилия введена неверно";
    public final String SURNAME_FIELD = "surname";
    public final String PHONE_FIELD = "phone";
    public final String STATUS_CODE_ERROR = "422";
    public final String STATUS_CODE_ERROR_WITH_CREDENTIAL = "400";
    public final String SURNAME_AND_PHONE_LABEL = "Пожалуйста, убедитесь, что правильно ввели фамилию и телефон";
    public final String EMPTY_INPUT = "";
    public final String INCORRECT_PHONE = "3750000";
    public final String INCORRECT_PASSWORD = "@!@$%^";

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

    @Test
    public void test1() {
        given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RF")
//                .body("{\"phone\":\"" + "375292222222" + "\",\"surname\":\"" + "Sidorenko" + "\"}")
                .body("{\"phone\":\"" + "3750000" + "\",\"surname\":\"" + "@!@$%^" + "\"}")
//                .body("{\"phone\":\"" + "" + "\",\"surname\":\"" + "" + "\"}")
                .when().post("https://api2.edostavka.by/api/v2/sms-recovery")
                .then().log().all();
    }
}
