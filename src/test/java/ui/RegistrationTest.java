package ui;

import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import by.itacademy.timoshenko.edostavka.ui.pages.registration.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ui.config.UIConfigTest.*;

public class RegistrationTest extends BaseTest {

    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.clickSubmitButtonRegistration();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void checkAllRegistrationPageText() {
        Assertions.assertEquals(TITLE_REGISTRATION_TEXT, registrationPage.getTitleRegistrationText());
        Assertions.assertEquals(BUTTON_SUBMIT_TEXT, registrationPage.getSubmitButtonText());
        Assertions.assertEquals(COMMIT_PASSWORD_TEXT, registrationPage.getCommitPasswordText());
        Assertions.assertEquals(LABEL_PHONE_NUMBER_TEXT, registrationPage.getLabelPhoneNumberText());
        Assertions.assertEquals(LINK_I_AGREE_TEXT, registrationPage.getLinkImAgreeText());
        Assertions.assertEquals(CHECKBOX_EMAIL_TEXT, registrationPage.getCheckBoxText(CHECKBOX_EMAIL));
        Assertions.assertEquals(CHECKBOX_EVROPOCHTA_TEXT, registrationPage.getCheckBoxText(CHECKBOX_EVROPOCHTA));
        Assertions.assertEquals(CHECKBOX_EVEZUNCHIKI_TEXT, registrationPage.getCheckBoxText(CHECKBOX_EVEZUNCHIKI));
        Assertions.assertEquals(CHECKBOX_EDOSTAVKA_TEXT, registrationPage.getCheckBoxText(CHECKBOX_EDOSTAVKA));
        Assertions.assertEquals(LABEL_NAME_TEXT, registrationPage.getLabelCredentialText(LABEL_NAME_TEXT));
        Assertions.assertEquals(LABEL_SURNAME_TEXT, registrationPage.getLabelCredentialText(LABEL_SURNAME_TEXT));
        Assertions.assertEquals(LABEL_PATRONYMIC_TEXT, registrationPage.getLabelCredentialText(LABEL_PATRONYMIC_TEXT));
        Assertions.assertEquals(LABEL_EMAIL_TEXT, registrationPage.getLabelCredentialText(LABEL_EMAIL_TEXT));
        Assertions.assertEquals(LABEL_PASSWORD_TEXT, registrationPage.getLabelCredentialText(LABEL_PASSWORD_TEXT));
        Assertions.assertEquals(LABEL_PASSWORD_AGAIN, registrationPage.getLabelCredentialText(LABEL_PASSWORD_AGAIN));
    }

    @Test
    public void checkEmptyInput() {
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_NAME_TEXT, registrationPage.getErrorMessageText(LABEL_NAME_TEXT));
        Assertions.assertEquals(ERROR_MESSAGE_SURNAME_TEXT, registrationPage.getErrorMessageText(LABEL_SURNAME_TEXT));
        Assertions.assertEquals(ERROR_MESSAGE_PHONE_TEXT, registrationPage.getErrorMessagePhoneText());
        Assertions.assertEquals(ERROR_MESSAGE_PASSWORD_TEXT, registrationPage.getErrorMessagePasswordText());
        Assertions.assertEquals(ERROR_MESSAGE_AGREEMENT_TEXT, registrationPage.getErrorMessageAgreementText());
    }

    @Test
    public void checkIncorrectInput() {
        registrationPage.fillInputCredential(NAME_FIELD, INCORRECT_CREDENTIAL);
        registrationPage.fillInputCredential(SURNAME_FIELD, INCORRECT_CREDENTIAL);
        registrationPage.fillInputCredential(PATRONYMIC_FIELD, INCORRECT_CREDENTIAL);
        registrationPage.fillInputCredential(PHONE_FIELD, INCORRECT_PHONE_NUMBER);
        registrationPage.fillInputCredential(EMAIL_FIELD, INCORRECT_EMAIL);
        registrationPage.fillInputCredential(PASSWORD_FIELD, faker.internet().password());
        registrationPage.fillInputCredential(PASSWORD_AGAIN_FIELD, faker.internet().password());
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_NAME_TEXT, registrationPage.getErrorMessageText(LABEL_NAME_TEXT));
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_SURNAME_TEXT, registrationPage.getErrorMessageText(LABEL_SURNAME_TEXT));
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_PATRONYMIC_TEXT, registrationPage.getErrorMessageText(LABEL_PATRONYMIC_TEXT));
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_EMAIL_TEXT, registrationPage.getErrorMessageText(LABEL_EMAIL_TEXT));
        Assertions.assertEquals(ERROR_MESSAGE_PHONE_TEXT, registrationPage.getErrorMessagePhoneText());
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_PASSWORD_TEXT, registrationPage.getErrorMessagePasswordText());
        Assertions.assertEquals(ERROR_MESSAGE_AGREEMENT_TEXT, registrationPage.getErrorMessageAgreementText());
    }

    @Test
    public void checkIncorrectPassword() {
        registrationPage.fillInputCredential(PASSWORD_FIELD, INCORRECT_PASSWORD);
        registrationPage.fillInputCredential(PASSWORD_AGAIN_FIELD, INCORRECT_PASSWORD);
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_IDENTICAL_PASSWORD_TEXT, registrationPage.getErrorMessagePasswordText());
    }

    @Test
    public void checkCorrectInput() {
        registrationPage.clickCheckBox(CHECKBOX_EMAIL);
        registrationPage.clickCheckBox(CHECKBOX_EVROPOCHTA);
        registrationPage.clickCheckBox(CHECKBOX_EVEZUNCHIKI);
        registrationPage.fillInputCredential(NAME_FIELD, CORRECT_NAME);
        registrationPage.fillInputCredential(SURNAME_FIELD, CORRECT_SURNAME);
        registrationPage.fillInputCredential(PATRONYMIC_FIELD, CORRECT_PATRONYMIC);
        registrationPage.fillInputCredential(PHONE_FIELD, CORRECT_PHONE);
        registrationPage.fillInputCredential(EMAIL_FIELD, CORRECT_EMAIL);
        registrationPage.fillInputCredential(PASSWORD_FIELD, CORRECT_PASSWORD);
        registrationPage.fillInputCredential(PASSWORD_AGAIN_FIELD, CORRECT_PASSWORD);
        registrationPage.clickCheckBoxAgreementButton();
        registrationPage.clickNextSubmitButton();
        registrationPage.clickSubmitSelectAllButton();
        registrationPage.clickAgreementSubmitButton();
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(TITLE_CREATE_ACCOUNT_TEXT, registrationPage.getTitleCreateAccountText());
    }
}
