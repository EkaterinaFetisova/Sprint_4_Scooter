import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static pageobject.constants.URL.HOME_PAGE;

public class BeforeAfter {
        WebDriver driver;
        @Before
        public void setup() {
            ChromeOptions options = new ChromeOptions();
            //driver = new ChromeDriver(options);
            driver = new FirefoxDriver();
            driver.get(HOME_PAGE);
        }

        @After
        public void teardown() {
            // Закрыть браузер
            driver.quit();
        }
    }

