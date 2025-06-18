package api.test;

import by.itacademy.timoshenko.edostavka.api.RecoveryPage;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryTest {

    @Test
    public void testRecovery() {
        RecoveryPage recoveryPage = new RecoveryPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals("Поле номер телефона обязательно для заполнения", recoveryPage.getMessagePhone()),
                () -> assertEquals("Поле фамилия обязательно для заполнения", recoveryPage.getMessageSurname()),
                () -> assertEquals(422, recoveryPage.getStatusCode()),
                () -> assertEquals("surname", recoveryPage.getInvalidFieldSurname()),
                () -> assertEquals("phone", recoveryPage.getInvalidFieldPhone())
        );
    }

    @Test
    public void testMessageWithCredential() {
        RecoveryPage recoveryPage = new RecoveryPage("375292222222", "Sidorenko");

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals("Пожалуйста, убедитесь, что правильно ввели фамилию и телефон", recoveryPage.getMessagePhone()),
                () -> assertEquals("", recoveryPage.getWhatToDo()),
                () -> assertEquals(null, recoveryPage.getPreorderGroupGuid()),
                () -> assertEquals(400, recoveryPage.getStatusCode())
        );
    }

    @Test
    public void testMessageWithIncorrectCredential() {
        RecoveryPage recoveryPage = new RecoveryPage("3750000", "@!@$%^");

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals("Фамилия введена неверно", recoveryPage.getMessagePhone()),
                () -> assertEquals("surname", recoveryPage.getInvalidFieldPhone()),
                () -> assertEquals(422, recoveryPage.getStatusCode())
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
