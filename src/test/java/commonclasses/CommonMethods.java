package commonclasses;

import config.UIProps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.BeforeClass;
import pages.LogInPage;

import static addresses.URLs.MAIN_HOST;
import static helper.BrowserSelector.getBrowserName;
import static helper.BrowserSelector.selectedBrowserIs;
import static helper.HelpMethods.dummyWait;

public class CommonMethods {
    @BeforeClass
    @Description("Задан базовый URL и выбор браузера")
    public static void setBaseURL() {
        RestAssured.baseURI = MAIN_HOST;

        // Данная настройка используется во всех классах кроме TestSigningIn
        selectedBrowserIs(ConfigFactory.create(UIProps.class).browserType());
    }

    @Step("Авторизация в зависимости от запущенного браузера")
    public static void loggingInDependingOnBrowser(String email, String password) {
        if (getBrowserName().equalsIgnoreCase("yandex")) {
            dummyWait(1);
            new LogInPage().clickOnEnterButton();
        } else {
            new LogInPage()
                    .fillInEmailField(email)
                    .fillInPasswordField(password)
                    .clickOnEnterButton();
        }
    }
}
