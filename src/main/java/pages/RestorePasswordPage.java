package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonelements.UpperSideElements;

import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;

public class RestorePasswordPage extends UpperSideElements {

    private final SelenideElement emailField = $x("//label[text()='Email']/following-sibling::input");
    private final SelenideElement restoreButton = $x("//button[text()='Восстановить']");

    @Step("Ввод значения {0} в поле 'Email'")
    public RestorePasswordPage fillInEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("нажатие на кнопку 'Восстановить'")
    public void clickOnRegisterButton() {
        clickOn(restoreButton);
    }
}
