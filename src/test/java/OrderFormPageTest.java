import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderFormPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderFormPageTest {
    private WebDriver driver;
    private OrderFormPage orderFormPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;

    public OrderFormPageTest(String name, String surname, String address, String metro, String phone, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCredentials() {
        return Arrays.asList(new Object[][]{
                {"Арбуз", "Арбузов", "Фрунзенская наб., 24", "Фрунзенская", "+79998889988","02/03/2025"},
                {"Банан", "Бананович", "ул. Петра Романова, 2", "Дубровка", "+74445554455","10.03.2025"},
        });
    }

    @Before
    public void setUp() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderFormPage = new OrderFormPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("qa-scooter"));
    }

    @Test
    public void orderTestOrderButtonUp() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        orderFormPage.acceptCookies();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MainPage.OrderButtonUp)));
        driver.findElement(By.xpath(MainPage.OrderButtonUp)).click();

        orderFormPage.fillForm(name, surname, address, metro, phone, date);
        orderFormPage.confirmationOrder();
        orderFormPage.isConfirmationPopupDisplayed();
        orderFormPage.confirmationAccept();
        orderFormPage.isSuccessPopupDisplayed();


        }

    @Test
    public void orderTestOrderButtonDown() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        orderFormPage.acceptCookies();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", MainPage.OrderButtonDown);
        driver.findElement(By.xpath(MainPage.OrderButtonDown)).click();

        orderFormPage.fillForm(name, surname, address, metro, phone, date);
        orderFormPage.confirmationOrder();
        orderFormPage.isConfirmationPopupDisplayed();
        orderFormPage.confirmationAccept();
        orderFormPage.isSuccessPopupDisplayed();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
