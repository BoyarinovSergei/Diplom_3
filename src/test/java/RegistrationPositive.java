/*
 * Раздел: Регистрация
 * Включает проверки:
 * 1. Успешную регистрацию.
 * */

import commonClasses.CommonMethods;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.RegisterPage;

import static addresses.APIs.USER;
import static addresses.URLs.REGISTER_PAGE;
import static helper.BrowserSelector.selectThisBrowser;
import static helper.HelpMethods.*;
import static helper.StringGenerator.generateString;
import static samples.RestSamples.makeDeleteRequest;

public class RegistrationPositive extends CommonMethods {
    private static String token;
    private static final String email = generateString(9) + "@yandex.ru";
    private static final String name = generateString(6);
    private static final String password = generateString(15);

    @Before
    public void setUp() {
        selectThisBrowser("chrome");
        open(REGISTER_PAGE);
    }

    @Test
    @Description("Регистрация, вход и проверка, что кнопка 'Оформить заказ' отображается")
    public void checkRegistration() {
        new RegisterPage()
                .fillInEmailField(email)
                .fillInNameField(name)
                .fillInPasswordField(password)
                .clickOnRegisterButton()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton()
                .waitForMakeOrderButton();
    }

    @After
    @Description("Удаление созданной учетки и закрытие баузера")
    public void endWork() {
        token = getToken();
        shutDown();
        makeDeleteRequest(USER, token);
    }
}
