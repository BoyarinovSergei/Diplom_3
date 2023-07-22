/*
 * Раздел: Вход
 * Включает проверки:
 * 1. вход по кнопке «Войти в аккаунт» на главной,
 * 2. вход через кнопку «Личный кабинет»,
 * 3. вход через кнопку в форме регистрации,
 * 4. вход через кнопку в форме восстановления пароля.
 * */

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.*;
import pages.MainPage;
import pages.RecoveryPasswordPage;
import pages.RegisterPage;
import pojo.request.ReqRegister;
import pojo.response.RespRegister;

import static addresses.APIs.USER;
import static addresses.APIs.USER_CREATION;
import static addresses.URLs.*;
import static helper.BrowserSelector.selectedBrowserIs;
import static helper.HelpMethods.open;
import static helper.HelpMethods.shutDown;
import static helper.StringGenerator.generateString;
import static org.apache.http.HttpStatus.SC_OK;
import static samples.RestSamples.makeDeleteRequest;
import static samples.RestSamples.makePostRequestWithNoAuthorization;


public class TestSigningIn {
    private static String token;
    private static String email;
    private static String password;
    private static final MainPage MAIN_PAGE = new MainPage();

    @BeforeClass
    @Description("Генерация тестовых данных и выбор браузера")
    public static void adjusting() {
        RestAssured.baseURI = MAIN_HOST;
        selectedBrowserIs("chrome");

        email = generateString(9) + "@yandex.ru";
        password = generateString(15);

        token = makePostRequestWithNoAuthorization(USER_CREATION, new ReqRegister(email, password, generateString(6)))
                .then()
                .statusCode(SC_OK)
                .and()
                .extract()
                .as(RespRegister.class).accessToken;
    }

    @Test
    @Description("вход по кнопке «Войти в аккаунт» на главной с проверкой отображения текста 'Соберите бургер'")
    public void checkSigningInByEnterButtonOnMainPage() {
        open(MAIN_HOST);

        MAIN_PAGE.clickOnEnterButton()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @Test
    @Description("вход через кнопку «Личный кабинет» с проверкой отображения текста 'Соберите бургер'")
    public void checkSigningInByPersonalAccountButtonOnMainPage() {
        open(MAIN_HOST);

        MAIN_PAGE.clickOnAccountButton()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @Test
    @Description("вход через кнопку в форме регистрации с проверкой отображения текста 'Соберите бургер'")
    public void checkSigningInByEnterLinkOnRegisterPage() {
        open(REGISTER_PAGE);

        new RegisterPage()
                .clickOnLogInLink()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @Test
    @Description("вход через кнопку в форме восстановления пароля с проверкой отображения текста 'Соберите бургер'")
    public void checkSigningInByEnterLinkOnRecoveryPage() {
        open(RESTORE_PASSWORD_PAGE);

        new RecoveryPasswordPage()
                .clickOnLogInLink()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @After
    @Description("Закрытие браузера")
    public void quitBrowser() {
        shutDown();
    }

    @AfterClass
    @Description("Удаление созданной учетки")
    public static void deleteUser() {
        makeDeleteRequest(USER, token);
    }
}
