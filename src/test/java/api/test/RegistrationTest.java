package api.test;

import by.itacademy.timoshenko.edostavka.api.RegistrationPage;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    @Test
    public void test1() {
        given()
                .header("Web-User-Agent", "SiteEdostavka/1.0.0")
                .header("apiToken", "JDhutdSrHfuoGzvn4M6ApT4GFUs8w9RF")
                .body("{\"surname\":\"\",\"name\":\"\",\"patronymic\":\"\",\"email\":\"\",\"password\":\"\",\"phone\":\"375\",\"targets\":[]}")
                .when().post("https://api2.edostavka.by/api/v2/registration")
                .then().log().all();
    }

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
