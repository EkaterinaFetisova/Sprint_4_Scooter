import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.ScooterQuestionsHomePage;
import static pageObject.ScooterQuestionsHomePage.*;

    @RunWith(Parameterized.class)
    public class QuestionsTest {
        private WebDriver driver;
        // Элементы выпадающего списка: Вопрос и Ответ
        private final By questionLocator;
        private final By answerLocator;
        private final String questionExpectedText;
        private final String questionExpectedAnswer;

        //Конструктор класса
        public QuestionsTest(By questionLocator, By answerLocator, String questionText, String questionAnswer) {
            this.questionLocator = questionLocator;
            this.answerLocator = answerLocator;
            this.questionExpectedText = questionText;
            this.questionExpectedAnswer = questionAnswer;
        }

        @Parameterized.Parameters
        public static Object[][] getQuestions() {
            return new Object[][] {
                    {QUESTION1, ANSWER1, TEXT_QUESTION1, TEXT_ANSWER1},
                    {QUESTION2, ANSWER2, TEXT_QUESTION2, TEXT_ANSWER2},
                    {QUESTION3, ANSWER3, TEXT_QUESTION3, TEXT_ANSWER3},
                    {QUESTION4, ANSWER4, TEXT_QUESTION4, TEXT_ANSWER4},
                    {QUESTION5, ANSWER5, TEXT_QUESTION5, TEXT_ANSWER5},
                    {QUESTION6, ANSWER6, TEXT_QUESTION6, TEXT_ANSWER6},
                    {QUESTION7, ANSWER7, TEXT_QUESTION7, TEXT_ANSWER7},
                    {QUESTION8, ANSWER8, TEXT_QUESTION8, TEXT_ANSWER8},
            };
        }
        @Before
        public void beforeTest() {
            ChromeOptions options = new ChromeOptions();
            driver = new FirefoxDriver();
            //driver = new ChromeDriver(options);
            driver.get("https://qa-scooter.praktikum-services.ru/");
        }
        // Проверка на соответствие текстов вопроса и ответа ожидаемым значениям
        @Test
        public void shouldCheckQuestionAndAnswer() {

            ScooterQuestionsHomePage questionsPage = new ScooterQuestionsHomePage(driver);

            String questionActualText = questionsPage.getQuestionActualText(questionLocator);
            questionsPage.clickQuestion(questionLocator);
            String answerActualText = questionsPage.getAnswerActualText(answerLocator);

            Assert.assertEquals("Несоответствие фактического текста вопроса ожидаемому: ", questionExpectedText, questionActualText);
            Assert.assertEquals("Несоответствие фактического текста ответа ожидаемому: ", questionExpectedAnswer, answerActualText);
        }
        @After
        public void teardown() {
            // Закрыть браузер
            driver.quit();
        }
    }

