/*
 * Раздел: Регистрация
 * Включает проверки:
 * 1. Успешную регистрацию.
 * */

import commonclasses.CommonMethods;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;

import static addresses.APIs.USER;
import static addresses.URLs.REGISTER_PAGE;
import static helper.HelpMethods.*;
import static helper.StringGenerator.generateString;
import static samples.RestSamples.makeDeleteRequest;

public class TestRegistrationPositive extends CommonMethods {
    private static final String email = generateString(9) + "@yandex.ru";
    private static final String name = generateString(6);
    private static final String password = generateString(15);

    @Before
    @Description("Открытие страницы регистрации")
    public void setUp() {
        open(REGISTER_PAGE);
    }

    @Test
    @Description("Регистрация, вход и проверка, что кнопка 'Оформить заказ' отображается")
    public void checkRegistration() {
        new RegisterPage()
                .fillInEmailField(email)
                .fillInNameField(name)
                .fillInPasswordField(password)
                .clickOnRegisterButton();

        loggingInDependingOnBrowser(email, password);

        new MainPage().waitForMakeOrderOrLogInButton();
    }

    @After
    @Description("Удаление созданной учетки и закрытие баузера")
    public void endWork() {
        makeDeleteRequest(USER, getToken());
        shutDown();
    }
}
