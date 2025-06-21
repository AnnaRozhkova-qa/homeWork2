import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void junitExampleFind() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text ("Soft assertions"));
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();


        var content = $(".gollum-markdown-content");

        // Проверяем ключевые части кода по отдельности
        content.shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
        content.shouldHave(text("class Tests {"));
        content.shouldHave(text("Configuration.assertionMode = SOFT;"));
        content.shouldHave(text("$(\"#first\").should(visible).click();"));
        content.shouldHave(text("$(\"#second\").should(visible).click();"));
        content.shouldHave(text("{"));
        content.shouldHave(text("{"));

    }
}