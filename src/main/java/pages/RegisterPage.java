package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonelements.UpperSideElements;

import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;

public class RegisterPage extends UpperSideElements {
    private final SelenideElement logInLink = $x("//a[text()='Войти']");
    private final SelenideElement emailField = $x("//label[text()='Email']/following-sibling::input");
    private final SelenideElement nameField = $x("//label[text()='Имя']/following-sibling::input");
    private final SelenideElement passwordField = $x("//label[text()='Пароль']/following-sibling::input");
    private final SelenideElement registerButton = $x("//button[text()='Зарегистрироваться']");
    private final SelenideElement errorText = $x("//p[@class='input__error text_type_main-default']");

    @Step("Ввод значения {0} в поле 'Email'")
    public RegisterPage fillInEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Ввод значения {0} в поле 'Имя'")
    public RegisterPage fillInNameField(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Ввод значения {0} в поле 'Пароль'")
    public RegisterPage fillInPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("нажатие на кнопку 'Зарегистрироваться'")
    public void clickOnRegisterButton() {
        clickOn(registerButton);
    }

    @Step("Отображается ли текст 'Некорректный пароль' на странице регистрации")
    public Boolean isErrorTextDisplayed() {
        return errorText.isDisplayed();
    }

    @Step("Нажатие на ссылку 'Войти'")
    public LogInPage clickOnLogInLink() {
        clickOn(logInLink);
        return new LogInPage();
    }
}
