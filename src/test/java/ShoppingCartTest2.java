import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
public class ShoppingCartTest2 {
    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }
    @Test
    void test(){
        String nameHeader = $(byClassName("inventory_item")).find(By.className("inventory_item_name")).getText();//запомнили заголовок первой карточки
        $(byClassName("pricebar")).find(byTagName("button")).click();//нажали "Add to cart" на первой карточке
        $(byClassName("shopping_cart_link")).click();//перешли в корзину
        webdriver().shouldHave(url("https://www.saucedemo.com/cart.html"));//убедились, что мы в корзине
        $(byClassName("inventory_item_name")).shouldHave(exactText(nameHeader));//убедились, что заголовки товара в карточке и корзине равны
        $(byText("Remove")).click();//нажали кнопку "Remove
        $(byName("continue-shopping")).click();//нажали кнопку "Continue Shopping"
        $(byClassName("pricebar")).find(byTagName("button")).shouldHave(text("Add to cart"));//проверили надпись на кнопке на первой карточкек
        $(byClassName("shopping_cart_link")).shouldNotHave(text("1"));//проверили, что на корзине нет единички

    }
}
