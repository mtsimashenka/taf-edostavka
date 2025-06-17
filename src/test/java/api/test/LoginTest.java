package api.test;

import by.itacademy.timoshenko.edostavka.api.LoginPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    @Test
    public void testLoginStatusCode() {
        LoginPage loginPage = new LoginPage();

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(422, loginPage.getStatusCode(), "StatusCode should be 422"),
                () -> assertEquals("phone", loginPage.getInvalidField()),
                () -> assertEquals("Поле номер телефона обязательно для заполнения", loginPage.getMessage())
        );
    }

    @Test
    public void testMessageWithCredential(){
        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage("375296550011", faker.internet().password());

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(422, loginPage.getStatusCode(), "StatusCode should be 422"),
                () -> assertEquals("Неверный логин или пароль", loginPage.getMessage())
        );
    }
}
