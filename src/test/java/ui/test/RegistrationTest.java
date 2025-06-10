package ui.test;

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
        Assertions.assertEquals(CHECKBOX_EMAIL_TEXT, registrationPage.getCheckBoxText("emall.by"));
        Assertions.assertEquals(CHECKBOX_EVROPOCHTA_TEXT, registrationPage.getCheckBoxText("evropochta.by"));
        Assertions.assertEquals(CHECKBOX_EVEZUNCHIKI_TEXT, registrationPage.getCheckBoxText("Е-везунчики"));
        Assertions.assertEquals(CHECKBOX_EDOSTAVKA_TEXT, registrationPage.getCheckBoxText("edostavka.by"));
        Assertions.assertEquals(LABEL_NAME_TEXT, registrationPage.getLabelCredentialText("Имя *"));
        Assertions.assertEquals(LABEL_SURNAME_TEXT, registrationPage.getLabelCredentialText("Фамилия *"));
        Assertions.assertEquals(LABEL_PATRONYMIC_TEXT, registrationPage.getLabelCredentialText("Отчество"));
        Assertions.assertEquals(LABEL_EMAIL_TEXT, registrationPage.getLabelCredentialText("Email"));
        Assertions.assertEquals(LABEL_PASSWORD_TEXT, registrationPage.getLabelCredentialText("Пароль"));
        Assertions.assertEquals(LABEL_PASSWORD_AGAIN, registrationPage.getLabelCredentialText("Повторите пароль"));
    }

    @Test
    public void checkEmptyInput() {
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_NAME_TEXT, registrationPage.getErrorMessageText("Имя *"));
        Assertions.assertEquals(ERROR_MESSAGE_SURNAME_TEXT, registrationPage.getErrorMessageText("Фамилия *"));
        Assertions.assertEquals(ERROR_MESSAGE_PHONE_TEXT, registrationPage.getErrorMessagePhoneText());
        Assertions.assertEquals(ERROR_MESSAGE_PASSWORD_TEXT, registrationPage.getErrorMessagePasswordText());
        Assertions.assertEquals(ERROR_MESSAGE_AGREEMENT_TEXT, registrationPage.getErrorMessageAgreementText());
    }

    @Test
    public void checkIncorrectInput() {
        registrationPage.fillInputCredential("name", "1234");
        registrationPage.fillInputCredential("surname", "1234");
        registrationPage.fillInputCredential("patronymic", "1234");
        registrationPage.fillInputCredential("phone", "000000000");
        registrationPage.fillInputCredential("email", "test@test.xyz");
        registrationPage.fillInputCredential("password", "qwert");
        registrationPage.fillInputCredential("passwordAgain", "1234");
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_NAME_TEXT, registrationPage.getErrorMessageText("Имя *"));
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_SURNAME_TEXT, registrationPage.getErrorMessageText("Фамилия *"));
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_PATRONYMIC_TEXT, registrationPage.getErrorMessageText("Отчество"));
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_EMAIL_TEXT, registrationPage.getErrorMessageText("Email"));
        Assertions.assertEquals(ERROR_MESSAGE_PHONE_TEXT, registrationPage.getErrorMessagePhoneText());
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_PASSWORD_TEXT, registrationPage.getErrorMessagePasswordText());
        Assertions.assertEquals(ERROR_MESSAGE_AGREEMENT_TEXT, registrationPage.getErrorMessageAgreementText());
    }

    @Test
    public void checkIncorrectPassword() {
        registrationPage.fillInputCredential("password", "qwerty");
        registrationPage.fillInputCredential("passwordAgain", "qwerty");
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_IDENTICAL_PASSWORD_TEXT, registrationPage.getErrorMessagePasswordText());
    }

    @Test
    public void checkCorrectInput() {
        registrationPage.clickCheckBox("emall.by");
        registrationPage.clickCheckBox("evropochta.by");
        registrationPage.clickCheckBox("Е-везунчики");
        registrationPage.fillInputCredential("name", "Ivan");
        registrationPage.fillInputCredential("surname", "Ivanov");
        registrationPage.fillInputCredential("patronymic", "Ivanovich");
        registrationPage.fillInputCredential("phone", "296550011");
        registrationPage.fillInputCredential("email", "test@test.com");
        registrationPage.fillInputCredential("password", "Qwerty123");
        registrationPage.fillInputCredential("passwordAgain", "Qwerty123");
        registrationPage.clickCheckBoxAgreementButton();
        registrationPage.clickNextSubmitButton();
        registrationPage.clickSubmitSelectAllButton();
        registrationPage.clickAgreementSubmitButton();
        registrationPage.clickSubmitButton();
        Assertions.assertEquals(TITLE_CREATE_ACCOUNT_TEXT, registrationPage.getTitleCreateAccountText());
    }
}
