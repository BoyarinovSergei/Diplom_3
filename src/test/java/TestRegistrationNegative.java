/*
 * Раздел: Регистрация
 * Включает проверки:
 * 2. Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
 * */

import commonclasses.CommonMethods;
import io.qameta.allure.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.RegisterPage;

import static addresses.APIs.USER;
import static addresses.URLs.REGISTER_PAGE;
import static helper.HelpMethods.getToken;
import static helper.HelpMethods.open;
import static helper.StringGenerator.generateString;
import static samples.RestSamples.makeDeleteRequest;

public class TestRegistrationNegative extends CommonMethods {
    private static final String email = generateString(9) + "@yandex.ru";
    private static final String name = generateString(6);
    private static final String password = generateString(5);
    private static final RegisterPage registerPage = new RegisterPage();

    @Before
    @Description("Открытие страницы регистрации")
    public void setUp() {
        open(REGISTER_PAGE);
    }

    @Test
    @Description("Проверка на невозможность произвести регистрацию введя 5 символов в поле 'пароль'")
    public void checkImpossibilityOfRegistration() {
        registerPage
                .fillInEmailField(email)
                .fillInNameField(name)
                .fillInPasswordField(password)
                .clickOnRegisterButton();

        Assert.assertTrue(registerPage.isErrorTextDisplayed());
    }

    @AfterClass
    @Description("Удаление созданной учетки")
    public static void deleteUser() {
        if (!registerPage.isErrorTextDisplayed()) {
            loggingInDependingOnBrowser(email, password);

            makeDeleteRequest(USER, getToken());
        }
    }
}