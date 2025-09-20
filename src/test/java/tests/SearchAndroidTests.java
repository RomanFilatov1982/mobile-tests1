package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AndroidPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchAndroidTests extends TestBase {
    AndroidPage androidPage = new AndroidPage();
    @Tag("android")
    @Test
    @DisplayName("")
    void successfulSearchTest() {
        androidPage.openWikipedia()
        .searchTest("Appium")
        .verifyTest();
    }
}
