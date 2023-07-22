package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSide;

import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;

public class RecoveryPasswordPage extends UpperSide {
    private final SelenideElement logInLink = $x("//a[text()='Войти']");

    @Step("Нажатие на ссылку 'Войти'")
    public LogInPage clickOnLogInLink(){
        clickOn(logInLink);
        return new LogInPage();
    }
}
