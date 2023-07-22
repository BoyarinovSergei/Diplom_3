import commonClasses.CommonMethods;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static addresses.URLs.MAIN_HOST;
import static helper.BrowserSelector.selectedBrowserIs;
import static helper.HelpMethods.open;

public class TestConstructorSection extends CommonMethods {

    @Before
    @Description("Выбор браузера и открытие главной страницы")
    public void setUp() {
        selectedBrowserIs("chrome");
        open(MAIN_HOST);
    }

    @Test
    @Description("Проверка на возможность перехода к разделам: Булки")
    public void checkBunsSections() {
        Boolean realResult = new MainPage()
                .clickOnCertainSection("Соусы")
                .clickOnCertainSection("Булки")
                .isSectionSelected("Булки");

        Assert.assertTrue(realResult);
    }

    @Test
    @Description("Проверка на возможность перехода к разделам: Соусы")
    public void checkSauceSections() {
        Boolean realResult = new MainPage()
                .clickOnCertainSection("Соусы")
                .isSectionSelected("Соусы");

        Assert.assertTrue(realResult);
    }

    @Test
    @Description("Проверка на возможность перехода к разделам: Начинки")
    public void checkToppingSections() {
        Boolean realResult = new MainPage()
                .clickOnCertainSection("Начинки")
                .isSectionSelected("Начинки");

        Assert.assertTrue(realResult);
    }
}
