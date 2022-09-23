import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SaucedemoPage {

    public  SaucedemoPage open() {
        Selenide.open("https://www.saucedemo.com/");
        return this;
    }
    public SaucedemoPage login(String user, String password){
        $(By.id("user-name")).setValue(user);
        $(By.id("password")).setValue(password).pressEnter();
        return this;
    }
}
