import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginWithCorrectCredentials {
    static SaucedemoPage page = new SaucedemoPage();
    String userPass = "secret_sauce";
    String inventoryPage = "/inventory.html";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        page.open();
    }

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "problem_user", "performance_glitch_user"})
    void login(String user) {
        page.login(user, userPass);
        page.checkTheCurrentPage(inventoryPage);
        page.clickBurgerMenu();
        //  page.clickLogout();
    }
}
