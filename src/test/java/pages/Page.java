package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class Page {
    private final SelenideElement searchString = $(accessibilityId("Search Wikipedia")),
            query = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection check = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


    @Step("Open search Wikipedia")
    public Page openWikipedia() {
        searchString.click();
        return this;
    }

    @Step("Enter a search query")
    public Page searchTest(String value) {
        query.sendKeys(value);
        return this;
    }

    @Step("Verify content found")
    public Page verifyTest() {
        check.shouldHave(sizeGreaterThan(0));
        return this;
    }
}

