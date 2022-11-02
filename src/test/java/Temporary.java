import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Temporary {

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru/");
    }

    @Test
    void go() {
        $(byAttribute("placeholder", "найдётся всё")).setValue("eur moex").pressEnter();
        WebDriver driver = getWebDriver();
        Actions action = new Actions(driver);
        By by = By.cssSelector("path.highcharts-area");
        WebElement elem = driver.findElement(by);
        action.moveToElement(elem).perform ();
        executeJavaScript(
               "$($('path.highcharts-crosshair')[0]).attr('visibility', 'visible');"
        );
/*
        executeJavaScript(
                "$($('123')[0]).attr('visibility', 'visible');"
        );
*/
        $(By.xpath("//div[@class='summary_value_label'][text()='SauceCard #31337']")).should(Condition.image);

 /*       $("path.highcharts-area").hover();
        sleep(1000);
        actions().moveByOffset(-5, 0);
        sleep(1000);
        actions().moveByOffset(-5, 0);        sleep(1000);
        actions().moveByOffset(-5, 0);*/


    }
}
