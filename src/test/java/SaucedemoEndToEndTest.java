import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SaucedemoEndToEndTest {
    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }

    @Test
    void test() {
        $x("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//button")
                .click();//кликнули по кнопке "Add to cart" товара 'Sauce Labs Backpack'
        $x("//div[text()='Sauce Labs Bolt T-Shirt']").click(); //кликнули по заголовку товара "Sauce Labs Bolt T-Shirt"
        webdriver().shouldHave(url("https://www.saucedemo.com/inventory-item.html?id=1"));//убедились, что находимся внутри карточки товара
        $x("//button[text()='Add to cart']").click();//нажали "Add to cart"
        $x("//button[text()='Back to products']").click();//вернулись на страницу с карточками
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item_description']//button")
                .click();//нажали "Add to cart" на карточке 'Sauce Labs Fleece Jacket'
        $x("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item_description']//button")
                .click();//нажали "Add to cart" на карточке 'Sauce Labs Onesie'
        $x("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item_description']//button")
                .click();//нажали "Add to cart" на карточке 'Sauce Labs Bolt T-Shirt'
        $(byClassName("shopping_cart_link")).click();//перешли в корзину
        $x("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")
                .shouldHave(text("1"));//убедились, что у 'Sauce Labs Backpack' количество - 1
        $x("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
                .shouldHave(text("$29.99"));//убедились, что у 'Sauce Labs Backpack' цена "$29.99"
        $x("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")
                .shouldHave(text("1"));//убедились, что у 'Sauce Labs Onesie' количество - 1
        $x("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
                .shouldHave(text("$7.99"));//убедились, что у 'Sauce Labs Onesie' цена - "$7.99"
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")
                .shouldHave(text("1"));//убедились, что у 'Sauce Labs Fleece Jacket' количество - 1
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
                .shouldHave(text("$49.99"));//убедились, что у 'Sauce Labs Fleece Jacket' цена - "$49.99"
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//button")
                .click();//удалили из корзины 'Sauce Labs Fleece Jacket'
        $x("//div[text()='Sauce Labs Backpack']").should(exist);//на месте ли 'Sauce Labs Backpack'
        $x("//div[text()='Sauce Labs Onesie']").should(exist);//на месте ли 'Sauce Labs Onesie'
        $("#checkout").click();//нажали в корзине "checkout"
    }
}
