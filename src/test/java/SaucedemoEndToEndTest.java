import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SaucedemoEndToEndTest {
    static InventoryPage page = new InventoryPage();
    static SaucedemoPage loginPage = new SaucedemoPage();
    static CheckoutPage checkoutPage = new CheckoutPage();
    static String userLogin = "standard_user";
    static String userPass = "secret_sauce";
    static String headOfCard1 = "Sauce Labs Backpack";
//    static String headOfCard2 = "Sauce Labs Bike Light";
    static String headOfCard3 = "Sauce Labs Bolt T-Shirt";
    static String headOfCard4 = "Sauce Labs Fleece Jacket";
    static String headOfCard5 = "Sauce Labs Onesie";
    static String priceOfItem1 = "$29.99";
    static String priceOfItem4 = "$49.99";
    static String priceOfItem5 = "$7.99";

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.saucedemo.com";
        loginPage.open().login(userLogin, userPass);
    }

    @Test
    void test() {
        page.pushTheButtonOnItem(headOfCard1);
        page.clickOnHeaderCard(headOfCard3);
        page.checkPageOfItem(headOfCard3);
        page.pushTheButtonInsideItem();
        page.pushTheButtonBackToProducts();
        page.pushTheButtonOnItem(headOfCard4);
        page.pushTheButtonOnItem(headOfCard5);
        page.pushTheButtonOnItem(headOfCard3);
        page.openCart();
        page.checkQuantityItemInCart(headOfCard1);
        page.checkQuantityItemInCart(headOfCard5);
        page.checkQuantityItemInCart(headOfCard4);
        page.checkPriceItemInCart(headOfCard1, priceOfItem1);
        page.checkPriceItemInCart(headOfCard5, priceOfItem5);
        page.checkPriceItemInCart(headOfCard4, priceOfItem4);
        page.removeItemFromCart(headOfCard4);
        page.checkItemInTheCart(headOfCard1);
        page.checkItemInTheCart(headOfCard5);
        page.clickCheckOut();
        page.fillCheckoutForm();
        checkoutPage.checkItemInCheckout(headOfCard1);
        checkoutPage.checkItemInCheckout(headOfCard5);
        checkoutPage.checkPriceItemInCheckout(headOfCard1, priceOfItem1);
        checkoutPage.checkPriceItemInCheckout(headOfCard5, priceOfItem5);
        checkoutPage.checkQuantityItemInCheckout(headOfCard1);
        checkoutPage.checkQuantityItemInCheckout(headOfCard5);
        checkoutPage.checkSummaryInformation();
        checkoutPage.pressFinish();
        checkoutPage.checkComplete();
        page.checkInventoryPage();
    }
}
