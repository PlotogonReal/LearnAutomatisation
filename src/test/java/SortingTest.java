import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.texts;

import org.openqa.selenium.By;

public class SortingTest {
    @BeforeAll
    static void setup() {
        //       Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }
    //параметризованный тест? способы сортировки. второй параметр - ожидаемые заголовки
    //тесты должны проходиться независимо от падения друг друга
    @Test
    void test() {
        $(by("data-test", "product_sort_container"))
                .shouldHave(text("Name (A to Z)"));//убедились, что выбрана сортировка по-умолчанию
        $$(By.xpath("//div[@class='inventory_item_name']"))
                .shouldHave(texts("Sauce Labs Backpack",
                        "Sauce Labs Bike Light",
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket",
                        "Sauce Labs Onesie",
                        "Test.allTheThings() T-Shirt (Red)"));//убедились, что сортировка соответствует эталонной сортировке по-умолчанию
        $(by("data-test", "product_sort_container"))
                .selectOption("Name (Z to A)");//переключились на сортировку в обратном алфавитном порядке
        $$(By.xpath("//div[@class='inventory_item_name']"))
                .shouldHave(texts("Test.allTheThings() T-Shirt (Red)",
                                "Sauce Labs Onesie",
                                "Sauce Labs Fleece Jacket",
                                "Sauce Labs Bolt T-Shirt",
                                "Sauce Labs Bike Light",
                                "Sauce Labs Backpack"));//убедились, что сортировка соответствует эталонной сортировке в обратном алфавитном порядке
        $(by("data-test", "product_sort_container"))
                .selectOption("Price (low to high)");//переключились на сортировку по возрастанию цены
        $$(By.xpath("//div[@class='inventory_item_price']"))
                .shouldHave(texts("$7.99",
                                "$9.99",
                                "$15.99",
                                "$15.99",
                                "$29.99",
                                "$49.99"));
        $(by("data-test", "product_sort_container"))
                .selectOption("Price (high to low)");//переключились на сортировку по убыванию цены
        $$(By.xpath("//div[@class='inventory_item_price']"))
                .shouldHave(texts("$49.99",
                                "$29.99",
                                "$15.99",
                                "$15.99",
                                "$9.99",
                                "$7.99"));
    }
}
