/*
 * Раздел: Переход из личного кабинета в конструктор
 * Включает проверки:
 * 1. Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
 * */

import commonClasses.CommonMethods;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;

import static addresses.URLs.REGISTER_PAGE;
import static helper.BrowserSelector.selectedBrowserIs;
import static helper.HelpMethods.open;
import static helper.HelpMethods.shutDown;

public class TestTransitionToConstructor extends CommonMethods {
    private static final MainPage MAIN_PAGE = new MainPage();
    public static final RegisterPage REGISTER_PAGE1 = new RegisterPage();

    @Before
    @Description("Выбор браузера и открытие страницы регистрации")
    public void setUp() {
        selectedBrowserIs("chrome");
        open(REGISTER_PAGE);
    }

    @Test
    @Description("Проверка перехода по клику на «Конструктор»")
    public void checkTransitionToConstructor(){
        REGISTER_PAGE1.clickOnConstructorButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @Test
    @Description("Проверка перехода по клику на логотип Stellar Burgers")
    public void checkTransitionByMainLabel(){
        REGISTER_PAGE1.clickOnStellarBurgersButton();

        Assert.assertTrue(MAIN_PAGE.isBuildBurgerTextDisplayed());
    }

    @After
    @Description("Закрытие баузера")
    public void endWork() {
        shutDown();
    }
}
