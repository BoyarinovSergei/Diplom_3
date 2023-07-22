package helper;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

public abstract class BrowserSelector {

    @Step("Выбор браузера {0}")
    public static void selectThisBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        } else if (browserName.equalsIgnoreCase("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        }
    }
}
