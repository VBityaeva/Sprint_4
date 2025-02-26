package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.MainPage.ListMetroStation;

public class OrderFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.xpath(MainPage.InputName);
    private By surnameField = By.xpath(MainPage.InputSurname);
    private By addressField = By.xpath(MainPage.InputAddress);
    private By metroField = By.xpath(MainPage.SelectMetroStation);
    private By searchResultsMetro = By.xpath(ListMetroStation);
    private By phoneField = By.xpath(MainPage.InputPhone);
    private By inputDate = By.xpath(MainPage.InputDate);
    private By confirmationPopup = By.xpath(MainPage.ConfirmationPopup);
    private By acceptButton = By.xpath(MainPage.ConfirmationAccept);
    private By successPopup = By.xpath(MainPage.SuccessPopup);
    private By acceptCookies = By.xpath(MainPage.AcceptCookie);

    public OrderFormPage(WebDriver driver) {
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

    public void fillForm(String name, String surname, String address, String metro, String phone, String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameField)).sendKeys(surname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(address);

        WebElement metroInput = wait.until(ExpectedConditions.visibilityOfElementLocated(metroField));
        metroInput.sendKeys(metro);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsMetro));
        WebElement firstResult = driver.findElements(searchResultsMetro).get(0);
        firstResult.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MainPage.NextButton))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputDate)).sendKeys(date);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MainPage.DropDown))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MainPage.DropDownSecond))).click();
    }

    public void confirmationOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MainPage.OrderButtonDown))).click();
    }

    public boolean isConfirmationPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationPopup)).isDisplayed();
    }

    public void confirmationAccept() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
    }

    public boolean isSuccessPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successPopup)).isDisplayed();
    }
}
