import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginWithLockedUserTest {
    static SaucedemoPage page = new SaucedemoPage();
    String userLogin = "locked_out_user";
    String userPass = "secret_sauce";
    String rootPage = "/";

    @BeforeAll
     static void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        page.open();
    }

    @Test
    void login() {
        page.login(userLogin, userPass);
        page.checkTheCurrentPage(rootPage);
        page.checkWarningUserLogin();
        page.checkWarningUserPass();
        page.checkWarningMassage();
    }
}
