import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;

public class InventoryPage {
    ElementsCollection results = $$x("//div[@class='inventory_item']");

    public void countCards(int numberOfCardsOnThePage) {
        results.shouldBe(size(numberOfCardsOnThePage));
    }

    public void checkCard1() {
        results.get(0).$(By.cssSelector(".inventory_item_name")).shouldHave(exactTextCaseSensitive("Sauce Labs Backpack"));
        results.get(0).$(By.cssSelector(".inventory_item_desc"))
                .shouldHave(exactText("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."));
        results.get(0).$(By.cssSelector(".inventory_item_price")).shouldHave(exactText("$29.99"));
        results.get(0).$(By.cssSelector("#add-to-cart-sauce-labs-backpack")).should(exist);
    }

    public void checkCard2() {
        results.get(1).$(By.cssSelector(".inventory_item_name")).shouldHave(exactTextCaseSensitive("Sauce Labs Bike Light"));
        results.get(1).$(By.cssSelector(".inventory_item_desc"))
                .shouldHave(exactText("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."));
        results.get(1).$(By.cssSelector(".inventory_item_price")).shouldHave(exactText("$9.99"));
        results.get(1).$(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).should(exist);
    }

    public void checkCard3() {
        results.get(2).$(By.cssSelector(".inventory_item_name")).shouldHave(exactTextCaseSensitive("Sauce Labs Bolt T-Shirt"));
        results.get(2).$(By.cssSelector(".inventory_item_desc"))
                .shouldHave(exactText("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."));
        results.get(2).$(By.cssSelector(".inventory_item_price")).shouldHave(exactText("$15.99"));
        results.get(2).$(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).should(exist);
    }

    public void checkCard4() {
        results.get(3).$(By.cssSelector(".inventory_item_name")).shouldHave(exactTextCaseSensitive("Sauce Labs Fleece Jacket"));
        results.get(3).$(By.cssSelector(".inventory_item_desc"))
                .shouldHave(exactText("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."));
        results.get(3).$(By.cssSelector(".inventory_item_price")).shouldHave(exactText("$49.99"));
        results.get(3).$(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).should(exist);
    }

    public void checkCard5() {
        results.get(4).$(By.cssSelector(".inventory_item_name")).shouldHave(exactTextCaseSensitive("Sauce Labs Onesie"));
        results.get(4).$(By.cssSelector(".inventory_item_desc"))
                .shouldHave(exactText("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."));
        results.get(4).$(By.cssSelector(".inventory_item_price")).shouldHave(exactText("$7.99"));
        results.get(4).$(By.cssSelector("#add-to-cart-sauce-labs-onesie")).should(exist);
    }

    public void checkCard6() {
        results.get(5).$(By.cssSelector(".inventory_item_name")).shouldHave(exactTextCaseSensitive("Test.allTheThings() T-Shirt (Red)"));
        results.get(5).$(By.cssSelector(".inventory_item_desc"))
                .shouldHave(exactText("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."));
        results.get(5).$(By.cssSelector(".inventory_item_price")).shouldHave(exactText("$15.99"));
//        results.get(5).$(By.cssSelector("#add-to-cart-test.allthethings()-t-shirt-(red)")).should(exist);
        results.get(5).$("button").shouldHave(text("Add to cart"));
    }
}
