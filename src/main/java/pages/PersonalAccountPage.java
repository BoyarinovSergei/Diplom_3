package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSideElements;

import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage extends UpperSideElements {

    private final SelenideElement nameField = $x("//label[text()='Имя']/following-sibling::input");
    private final SelenideElement loginField = $x("//label[text()='Логин']/following-sibling::input");

    @Step("Получение текста из поля 'Имя'")
    public String getTextFromNameField() {
        return nameField.getValue();
    }

    @Step("Получение текста из поля 'Логин'")
    public String getTextFromLoginField() {
        return loginField.getValue();
    }
}
