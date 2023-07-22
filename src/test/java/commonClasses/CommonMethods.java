package commonClasses;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static addresses.URLs.MAIN_HOST;
import static helper.BrowserSelector.selectedBrowserIs;

public class CommonMethods {
    @BeforeClass
    @Description("Задан базовый URL и выбор браузера")
    public static void setBaseURL() {
        RestAssured.baseURI = MAIN_HOST;

        // Данная настройка используется во всех классах кроме TestSigningIn
        selectedBrowserIs("yandex");
    }
}
