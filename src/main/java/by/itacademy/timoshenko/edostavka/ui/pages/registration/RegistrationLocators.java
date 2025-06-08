package by.itacademy.timoshenko.edostavka.ui.pages.registration;

public class RegistrationLocators {
    public static final String TITLE_REGISTRATION = "//h1[@class='consent-form_title__e72iS']";
    public static final String BUTTON_SUBMIT = "//button[@class='btn btn_size_medium btn_colour_black']";

    public static final String INPUT_NAME = "//input[@name='name']";
    public static final String INPUT_SURNAME = "//input[@name='surname']";
    public static final String INPUT_PATRONYMIC = "//input[@name='patronymic']";
    public static final String INPUT_PHONE_NUMBER = "//input[@name='phone']";
    public static final String INPUT_EMAIL = "//input[@name='email']";
    public static final String INPUT_PASSWORD = "//input[@name='password']";
    public static final String INPUT_PASSWORD_AGAIN = "//input[@name='passwordAgain']";
    public static final String INPUT_CREDENTIAL = "//input[@name='%s']";

    public static final String LABEL_NAME = "//label[text()='name']";
    public static final String LABEL_SURNAME = "//label[text()='surname']";
    public static final String LABEL_PATRONYMIC = "//label[text()='patronymic']";
    public static final String LABEL_EMAIL = "//label[text()='email']";
    public static final String LABEL_PASSWORD = "//label[text()='password']";
    public static final String LABEL_PASSWORD_AGAIN = "//label[text()='passwordAgain']";
    public static final String LABEL_CREDENTIALS = "//label[text()='%s']";


    public static final String CHECKBOX_LABEL = "//li[@aria-label='%s']";


    public static final String COMMIT_PASSWORD = "//p[@class='consent-form_password_note__cDqGj']";
    public static final String LABEL_PHONE_NUMBER = "//label[@class='new-input-phone_label__ykMt6']";
    public static final String LINK_I_AGREE = "//a[@href='https://edostavkaby.tilda.ws']";

    public static final String ERROR_MESSAGE_NAME = "//label[text()='Имя *']//following-sibling::div";
    public static final String ERROR_MESSAGE_SURNAME = "//label[text()='Фамилия *']//following-sibling::div";
    public static final String ERROR_MESSAGE_PATRONYMIC = "//label[text()='Отчество']//following-sibling::div";
    public static final String ERROR_MESSAGE_EMAIL = "//label[text()='Email']//following-sibling::div";
    public static final String ERROR_MESSAGE_CREDENTIAL = "//label[text()='%s']//following-sibling::div";

    public static final String ERROR_MESSAGE_PHONE = "//div[@class='new-input-phone_message__H_yAc']";
    public static final String ERROR_MESSAGE_PASSWORD = "//div[@class='consent-form_form_passwords___okHf']//div[@class='error_error_wrap__m39JZ']";
    public static final String ERROR_MESSAGE_AGREEMENT = "//div[@class='consent-form_form_footer__ePyCM']//div[@class='error_error_wrap__m39JZ']";


}
