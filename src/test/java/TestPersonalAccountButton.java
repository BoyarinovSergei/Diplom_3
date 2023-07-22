/*
 * Раздел: Переход в личный кабинет
 * Включает проверки:
 * 1. Проверь переход по клику на «Личный кабинет».
 * */

import commonClasses.CommonMethods;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.PersonalAccountPage;
import pojo.request.ReqRegister;
import pojo.response.RespRegister;

import static addresses.APIs.USER;
import static addresses.APIs.USER_CREATION;
import static addresses.URLs.MAIN_HOST;
import static helper.HelpMethods.*;
import static helper.StringGenerator.generateString;
import static org.apache.http.HttpStatus.SC_OK;
import static samples.RestSamples.makeDeleteRequest;
import static samples.RestSamples.makePostRequestWithNoAuthorization;

public class TestPersonalAccountButton extends CommonMethods {
    private static String token;
    private static String email;
    private static String name;
    private static final PersonalAccountPage PERSONAL_ACCOUNT_PAGE = new PersonalAccountPage();

    @Before
    @Description("Генерация тестовых данных")
    public void adjusting() {
        RestAssured.baseURI = MAIN_HOST;

        email = generateString(9) + "@yandex.ru";
        name = generateString(6);

        token = makePostRequestWithNoAuthorization(USER_CREATION, new ReqRegister(email, generateString(15), name))
                .then()
                .statusCode(SC_OK)
                .and()
                .extract()
                .as(RespRegister.class).accessToken;
    }

    @Test
    @Description("Переход по клику на «Личный кабинет». и проверка на отображение введеных при регистрации значений в поля email и name")
    public void checkPersonalAccountEntering() {
        open(MAIN_HOST);
        setToken(token);

        new MainPage().clickOnAccountButton();

        Assert.assertEquals(email, PERSONAL_ACCOUNT_PAGE.getTextFromLoginField());
        Assert.assertEquals(name, PERSONAL_ACCOUNT_PAGE.getTextFromNameField());
    }

    @After
    @Description("Удаление созданной учетки и закрытие баузера")
    public void endWork() {
        makeDeleteRequest(USER, getToken());
        shutDown();
    }
}
