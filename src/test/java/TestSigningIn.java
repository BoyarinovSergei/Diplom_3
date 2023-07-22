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
import pages.LogInPage;
import pages.MainPage;
import pojo.request.ReqRegister;
import pojo.response.RespRegister;

import static addresses.APIs.USER;
import static addresses.APIs.USER_CREATION;
import static addresses.URLs.MAIN_HOST;
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
    private static String name;
    private static String password;
    private static final LogInPage LOG_IN_PAGE = new LogInPage();
    private static final MainPage MAIN_PAGE = new MainPage();

    @BeforeClass
    @Description("Генерация тестовых данных и выбор браузера")
    public static void adjusting() {
        RestAssured.baseURI = MAIN_HOST;
        selectedBrowserIs("chrome");

        email = generateString(9) + "@yandex.ru";
        name = generateString(6);
        password = generateString(15);

        token = makePostRequestWithNoAuthorization(USER_CREATION, new ReqRegister(email, password, name))
                .then()
                .statusCode(SC_OK)
                .and()
                .extract()
                .as(RespRegister.class).accessToken;
    }

    @Before
    @Description("Открытие главной страницы сайта")
    public void openMainPage() {
        open(MAIN_HOST);
    }

    @Test
    @Description("вход по кнопке «Войти в аккаунт» на главной с проверкой отображения текста 'Соберите бургер'")
    public void checkSigningInByEnterButtonOnMainPage() {
        MAIN_PAGE.clickOnEnterButton()
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickOnEnterButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @Test
    @Description("вход через кнопку «Личный кабинет» с проверкой отображения текста 'Соберите бургер'")
    public void checkSigningInByPersonalAccountButtonOnMainPage() {
        MAIN_PAGE.clickOnAccountButton()
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
