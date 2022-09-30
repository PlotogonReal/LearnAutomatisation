import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductsPageTest {
    static InventoryPage page = new InventoryPage();
    static SaucedemoPage loginPage = new SaucedemoPage();
    static String userLogin = "standard_user";
    static String userPass = "secret_sauce";
    static int amountOfCardsOnThePage = 6;

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        loginPage.open().login(userLogin, userPass);
    }

    @Test
    void test() {
        page.countCards(amountOfCardsOnThePage);
        page.checkCard1();
        page.checkCard2();
        page.checkCard3();
        page.checkCard4();
        page.checkCard5();
        page.checkCard6();
    }
}
