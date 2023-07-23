/*
 * Раздел: Выход из аккаунта
 * Включает проверки:
 * 1. Проверь выход по кнопке «Выйти» в личном кабинете.
 * */

import commonclasses.CommonMethods;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LogInPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import pojo.request.ReqRegister;
import pojo.response.RespRegister;

import static addresses.APIs.USER;
import static addresses.APIs.USER_CREATION;
import static addresses.URLs.MAIN_HOST;
import static helper.HelpMethods.open;
import static helper.HelpMethods.shutDown;
import static helper.StringGenerator.generateString;
import static org.apache.http.HttpStatus.SC_OK;
import static samples.RestSamples.makeDeleteRequest;
import static samples.RestSamples.makePostRequestWithNoAuthorization;

public class TestLogOut extends CommonMethods {
    private static String token;
    private static String email;
    private static String password;
    private static final MainPage MAIN_PAGE = new MainPage();

    @Before
    @Description("Генерация тестовых данных")
    public void adjusting() {
        email = generateString(9) + "@yandex.ru";
        password = generateString(15);

        token = makePostRequestWithNoAuthorization(USER_CREATION, new ReqRegister(email, password, generateString(6)))
                .then()
                .statusCode(SC_OK)
                .and()
                .extract()
                .as(RespRegister.class).getAccessToken();
    }

    @Test
    @Description("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    public void checkLogOut() {
        open(MAIN_HOST);

        MAIN_PAGE.clickOnEnterButton()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton();

        MAIN_PAGE.clickOnAccountButton();

        new PersonalAccountPage().clickOnLogOutButton();

        Assert.assertTrue(new LogInPage().isEnterButtonEnabled());
    }


    @After
    @Description("Закрытие браузера и удаление созданной учетки")
    public void quitBrowser() {
        makeDeleteRequest(USER, token);
        shutDown();
    }
}
