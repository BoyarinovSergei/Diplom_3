package commonClasses;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static addresses.URLs.MAIN_PAGE;

public class CommonMethods {
    @BeforeClass
    @Description("Задан базовый URL")
    public static void setBaseURL() {
        RestAssured.baseURI = MAIN_PAGE;
    }
}
