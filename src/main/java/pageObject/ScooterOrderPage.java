package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static pageobject.ScooterWelcomeHomePage.LOWER_BUTTON;
import static pageobject.ScooterWelcomeHomePage.UPPER_BUTTON;

public class ScooterOrderPage {
    private final WebDriver driver;

    // Поле "Имя"
    private final By inputName = By.xpath(".//input[contains(@placeholder, '* Имя')]");
    // Поле "Фамилия""
    private final By inputSurname = By.xpath(".//input[contains(@placeholder, '* Фамилия')]");
    // Поле "Адрес:куда привезти заказ"
    private final By inputAddress = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");
    // Выпадающий список "Станция метро"
    private final By dropdownMetroStation = By.xpath(".//div[@class='select-search']");
    //Элемент выпадающего списка "Станция метро"
    private final By dropdownMetroStationElement = By.xpath(".//div[@class='select-search__select']/ul/li");
    // Поле "Телефон: на него позвонит курьер"
    private final By inputPhone = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");
    // Кнопка "Далее"
    private final By buttonNext = By.xpath(".//button[contains(text(), 'Далее')]");
    //Пикер "Когда привезти самокат"
    private final By datePicker = By.xpath(".//div[@class='Order_MixedDatePicker__3qiay']/div[@class='react-datepicker-wrapper']/div/input");
    //Элемент выбора дня месяца
    private final By selectedMonthDays = By.xpath(".//div[@class='react-datepicker__month']//div[contains(@class, 'react-datepicker__day')]");
    //Выпадающий список "Срок аренды"
    private final By dropdownPeriod = By.className("Dropdown-root");
    //Элемент выпадающего списка "Срок аренды"
    private final By dropdownPeriods = By.className("Dropdown-option");
    //Боксы выбора цвета
    //Чек-бокс "черный жемчуг"
    private final By boxBlackColor = By.id("black");
    //Чек-бокс "серая безысходность"
    private final By boxGrayColor = By.id("grey");
    //Поле "Комментарий для курьера"
    private final By inputComment = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");
    //Кнопка "Заказать"
    private final By buttonOrder = By.xpath(".//div[contains(@class, 'Order_Buttons__1xGrp')]/button[text()='Заказать']");
    //Заголовок "Хотите оформить заказ?" на модалке подтверждения
    private final By titleConfirmationWindow = By.className("Order_ModalHeader__3FDaJ");
    private static final String TITLE_CONFIRMATION_WINDOW = "Хотите оформить заказ?\n" + " ";
    //Кнопка "Да"
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    //Заголовок "Заказ оформлен"
    private final By titleOrderReceived = By.className("Order_ModalHeader__3FDaJ");
    private static final String TITLE_ORDER_PROCESSED = "Заказ оформлен";
    //Кнопка "Посмотреть статус"
    private final By buttonStatus = By.xpath(".//button[text()='Посмотреть статус']");
    //Всплывающее уведомление "И здесь куки! В общем, мы их используем."
    private final By notificationCookie = By.className("App_CookieConsent__1yUIN");
    //Кнопка "да все привыкли"
    private final By buttonCloseCookie = By.id("rcc-confirm-button");

    //Конструктор класса
    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //Закрыть всплывающее уведомление "И здесь куки! В общем, мы их используем."
    public void closeCookieNotification() {
        try {
            WebElement cookieNotification = driver.findElement(notificationCookie);
            if (cookieNotification.isDisplayed()) {
                WebElement closeButton = driver.findElement(buttonCloseCookie);
                closeButton.click();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Заполнить поле "Имя"
    public void setInputName(String name) {
        WebElement nameInputElement = driver.findElement(inputName);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nameInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nameInputElement)).click();

        nameInputElement.clear();
        nameInputElement.sendKeys(name);

        wait.until(ExpectedConditions.attributeToBe(nameInputElement, "value", name));
    }
    //Заполнить поле "Фамилия"
    public void setInputSurname(String surname) {
        WebElement surnameInputElement = driver.findElement(inputSurname);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", surnameInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(surnameInputElement)).click();

        surnameInputElement.clear();
        surnameInputElement.sendKeys(surname);

        wait.until(ExpectedConditions.attributeToBe(surnameInputElement, "value", surname));
    }
    //Заполнить поле "Адрес"
    public void setInputAddress(String address) {
        WebElement addressInputElement = driver.findElement(inputAddress);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addressInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addressInputElement)).click();

        addressInputElement.clear();
        addressInputElement.sendKeys(address);

