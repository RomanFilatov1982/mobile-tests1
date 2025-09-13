package tests;

import org.junit.jupiter.api.Test;
import pages.Page;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    Page page = new Page();

    @Test
    void successfulSearchTest() {
        page.openWikipedia();
        page.searchTest("Appium");
        page.verifyTest();
    }
}
