package pageobject;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.time.Duration;

import static pageobject.constants.URL.HOME_PAGE;
import static pageobject.constants.URL.ORDER_PAGE;

public class ScooterWelcomeHomePage {
        private WebDriver driver;

        // Кнопка "Заказать" вверху страницы
        private final By upperOrderButton = By.className("Button_Button__ra12g");
        // Кнопка "Заказать" внизу страницы
        private final By lowerOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");
        //Подзаголовок "Вопросы о важном"
        private final By questionsTitle = By.xpath(".//div[text()='Вопросы о важном']");
        //Кнопка логотипа "Самокат"
        private final By logoSamokat = By.className("Header_LogoScooter__3lsAR");
        public static final String UPPER_BUTTON = "upper";
        public static final String LOWER_BUTTON = "lower";


        //Конструктор класса
    public ScooterWelcomeHomePage(WebDriver driver) {
        this.driver = driver;
    }

        //Проверка заголовка раздела "Вопросы о важном"
        public void checkQuestionsHeaderTitle() {
        WebElement questionsTitleElement = driver.findElement(questionsTitle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", questionsTitleElement);

        Assert.assertEquals(" Неверный заголовок раздела вопросов", "Вопросы о важном", questionsTitleElement.getText());
    }

        //Проверка: открыта ли страница оформления заказа
        public void checkOrderPageOpened(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals("Не открылась страница оформления заказа", ORDER_PAGE, driver.getCurrentUrl());
    }
        //Проверка нажатия на верхнюю кнопку "Заказать"
        public void clickUpperOrderButton() {
        WebElement upperButton = driver.findElement(upperOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", upperButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        upperButton.click();
    }
        //Проверка нажатия на нижнюю кнопку "Заказать"
        public void clickLowerOrderButton() {
        WebElement lowerButton = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lowerButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        lowerButton.click();
    }
        //Проверка открытия главной страницы "Самокат" при нажатии на логотип "Самокат"
        public void checkOpenHomePageSamokat() {
        WebElement samokatLogo = driver.findElement(logoSamokat);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", samokatLogo);
        samokatLogo.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals("Не открылась главная страница Самокат", HOME_PAGE, driver.getCurrentUrl());
    }

    }

