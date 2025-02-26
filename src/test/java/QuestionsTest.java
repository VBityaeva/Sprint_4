import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.QuestionsPage;
import java.time.Duration;

public class QuestionsTest {
    private WebDriver driver;
    private QuestionsPage questionsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        questionsPage = new QuestionsPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("qa-scooter"));
    }

    @Test
    public void testQuestionsAccordion() {
        for (int i = 0; i < 8; i++) {
            questionsPage.clickQuestion(i);
            final int questionIndex = i;
            Assert.assertTrue("Ответ не отображается для вопроса " + i,
                    new WebDriverWait(driver, Duration.ofSeconds(3))
                            .until(driver -> questionsPage.isAnswerDisplayed(questionIndex))
            );
        }
    }

    @After
    public void tearDown() {
            driver.quit();
    }
}
