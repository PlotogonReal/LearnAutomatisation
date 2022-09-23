import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartTest1 {
    @BeforeAll
    static void setup() {
        //       Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }
    //доп класс с методами по каждой строчке
    @Test
    void test() {
        $(byClassName("pricebar")).find(byTagName("button")).click();//нажали "Add to cart" на первой карточке
        $(byClassName("pricebar")).find(byTagName("button")).shouldHave(text("Remove"));//убедились, что сменилась надпись на "Remove"
        $(byClassName("shopping_cart_link")).shouldHave(text("1"));//убедились, что появилась единичка на корзине
        $(byClassName("pricebar")).find(byTagName("button")).click();//нажали "Remove"
        $(byClassName("pricebar")).find(byTagName("button")).shouldHave(text("Add to cart"));//убедились, что надпись сменилась на "Add to cart"
        $(byClassName("shopping_cart_link")).shouldNotHave(text("1"));//убедились, что единичка с корзины исчезла
    }
}