import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Temporary {

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        new SaucedemoPage().open().login("standard_user", "secret_sauce");
    }

    @Test
    void go() {


    }
}
