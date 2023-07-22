package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.commonElements.UpperSideElements;

import static com.codeborne.selenide.Selenide.$x;
import static helper.HelpMethods.clickOn;
import static org.openqa.selenium.support.ui.ExpectedConditions.or;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends UpperSideElements {
    private final SelenideElement logInButton = $x("//button[text()='Войти в аккаунт']");
    private final SelenideElement makeOrderButton = $x("//button[text()='Оформить заказ']");
    private final SelenideElement buildBurgerText = $x("//h1[@class='text text_type_main-large mb-5 mt-10']");

    @Step("Нажатие на кнопку 'Войти'")
    public LogInPage clickOnEnterButton() {
        clickOn(logInButton);
        return new LogInPage();
    }

    @Step("Ожидание появления кнопки 'Оформить заказ' или 'Войти в аккаунт'")
    public void waitForMakeOrderOrLogInButton() {
        Selenide.Wait().until(or(visibilityOf(makeOrderButton), visibilityOf(logInButton)));
    }

    @Step("Отображается ли текст 'Соберите бургер'")
    public Boolean isBuildBurgerTextDisplayed() {
        waitForMakeOrderOrLogInButton();
        return buildBurgerText.isDisplayed();
    }

    @Step("Выбор раздела {0}")
    public MainPage clickOnCertainSection(String sectionName) {
        clickOn($x("//span[text()='" + sectionName + "']"));
        return this;
    }

    @Step("Выбран ли раздел {0}")
    public Boolean isSectionSelected(String sectionName) {
        return $x("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect' ]/span[text()='" + sectionName + "']").isEnabled();
    }
}
