/*
* Описаны элементы верхней части сайта
* */

package pages.commonElements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public abstract class UpperSideElements {
    private final SelenideElement accountButton = $x("//p[text()='Личный Кабинет']");
    private final SelenideElement orderQueueButton = $x("//p[text()='Лента Заказов']");
    private final SelenideElement constructorButton = $x("//p[text()='Конструктор']");
    private final SelenideElement stellarBurgersButton = $x("//div[@class='AppHeader_header__logo__2D0X2']");

    @Step("Нажатие на кнопку 'Личный Кабинет'")
    public void clickOnAccountButton() {
        accountButton.click();
    }

    @Step("Нажатие на лейбл stellar burger")
    public MainPage clickOnStellarBurgersButton() {
        stellarBurgersButton.click();
        return new MainPage();
    }

    @Step("Нажатие на кнопку 'Лента Заказов'")
    public void clickOnOrderQueueButton() {
        orderQueueButton.click();
    }

    @Step("Нажатие на кнопку 'Конструктор'")
    public MainPage clickOnConstructorButton() {
        constructorButton.click();
        return new MainPage();
    }
}
