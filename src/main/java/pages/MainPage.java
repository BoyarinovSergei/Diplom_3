package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;

public class MainPage extends UpperSide {
    private final SelenideElement logInButton = $x("//button[text()='Войти в аккаунт']");
    private final SelenideElement makeOrderButton = $x("//button[text()='Оформить заказ']");
    private final SelenideElement nameOfThePage = $x("//h1[text()='Соберите бургер']");

    @Step("Нажатие на кнопку 'Войти'")
    public LogInPage clickOnEnterButton() {
        clickOn(logInButton);
        return new LogInPage();
    }

    @Step("Отображается ли текст 'Соберите бургер' на главной странице")
    public Boolean isNameOfThePageDisplayed() {
        return nameOfThePage.isDisplayed();
    }

    @Step("Ожидание появления кнопки 'Оформить заказ'")
    public void waitForMakeOrderButton() {
        makeOrderButton.shouldBe(visible);
    }
}
