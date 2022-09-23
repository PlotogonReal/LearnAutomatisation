import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductsPageTest {
    InventoryPage page = new InventoryPage();
    @BeforeAll
    static void setup(){
 //       Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }
    @Test
    void test() {
        page.countCards().shouldBe(CollectionCondition.size(6));
        page.presenceHeaders();
        page.presenceDescription();
        page.presencePrice();
        page.presenceButton();
    }
}
