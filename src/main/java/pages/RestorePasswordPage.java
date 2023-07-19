package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSide;

import static com.codeborne.selenide.Selenide.$x;

public class RestorePasswordPage extends UpperSide {

    private final SelenideElement emailField = $x("//label[text()='Email']");
    private final SelenideElement restoreButton = $x("//button[text()='Восстановить']");

    @Step("Ввод значения {0} в поле 'Email'")
    public RestorePasswordPage fillInEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("нажатие на кнопку 'Восстановить'")
    public void clickOnRegisterButton() {
        restoreButton.click();
    }
}
