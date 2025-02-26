package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class QuestionsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By questions = By.xpath(MainPage.ListQuestion);
    private By answers = By.xpath(MainPage.ListAnswers);
    private By acceptCookies = By.xpath(MainPage.AcceptCookie);

    public QuestionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
            cookieButton.click();
        } catch (TimeoutException | NoSuchElementException e) {
            // Куки уже приняты
        }
    }

    public void clickQuestion(int index) {
        acceptCookies();
        List<WebElement> questionElements = driver.findElements(questions);

        if (index < questionElements.size()) {
            WebElement question = questionElements.get(index);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
            question.click();

            List<WebElement> answerElements = driver.findElements(answers);
            if (index < answerElements.size()) {
                wait.until(ExpectedConditions.visibilityOf(answerElements.get(index)));
            }
        }
    }

    public boolean isAnswerDisplayed(int index) {
        List<WebElement> answerElements = driver.findElements(answers);
        if (index < answerElements.size()) {
            wait.until(ExpectedConditions.visibilityOf(answerElements.get(index)));
            return answerElements.get(index).isDisplayed();
        }
        return false;
    }
}