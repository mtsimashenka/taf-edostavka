package ui;

import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import by.itacademy.timoshenko.edostavka.ui.pages.registration.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
    public final String TITLE_REGISTRATION_TEXT = "Регистрация";
    public final String TITLE_CREATE_ACCOUNT_TEXT = "Введите код";
    public final String BUTTON_SUBMIT_TEXT = "Далее";
    public final String COMMIT_PASSWORD_TEXT = "Пароль должен содержать от 8 до 50 символов, включая хотя бы одну цифру, одну строчную и одну прописную латинские буквы";
    public final String LABEL_PHONE_NUMBER_TEXT = "Номер телефона *";
    public final String LINK_I_AGREE_TEXT = "политикой обработки персональных данных ЗАО «Интернет-магазин Евроопт»";
    public final String CHECKBOX_EMAIL_TEXT = "emall.by";
    public final String CHECKBOX_EVROPOCHTA_TEXT = "evropochta.by";
    public final String CHECKBOX_EVEZUNCHIKI_TEXT = "Е-везунчики";
    public final String CHECKBOX_EDOSTAVKA_TEXT = "edostavka.by";
    public final String LABEL_NAME_TEXT = "Имя *";
    public final String LABEL_SURNAME_TEXT = "Фамилия *";
    public final String LABEL_PATRONYMIC_TEXT = "Отчество";
    public final String LABEL_EMAIL_TEXT = "Email";
    public final String LABEL_PASSWORD_TEXT = "Пароль";
    public final String LABEL_PASSWORD_AGAIN = "Повторите пароль";
    public final String ERROR_MESSAGE_NAME_TEXT = "Поле имя обязательно для заполнения";
    public final String ERROR_MESSAGE_SURNAME_TEXT = "Поле фамилия обязательно для заполнения";
    public final String ERROR_MESSAGE_INCORRECT_PATRONYMIC_TEXT = "Поле отчество введено в некорректном формате";
    public final String ERROR_MESSAGE_PHONE_TEXT = "Номер введен некорректно";
    public final String ERROR_MESSAGE_PASSWORD_TEXT = "Создание пароля обязательно";
    public final String ERROR_MESSAGE_AGREEMENT_TEXT = "Необходимо согласие";
    public final String ERROR_MESSAGE_INCORRECT_NAME_TEXT = "Поле имя введено в некорректном формате";
    public final String ERROR_MESSAGE_INCORRECT_SURNAME_TEXT = "Поле фамилия введено в некорректном формате";
    public final String ERROR_MESSAGE_INCORRECT_EMAIL_TEXT = "Адрес почты введен некорректно";
    public final String ERROR_MESSAGE_INCORRECT_PASSWORD_TEXT = "Пароли не совпадают";
    public final String ERROR_MESSAGE_IDENTICAL_PASSWORD_TEXT = "Пароли не соответствуют правилам";
    public final String CHECKBOX_EMAIL = "emall.by";
    public final String CHECKBOX_EVROPOCHTA = "evropochta.by";
    public final String CHECKBOX_EVEZUNCHIKI = "Е-везунчики";
    public final String CHECKBOX_EDOSTAVKA = "edostavka.by";
    public final String NAME_FIELD = "name";
    public final String SURNAME_FIELD = "surname";
    public final String PATRONYMIC_FIELD = "patronymic";
    public final String PHONE_FIELD = "phone";
    public final String EMAIL_FIELD = "email";
    public final String PASSWORD_FIELD = "password";
    public final String PASSWORD_AGAIN_FIELD = "passwordAgain";
    public final String INCORRECT_CREDENTIAL = "1234";
    public final String INCORRECT_PHONE_NUMBER = "000000000";
    public final String INCORRECT_EMAIL = "test@test.xyz";
    public final String INCORRECT_PASSWORD = "qwer1";
    public final String CORRECT_PASSWORD = "Qwerty1234";
    public final String CORRECT_PHONE = "296550011";
    public final String CORRECT_EMAIL = "test@test.com";
    public final String CORRECT_NAME = "Ivan";
    public final String CORRECT_SURNAME = "Ivanov";
    public final String CORRECT_PATRONYMIC = "Ivanovich";


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
