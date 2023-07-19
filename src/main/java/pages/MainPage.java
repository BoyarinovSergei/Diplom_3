package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSide;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends UpperSide {
    private final SelenideElement logInButton = $x("//button[text()='Войти в аккаунт']");
    private final SelenideElement nameOfThePage = $x("//h1[text()='Соберите бургер']");

    @Step("Нажатие на кнопку 'Войти'")
    public LogInPage clickOnEnterButton() {
        logInButton.click();
        return new LogInPage();
    }

    @Step("Отображается ли текст 'Соберите бургер' на главной странице")
    public Boolean isNameOfThePageDisplayed() {
        return nameOfThePage.isDisplayed();
    }
}