        wait.until(ExpectedConditions.attributeToBe(addressInputElement, "value", address));
    }
    //Выбрать из селекта "Станция метро"
    public void selectMetroStation(String metroStationName) {
        WebElement metroStationDropdown = driver.findElement(dropdownMetroStation);
        metroStationDropdown.click();

        WebDriverWait ulWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ulWait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMetroStationElement));

        List<WebElement> options = driver.findElements(dropdownMetroStationElement);
        for (WebElement option : options) {
            if (option.getText().equals(metroStationName)) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", option);
                option.click();
                break;
            }
        }
    }
    //Заполнить поле "Телефон: на него позвонит курьер"
    public void setInputPhone(String phone) {
        WebElement phoneInputElement = driver.findElement(inputPhone);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", phoneInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(phoneInputElement)).click();

        phoneInputElement.clear();
        phoneInputElement.sendKeys(phone);
    }
    //Нажать "Далее"
    public void clickNextButton() {
        WebElement nextButtonElement = driver.findElement(buttonNext);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonElement)).click();
    }
    //Выбрать из селекта "Дата доставки"
    public void selectDate(String date) {
        WebElement datePickerElement = driver.findElement(datePicker);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", datePickerElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(datePickerElement)).click();
        datePickerElement.sendKeys(date);

        List<WebElement> allSelectedMonthDays = driver.findElements(selectedMonthDays);
        String day = date.substring(0, 2);
        if (day.substring(0,1).equals("0")) {
            day = date.substring(1, 2);
        }
        for (WebElement option : allSelectedMonthDays) {
            if (option.getText().equals(day)) {
                option.click();
                break;
            }
        }
    }
    //Выбрать из селекта "Срок аренды"
    public void selectPeriod(String period) {
        WebElement lengthDropdown = driver.findElement(dropdownPeriod);
        lengthDropdown.click();

        List<WebElement> allPeriodsFromDropdown = driver.findElements(dropdownPeriods);

        for (WebElement option : allPeriodsFromDropdown) {
            if (option.getText().equals(period)) {
                option.click();
                break;
            }
        }
    }
    //Выбрать из селекта "Цвет самоката"
    public void selectColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            WebElement blackColorBox = driver.findElement(boxBlackColor);
            blackColorBox.click();
        } else if (color.equalsIgnoreCase("gray")) {
            WebElement grayColorBox = driver.findElement(boxGrayColor);
            grayColorBox.click();
        }
    }
    //Заполнить поле "Комментарий"
    public void setInputComment(String comment) {
        WebElement commentInputElement = driver.findElement(inputComment);
        commentInputElement.sendKeys(comment);
    }
    //Нажать "Заказать"
    public void clickOrderButton() {
        WebElement orderButtonElement = driver.findElement(buttonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", orderButtonElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonElement)).click();
    }
    //Получить заголовок модального окна "Хотите оформить заказ?"
    public String getDoYouReallyWantTitle() {
        WebElement titleElement = driver.findElement(titleConfirmationWindow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", titleElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(titleElement)).getText();
    }
    //Нажать кнопку "Да"
    public void clickYesButton() {
        WebElement yesButtonElement = driver.findElement(buttonYes);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", yesButtonElement);

        yesButtonElement.click();
    }
    //Нажать на кнопку "Посмотреть статус"
    public void clickStatusButton() {
        WebElement statusButtonElement = driver.findElement(buttonStatus);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", statusButtonElement);

        statusButtonElement.click();
    }
    //Переход на главную страницу qa-scooter

    public String getOrderReceivedTitle() {
        WebElement titleElement = driver.findElement(titleOrderReceived);
        return titleElement.getText().substring(0, 14);
    }

    // Выбор верхней или нижней кнопку "Заказать"
    public ScooterOrderPage chooseTheOrderButtonToClick(String button){

        ScooterWelcomeHomePage objScooterPage = new ScooterWelcomeHomePage(driver);

        closeCookieNotification();

        switch (button) {
            case UPPER_BUTTON:
                objScooterPage.clickUpperOrderButton();
                break;
            case LOWER_BUTTON:
                objScooterPage.clickLowerOrderButton();
                break;
            default: objScooterPage.clickUpperOrderButton();
        }
        return this;
    }
    //Заполнение шаг1 - Пользовательские данные
    public ScooterOrderPage fillInUserPersonalData(String name, String surname, String address, String metroStation, String phone){
        setInputName(name);
        setInputSurname(surname);
        setInputAddress(address);
        selectMetroStation(metroStation);
        setInputPhone(phone);
        clickNextButton();
        return this;
    }
    //Заполнение шаг2 - Детали заказа
    public ScooterOrderPage fillInOrderDetails(String date, String period, String color, String comment){
        selectDate(date);
        selectPeriod(period);
        selectColor(color);
        setInputComment(comment);
        clickOrderButton();
        return this;
    }
    //Проверка заголовка модального окна
    public void checkOrderConfirmationModal() {
        String confirmationTitle = getDoYouReallyWantTitle();
        Assert.assertEquals("Заголовок модального окна подтверждения неверный: ",TITLE_CONFIRMATION_WINDOW, confirmationTitle);
        clickYesButton();
    }
    //Проверка заголовка модального окна "Заказ оформлен"
    public void checkOrderStatusModal() {
        String orderReceivedTitle = getOrderReceivedTitle();
        Assert.assertEquals("Не получилось оформить заказ!", TITLE_ORDER_PROCESSED, orderReceivedTitle);
        clickStatusButton();
    }

}