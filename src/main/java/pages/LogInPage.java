/*
 * Описание страницы авторизации
 * https://stellarburgers.nomoreparties.site/login
 * */

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSideElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;
import static helper.HelpMethods.dummyWait;

public class LogInPage extends UpperSideElements {
    private final SelenideElement emailField = $x("//label[text()='Email']/following-sibling::input");
    private final SelenideElement passwordField = $x("//label[text()='Пароль']/following-sibling::input");
    private final SelenideElement enterButton = $x("//button[text()='Войти']");

    @Step("Заполнение поля 'Email' значением {0}")
    public LogInPage fillInEmailField(String email) {
        dummyWait(1);
        emailField.setValue(email);
        return this;
    }

    @Step("Заполнение поля 'Пароль' значением {0}")
    public LogInPage fillInPasswordField(String password) {
        passwordField.should(visible);
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickOnEnterButton() {
        clickOn(enterButton);
    }
}
