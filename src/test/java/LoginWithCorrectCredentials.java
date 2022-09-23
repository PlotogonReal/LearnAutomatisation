import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginWithCorrectCredentials {
    static SaucedemoPage page = new SaucedemoPage();

    @BeforeAll
    public static void setup() {
        //      Configuration.holdBrowserOpen = true;
        page.open();
    }

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "problem_user", "performance_glitch_user"})
    void login(String user) {
        page.login(user, "secret_sauce");
        webdriver().shouldHave(url("https://www.saucedemo.com/inventory.html"));
        $(By.id("react-burger-menu-btn")).click();
        $(By.id("logout_sidebar_link")).click();
    }
}
