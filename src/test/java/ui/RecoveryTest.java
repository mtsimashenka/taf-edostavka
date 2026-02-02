package ui;

import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import by.itacademy.timoshenko.edostavka.ui.pages.password.PasswordPage;
import by.itacademy.timoshenko.edostavka.ui.pages.recovery.RecoveryPage;
import by.itacademy.timoshenko.edostavka.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ui.config.UIConfigTest.*;

public class RecoveryTest extends BaseTest {

    protected LoginPage loginPage;
    protected PasswordPage passwordPage;
    protected RecoveryPage recoveryPage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.clickSubmitButtonEnterWithPassword();
        passwordPage = new PasswordPage();
        passwordPage.clickLinkForgetPassword();
        recoveryPage = new RecoveryPage();
    }

    @Test
    public void checkAllRecoveryPageText() {
        Assertions.assertTrue(recoveryPage.isDisplayedTitleRecoveryPageText(),"Элемент не оотображается на странице");
        Assertions.assertEquals(LABEL_BUTTON_SUBMIT_TEXT, recoveryPage.getSubmitButtonText());
        Assertions.assertEquals(LABEL_PHONE_NUMBER_TEXT, recoveryPage.getCredentialText(LABEL_PHONE_NUMBER_FIELD));
        Assertions.assertEquals(LABEL_SURNAME_TEXT, recoveryPage.getCredentialText(LABEL_SURNAME_FIELD));
    }

    @Test
    public void checkInputWithoutPhoneNumber() {
        recoveryPage.fillInputCredential(CREDENTIAL_FAMILY_FIELD, CREDENTIAL_FAMILY);
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_WITHOUT_PHONE_TEXT, recoveryPage.getErrorMessageText());
    }

    @Test
    public void checkInputWithoutSurname() {
        recoveryPage.fillInputCredential(PHONE_NUMBER_FIELD, Utils.generateRandomPhoneNumber());
        recoveryPage.clickInputCredential(CREDENTIAL_FAMILY_FIELD);
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_WITHOUT_SURNAME_TEXT, recoveryPage.getErrorMessageText());
    }

    @Test
    public void checkInputFullCredential() {
        recoveryPage.fillInputCredential(PHONE_NUMBER_FIELD, Utils.generateRandomPhoneNumber());
        recoveryPage.fillInputCredential(CREDENTIAL_FAMILY_FIELD, CREDENTIAL_FAMILY);
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_FULL_CREDENTIAL_TEXT, recoveryPage.getErrorMessageText());
    }

    @Test
    public void checkIncorrectCredential() {
        recoveryPage.fillInputCredential(PHONE_NUMBER_FIELD, PHONE_NUMBER_INCORRECT);
        recoveryPage.fillInputCredential(CREDENTIAL_FAMILY_FIELD, SURNAME_INCORRECT);
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_CREDENTIAL_TEXT, recoveryPage.getErrorMessageText());
    }
}
