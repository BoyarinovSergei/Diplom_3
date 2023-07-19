/*
 * Описание страницы авторизации
 * https://stellarburgers.nomoreparties.site/login
 * */

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSide;

import static com.codeborne.selenide.Selenide.$x;

public class LogInPage extends UpperSide {
    private final SelenideElement emailField = $x("//label[text()='Email']");
    private final SelenideElement passwordField = $x("//label[text()='Пароль']");
    private final SelenideElement enterButton = $x("//label[text()='Войти']");

    @Step("Заполнение поля 'Email' значением {0}")
    public LogInPage fillInEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Заполнение поля 'Пароль' значением {0}")
    public LogInPage fillInPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickOnEnterButton() {
        enterButton.click();
    }
}
