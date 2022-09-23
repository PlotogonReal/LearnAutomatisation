import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class InventoryPage {
    ElementsCollection results = $$x("//div[@class='inventory_item']");
    public ElementsCollection countCards(){
        return results;
    }
   public void presenceHeaders(){
       for (SelenideElement element : results) {
           element.$(".inventory_item_name").should(not(empty));//в этом классе - заголовок
       }
   }
    public void presenceDescription(){
        for (SelenideElement element : results) {
            element.$(".inventory_item_desc").should(not(empty));//в этом классе - описание
        }
    }
    public void presencePrice(){
        for (SelenideElement element : results) {
            element.$(".inventory_item_price").should(not(empty));//в этом классе - цена
        }
    }
    public void presenceButton(){
        for (SelenideElement element : results) {
            element.$x(".//button[text()='Add to cart']").should(exist);//кнопка "Add to cart"
        }
    }
}
