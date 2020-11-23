package unitest;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class unisenderTest {
   @BeforeTest
   public void setupBrowser() {
       Configuration.browser = "chrome";
   }

    @Test
    public void loginUnisender() {
        open("https://cp.unisender.com/ru/v5/login");
        $(byAttribute("data-test","input-login")).setValue("");
        $(byAttribute("data-test","input-password")).setValue("");
        $(byAttribute("data-test","btn-login")).click();

        sleep(5000);
        String currentUrl = url();
        String goodUrl = "https://cp.unisender.com/ru/v5/welcome";
        assertEquals(currentUrl, goodUrl);
    }
}
