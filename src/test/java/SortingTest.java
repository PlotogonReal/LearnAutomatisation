import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SortingTest {
    static InventoryPage page = new InventoryPage();
    static SaucedemoPage loginPage = new SaucedemoPage();
    static String userLogin = "standard_user";
    static String userPass = "secret_sauce";
    private Object[] objects;

    enum SortType {
        AZ("Name (A to Z)"),
        ZA("Name (z to A)"),
        PU("Price Up"),
        PD("Price Down");

        private String title;

        SortType(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

    }

    //    enum params  {
//        List.of(Arguments.of(SortType.AZ, List.of("Sauce Labs Backpack", "Sauce Labs Bike Light"))
//    }//List.of(Arguments.of(SortType.AZ, List.of("Sauce Labs Backpack", "Sauce Labs Bike Light")),
    //Arguments.of(SortType.ZA, List.of("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie")));
    enum Params {
        SortValue("", "");
        //private final List<Arguments> members;

        public List<Arguments> getMembers() {
            return List.of(Arguments.of(SortType.AZ, List.of("Sauce Labs Backpack", "Sauce Labs Bike Light")));
        }

        private Params(String... members) {
        }
    }

    @BeforeAll
    static void setup() {
        //        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.saucedemo.com";

        loginPage.open().login(userLogin, userPass);
    }

    //параметризованный тест? способы сортировки. второй параметр - ожидаемые заголовки
    //тесты должны проходиться независимо от падения друг друга
    @ParameterizedTest
   // @EnumSource(SortType.class)
    @MethodSource("getParamsValue")
    void test(Arguments p) {

        objects = p.get();
        page.sorting()
        // page.sorting();
  /*      page.sortingAtoZ();
        page.checkSortingAtoZ();
        page.sortingZtoA();
        page.checkSortingZtoA();
        page.sortingByPriceMinToMax();
        page.checkSortingByPriceMinToMax();
        page.sortingByPriceMaxToMin();
        page.checkSortingByPriceMaxToMin(); */
    }

    static List<Arguments> getParamsValue() {
        return List.of(Arguments.of(SortType.AZ.getTitle(), List.of("Sauce Labs Backpack", "Sauce Labs Bike Light"),
                    Arguments.of(SortType.ZA.getTitle(), List.of("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie")))
        );
    }
}
