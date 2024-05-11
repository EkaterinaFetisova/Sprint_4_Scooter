import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MainTests {
    private WebDriver driver;

    @Before
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Проверка названия раздела "Вопросы о важном"
    @Test
    public void checkQuestionsHeaderTitle() {
        ScooterWelcomeHomePage objScooterPage = new ScooterWelcomeHomePage(driver);
        objScooterPage.checkQuestionsHeaderTitle();
    }

    //Нажать верхнюю кнопку "Заказать"
    @Test
    public void clickUpperOrderButton() {
        ScooterWelcomeHomePage objScooterPage = new ScooterWelcomeHomePage(driver);
        objScooterPage.clickUpperOrderButton();
        objScooterPage.checkOrderPageOpened();
    }

    //Нажать нижнюю кнопку "Заказать"
    @Test
    public void clickLowerOrderButton() {
        ScooterWelcomeHomePage objScooterPage = new ScooterWelcomeHomePage(driver);
        objScooterPage.clickLowerOrderButton();
        objScooterPage.checkOrderPageOpened();
    }

    //Проверка перехода на главную страницу "Самокат"
    @Test
    public void checkLogoSamokat() {
        ScooterWelcomeHomePage objScooterPage = new ScooterWelcomeHomePage(driver);
        objScooterPage.checkOpenHomePageSamokat();
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
