import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SortingTest {
    static InventoryPage page = new InventoryPage();
    static SaucedemoPage loginPage = new SaucedemoPage();
    static String userLogin = "standard_user";
    static String userPass = "secret_sauce1";

    @BeforeAll
    static void setup() {
       //        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.saucedemo.com";
        loginPage.open().login(userLogin, userPass);
    }

    //параметризованный тест? способы сортировки. второй параметр - ожидаемые заголовки
    //тесты должны проходиться независимо от падения друг друга
    @Test
    void test() {
        page.sortingAtoZ();
        page.checkSortingAtoZ();
        page.sortingZtoA();
        page.checkSortingZtoA();
        page.sortingByPriceMinToMax();
        page.checkSortingByPriceMinToMax();
        page.sortingByPriceMaxToMin();
        page.checkSortingByPriceMaxToMin();
    }
}
