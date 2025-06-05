import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    public final String TITLE_LOGIN_TEXT = "Вход";
    public final String LABEL_NUMBER_PHONE_TEXT = "Номер телефона";
    public final String LABEL_ENTER_WITH_PASSWORD_TEXT = "Войти по паролю";
    public final String LABEL_REGISTRATION_TEXT = "Зарегистрироваться";
    public final String LABEL_GET_CODE_TEXT = "Получить код";
    public final String ERROR_MESSAGE_INCORRECT_TEXT = "Номер введен некорректно";
    public final String ERROR_MESSAGE_CORRECT_TEXT = "Пожалуйста, убедитесь, что правильно ввели телефон";

    protected LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void checkAllTextLoginPage() {
        Assertions.assertEquals(TITLE_LOGIN_TEXT, loginPage.getTitleLoginText());
        Assertions.assertEquals(LABEL_NUMBER_PHONE_TEXT, loginPage.getLabelPhoneText());
        Assertions.assertEquals(LABEL_ENTER_WITH_PASSWORD_TEXT, loginPage.getLabelButtonText("Войти по паролю"));
        Assertions.assertEquals(LABEL_REGISTRATION_TEXT, loginPage.getLabelButtonText("Зарегистрироваться"));
        Assertions.assertEquals(LABEL_GET_CODE_TEXT, loginPage.getLabelButtonText("Получить код"));
    }

    @Test
    public void checkLoginWithIncorrectPhone() {
        loginPage.fillInputIncorrectNumberPhone();
        loginPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_TEXT, loginPage.getErrorMessageText());
    }

    @Test
    public void checkLoginWithCorrectPhone() {
        loginPage.fillInputCorrectNumberPhone();
        loginPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CORRECT_TEXT, loginPage.getErrorMessageText());
    }
}
