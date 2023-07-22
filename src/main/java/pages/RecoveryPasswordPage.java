package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSideElements;

import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;

public class RecoveryPasswordPage extends UpperSideElements {
    private final SelenideElement logInLink = $x("//a[text()='Войти']");

    @Step("Нажатие на ссылку 'Войти'")
    public LogInPage clickOnLogInLink(){
        clickOn(logInLink);
        return new LogInPage();
    }
}
