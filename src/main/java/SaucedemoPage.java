import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SaucedemoPage {

    public  SaucedemoPage open() {
        Selenide.open(baseUrl);
        return this;
    }
    public SaucedemoPage login(String user, String password){
        $(By.id("user-name")).setValue(user);
        $(By.id("password")).setValue(password).pressEnter();
        return this;
    }
    public void checkTheCurrentPage(String add){
        webdriver().shouldHave(url(baseUrl + add));
    }
    public void clickBurgerMenu(){
        $(By.id("react-burger-menu-btn")).click();
    }
    public void clickLogout(){
        $(By.id("logout_sidebar_link")).click();
    }
    public void checkWarningUserLogin(){
        $(By.cssSelector("form div:nth-child(1) svg")).should(exist);
    }
    public void checkWarningUserPass(){
        $(By.cssSelector("form div:nth-child(2) svg")).should(exist);
    }
    public void checkWarningMassage(){
        $(By.xpath("//div[@class='error-message-container error']"))
                .shouldHave(exactTextCaseSensitive("Epic sadface: Sorry, this user has been locked out."));
    }
}
