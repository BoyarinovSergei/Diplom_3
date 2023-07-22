/*
 * Класс для краткого вызова методов
 * */

package helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public abstract class HelpMethods {

    @Step("Открыть страницу по адресу {0}")
    public static void open(String url) {
        Selenide.open(url);
    }

    @Step("Нажатие на элемент {0}")
    public static void clickOn(SelenideElement element) {
        element.shouldBe(Condition.visible);
        element.click();
    }

    @Step("Закрытие браузера с очисткой кукки и локал сторедж")
    public static void shutDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @Step("Получение токена")
    public static String getToken() {
        dummyWait(1);
        return Selenide.localStorage().getItem("accessToken");
    }

    @Step("Помещение токена в локал сторедж")
    public static void setToken(String token) {
        Selenide.localStorage().setItem("accessToken", token);
    }

    @Step("Последняя надежда на ожидание в {0} секунд")
    public static void dummyWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}