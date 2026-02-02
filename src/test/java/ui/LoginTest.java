package ui;

import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ui.config.UIConfigTest.*;

public class LoginTest extends BaseTest {

    protected LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void checkAllTextLoginPage() {
        Assertions.assertEquals(TITLE_LOGIN_TEXT, loginPage.getTitleLoginText());
        Assertions.assertEquals(LABEL_NUMBER_PHONE_TEXT, loginPage.getLabelPhoneText());
        Assertions.assertEquals(LABEL_ENTER_WITH_PASSWORD_TEXT, loginPage.getLabelButtonText(LABEL_ENTER_WITH_PASSWORD_TEXT));
        Assertions.assertEquals(LABEL_REGISTRATION_TEXT, loginPage.getLabelButtonText(LABEL_REGISTRATION_TEXT));
        Assertions.assertEquals(LABEL_GET_CODE_TEXT, loginPage.getLabelButtonText(LABEL_GET_CODE_TEXT));
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
