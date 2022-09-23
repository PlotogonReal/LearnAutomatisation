import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

import org.openqa.selenium.By;

public class Temporary {
    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }

    @Test
    void go() {
        $x("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//button")
                .click();//кликнули по кнопке "Add to cart" товара 'Sauce Labs Backpack'
        $x("//div[text()='Sauce Labs Bolt T-Shirt']").click(); //кликнули по заголовку товара "Sauce Labs Bolt T-Shirt"
        webdriver().shouldHave(url("https://www.saucedemo.com/inventory-item.html?id=1"));//убедились, что находимся внутри карточки товара
        $x("//button[text()='Add to cart']").click();
        $x("//button[text()='Back to products']").click();
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item_description']//button").click();
        $x("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item_description']//button").click();
        $x("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item_description']//button").click();
        $(byClassName("shopping_cart_link")).click();//перешли в корзину
        $x("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")
                .shouldHave(text("1"));
        $x("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
                .shouldHave(text("$29.99"));
        $x("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")
                .shouldHave(text("1"));
        $x("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
                .shouldHave(text("$7.99"));
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")
                .shouldHave(text("1"));
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
                .shouldHave(text("$49.99"));
        $x("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//button").click();//удаляем из корзины товар
        $x("//div[text()='Sauce Labs Backpack']").should(exist);//на месте ли товар
        $x("//div[text()='Sauce Labs Onesie']").should(exist);//на месте ли второй
        $("#checkout").click();
    }
}
