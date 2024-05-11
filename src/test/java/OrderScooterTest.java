import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.ScooterOrderPage;

import static pageObject.ScooterWelcomeHomePage.UPPER_BUTTON;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStationName;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;
    private final String button;

    private WebDriver driver;
    public OrderScooterTest(String name, String surname, String address, String metroStationName, String phone, String date, String period, String color, String comment, String button) {

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationName = metroStationName;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[][] testOrderData() {
        return new Object[][] {
                {"Тест", "Тестовый", "Тестовая д1, к1", "Театральная", "79999999999", "01.01.2025", "сутки", "black", "Плотину надо поднять. Рычагом. Рычаг я дам.",UPPER_BUTTON},
                {"Мухаммед", "Сармоджон", "Ватутина 1", "Ленинский проспект", "+79999999999", "10.06.2024", "двое суток", "gray", "Реку надо завалить. Камнем. Камень я не дам.",UPPER_BUTTON}
        };
    }
@Before
public void setup() {
        ChromeOptions options = new ChromeOptions();
        //driver = new ChromeDriver(options);
        driver = new FirefoxDriver();
    driver.get("https://qa-scooter.praktikum-services.ru");
}
    //Проверка оформления заказа
    @Test
    public void checkMakingOrder() {

        ScooterOrderPage objOrderForm = new ScooterOrderPage(driver);

        // Позитивный сценарий
        objOrderForm
                .chooseTheOrderButtonToClick(button)
                .fillInUserPersonalData(name, surname, address, metroStationName, phone)
                .fillInOrderDetails(date, period, color, comment)
                .checkOrderConfirmationModal();

        objOrderForm.checkOrderStatusModal();
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}