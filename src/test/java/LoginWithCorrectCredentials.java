import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginWithCorrectCredentials {
    static SaucedemoPage page = new SaucedemoPage();

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com/inventory.html";
        page.open();
    }

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "problem_user", "performance_glitch_user"})
    void login(String user) {
        page.login(user, "secret_sauce");
        page.checkTheCurrentPage();
        page.clickBurgerMenu();
        page.clickLogout();
    }
}
