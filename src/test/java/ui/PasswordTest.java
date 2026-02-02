package ui;

import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import by.itacademy.timoshenko.edostavka.ui.pages.password.PasswordPage;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ui.config.UIConfigTest.*;


public class PasswordTest extends BaseTest {

    protected LoginPage loginPage;
    protected PasswordPage passwordPage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.clickSubmitButtonEnterWithPassword();
        passwordPage = new PasswordPage();
    }

    @Test
    public void checkAllTextPasswordPage() {
        Assertions.assertEquals(TITLE_PASSWORD_TEXT, passwordPage.getTitlePasswordText());
        Assertions.assertEquals(LABEL_PHONE_TEXT, passwordPage.getLabelCredentialText(LABEL_PHONE_TEXT));
        Assertions.assertEquals(LABEL_PASSWORD_TEXT, passwordPage.getLabelCredentialText(LABEL_PASSWORD_TEXT));
        Assertions.assertEquals(SUBMIT_BUTTON_TEXT, passwordPage.getSubmitButtonText());
        Assertions.assertEquals(SUBMIT_BUTTON_REGISTRATION_TEXT, passwordPage.getSubmitButtonRegistrationText());
        Assertions.assertEquals(SUBMIT_BUTTON_ENTER_PHONE_TEXT, passwordPage.getSubmitButtonEnterWithPhoneText());
        Assertions.assertEquals(LINK_FORGET_PASSWORD_TEXT, passwordPage.getLinkForgetPasswordText());
    }

    @Test
    public void checkInputWithoutPassword() {
        passwordPage.fillInputCredential(PHONE_FIELD, Utils.generateRandomPhoneNumber());
        passwordPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_TEXT, passwordPage.getErrorMessageText());
    }

    @Test
    public void checkInputWithoutPhoneNumber() {
        passwordPage.fillInputCredential(PASSWORD_FIELD, faker.internet().password());
        passwordPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_WITHOUT_PHONE_TEXT, passwordPage.getErrorMessageText());
    }

    @Test
    public void checkInputWithPasswordAndPhoneNumber() {
        passwordPage.fillInputCredential(PHONE_FIELD, Utils.generateRandomPhoneNumber());
        passwordPage.fillInputCredential(PASSWORD_FIELD, faker.internet().password());
        passwordPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_TEXT, passwordPage.getErrorMessageText());
    }
}
