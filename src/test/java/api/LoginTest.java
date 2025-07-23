package api;

import by.itacademy.timoshenko.edostavka.api.LoginPage;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    public final int STATUS_CODE_ERROR = 422;
    public final String PHONE_FIELD = "phone";
    public final String PHONE_LABEL = "Поле номер телефона обязательно для заполнения";
    public final String LOGIN_AND_PASSWORD_ERROR = "Неверный логин или пароль";

    @Test
    public void testLoginStatusCode() {
        LoginPage loginPage = new LoginPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(STATUS_CODE_ERROR, loginPage.getStatusCode(), "StatusCode should be 422"),
                () -> assertEquals(PHONE_FIELD, loginPage.getInvalidField()),
                () -> assertEquals(PHONE_LABEL, loginPage.getMessage())
        );
    }

    @Test
    public void testMessageWithCredential(){
        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage(Utils.generateRandomPhoneNumber(), faker.internet().password());

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(STATUS_CODE_ERROR, loginPage.getStatusCode(), "StatusCode should be 422"),
                () -> assertEquals(LOGIN_AND_PASSWORD_ERROR, loginPage.getMessage())
        );
    }
}
