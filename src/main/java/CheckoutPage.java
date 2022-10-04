import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
public class CheckoutPage {
    static InventoryPage page = new InventoryPage();
    public void checkItemInCheckout(String headOfCard){
        page.checkItemInTheCart(headOfCard);
    }
    public void checkPriceItemInCheckout(String headOfCard, String priceItem){
        page.checkPriceItemInCart(headOfCard, priceItem);
    }
    public void checkQuantityItemInCheckout(String headOfCard){
        page.checkQuantityItemInCart(headOfCard);
    }
    public void checkSummaryInformation(){
        $(By.xpath("//div[@class='summary_value_label'][text()='SauceCard #31337']")).should(exist);
        $(By.xpath("//div[@class='summary_value_label'][text()='FREE PONY EXPRESS DELIVERY!']")).should(exist);
        $(byClassName("summary_subtotal_label")).shouldHave(text("Item total: $37.98"));
        $(byClassName("summary_tax_label")).shouldHave(text("Tax: $3.04"));
        $(byClassName("summary_total_label")).shouldHave(text("Total: $41.02"));
    }
    public void pressFinish() {
    $(byText("Finish")).click();
    }
    public void checkComplete(){
        webdriver().shouldHave(url("https://www.saucedemo.com/checkout-complete.html"));
        $(byClassName("complete-header")).shouldHave(text("THANK YOU FOR YOUR ORDER"));
        $(byText("Back Home")).click();
    }
}
