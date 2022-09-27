import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

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
    public void checkTheCurrentPage(){
        webdriver().shouldHave(url(baseUrl));
    }
    public void clickBurgerMenu(){
        $(By.id("react-burger-menu-btn")).click();
    }
    public void clickLogout(){
        $(By.id("logout_sidebar_link")).click();
    }
}
