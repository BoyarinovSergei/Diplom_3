package helper;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

public abstract class BrowserSelector {
    private static String browser;

    @Step("Выбор браузера {0}")
    public static void selectedBrowserIs(String browserName) {
        browser = browserName;

        if (browserName.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        } else if (browserName.equalsIgnoreCase("yandex")) {
            //Used yandexdriver-23.7.0.2469-win64 and placed locally
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        }
    }

    @Step("Узнать тип браузера")
    public static String getBrowserName() {
        return browser;
    }
}
