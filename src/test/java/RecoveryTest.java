import by.itacademy.timoshenko.edostavka.ui.pages.login.LoginPage;
import by.itacademy.timoshenko.edostavka.ui.pages.password.PasswordPage;
import by.itacademy.timoshenko.edostavka.ui.pages.recovery.RecoveryPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecoveryTest extends BaseTest {
    public final String LABEL_PHONE_NUMBER_TEXT = "Номер телефона";
    public final String LABEL_SURNAME_TEXT = "Фамилия";
    public final String LABEL_BUTTON_SUBMIT_TEXT = "Далее";
    public final String ERROR_MESSAGE_CREDENTIAL_WITHOUT_PHONE_TEXT = "Поле номер телефона обязательно для заполнения";
    public final String ERROR_MESSAGE_CREDENTIAL_WITHOUT_SURNAME_TEXT = "Поле фамилия обязательно для заполнения";
    public final String ERROR_MESSAGE_FULL_CREDENTIAL_TEXT = "Пожалуйста, убедитесь, что правильно ввели фамилию и телефон";
    public final String ERROR_MESSAGE_INCORRECT_CREDENTIAL_TEXT = "Фамилия введена неверно";

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
        Assertions.assertEquals(LABEL_PHONE_NUMBER_TEXT, recoveryPage.getCredentialText("new-input-phone_label__ykMt6"));
        Assertions.assertEquals(LABEL_SURNAME_TEXT, recoveryPage.getCredentialText("input_label__7sem_"));
    }

    @Test
    public void checkInputWithoutPhoneNumber() {
        recoveryPage.fillInputCredential("family-name", "Ivanov");
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_WITHOUT_PHONE_TEXT, recoveryPage.getErrorMessageText());
    }

    @Test
    public void checkInputWithoutSurname() {
        recoveryPage.fillInputCredential("tel", "296550011");
        recoveryPage.clickInputCredential("family-name");
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_CREDENTIAL_WITHOUT_SURNAME_TEXT, recoveryPage.getErrorMessageText());
    }

    @Test
    public void checkInputFullCredential() {
        recoveryPage.fillInputCredential("tel", "296550011");
        recoveryPage.fillInputCredential("family-name", "Ivanov");
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_FULL_CREDENTIAL_TEXT, recoveryPage.getErrorMessageText());
    }

    @Test
    public void checkIncorrectCredential() {
        recoveryPage.fillInputCredential("tel", "22222");
        recoveryPage.fillInputCredential("family-name", "*@#%^^&&");
        recoveryPage.clickSubmitButton();
        Assertions.assertEquals(ERROR_MESSAGE_INCORRECT_CREDENTIAL_TEXT, recoveryPage.getErrorMessageText());
    }
}
