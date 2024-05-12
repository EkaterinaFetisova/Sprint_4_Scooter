import org.junit.Test;
import pageobject.ScooterWelcomeHomePage;


public class MainTests extends BeforeAfter{

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

}
