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
    private final SelenideElement buildBurgerText = $x("//h1[@class=\"text text_type_main-large mb-5 mt-10\"]");

    @Step("Нажатие на кнопку 'Войти'")
    public LogInPage clickOnEnterButton() {
        clickOn(logInButton);
        return new LogInPage();
    }

    @Step("Ожидание появления кнопки 'Оформить заказ'")
    public void waitForMakeOrderButton() {
        makeOrderButton.shouldBe(visible);
    }

    @Step("Отображается ли текст 'Соберите бургер'")
    public Boolean isBuildBurgerTextDisplayed() {
        waitForMakeOrderButton();
        return buildBurgerText.isDisplayed();
    }
}
