import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.QuestionsPage;
import pages.WebDriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuestionsTest {
    private WebDriver driver;
    private QuestionsPage questionsPage;
    private final int questionIndex;

    public QuestionsTest(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        questionsPage = new QuestionsPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("qa-scooter"));
    }

    @Test
    public void testQuestionsAccordion() {
        questionsPage.clickQuestion(questionIndex);
        Assert.assertTrue("Ответ не отображается для вопроса " + questionIndex,
                new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(driver -> questionsPage.isAnswerDisplayed(questionIndex))
        );
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
