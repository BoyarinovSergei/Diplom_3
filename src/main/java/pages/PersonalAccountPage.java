package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSideElements;

import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;

public class PersonalAccountPage extends UpperSideElements {

    private final SelenideElement nameField = $x("//label[text()='Имя']/following-sibling::input");
    private final SelenideElement loginField = $x("//label[text()='Логин']/following-sibling::input");
    private final SelenideElement logOutButton = $x("//button[text()='Выход']");

    @Step("Получение текста из поля 'Имя'")
    public String getTextFromNameField() {
        return nameField.getValue();
    }

    @Step("Получение текста из поля 'Логин'")
    public String getTextFromLoginField() {
        return loginField.getValue();
    }

    @Step("Нажатие на кнопку 'Выход'")
    public void clickOnLogOutButton() {
        clickOn(logOutButton);
    }
}
