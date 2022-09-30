import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class ShoppingCartTest2 {
    static InventoryPage page = new InventoryPage();
    static SaucedemoPage loginPage = new SaucedemoPage();
    static String userLogin = "standard_user";
    static String userPass = "secret_sauce";
    static int numberOfCard = 2;//(1-6)
    @BeforeAll
    static void setup() {
  //      Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.saucedemo.com";
        loginPage.open().login(userLogin, userPass);
    }
    @Test
    void test(){
        page.setNumberOfCard(numberOfCard);
        page.pushTheButton();
        page.rememberHeaderOfCard();
        page.openCart();
        page.checkItemInCart();
        page.clickRemoveInCart();
        page.clickContinueShopping();
        page.checkLabelAddToCardlOnTheButton();
        page.checkEmptyCart();
     }
}
