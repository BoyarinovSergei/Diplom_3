package helper;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BrowserSelector {

    @Step("Выбор браузера {0}")
    public static void selectThisBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        } else if (browserName.equalsIgnoreCase("yandex")) {
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.setBinary("src/test/resources/yandexdriver.exe");
            WebDriver webDriver= new ChromeDriver(options);
        }
    }
}
