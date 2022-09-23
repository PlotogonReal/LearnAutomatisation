import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginWithLockedUserTest {
    static SaucedemoPage page = new SaucedemoPage();

    @BeforeAll
    public static void setup() {
 //       Configuration.holdBrowserOpen = true;
        page.open();
    }
    @Test
    void login() {
        page.login("locked_out_user", "secret_sauce");
        webdriver().shouldHave(url("https://www.saucedemo.com/"));
        $("form div:nth-child(1) svg").should(exist);
        $("form div:nth-child(2) svg").should(exist);
        $x("//div[@class='error-message-container error']")
                .shouldHave(exactTextCaseSensitive("Epic sadface: Sorry, this user has been locked out."));
    }
}
