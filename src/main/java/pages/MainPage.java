package pages;

public class MainPage {
    // Заголовок страницы
    public static final String PageTitle = "//a[@class='Header_LogoScooter__3lsAR']";
    // Кнопка принятия куки
    public static final String AcceptCookie = "//button[@id='rcc-confirm-button']";
    // Локатор вопросов о важном
    public static final String ListQuestion = "//div[@data-accordion-component='AccordionItem']";
    // Локатор ответов на вопросы о важном
    public static final String ListAnswers = "//div[@data-accordion-component='AccordionItemPanel']";
    // Кнопка заказать вверху страницы
    public static final String OrderButtonUp = "//button[@class='Button_Button__ra12g']";
    // Кнопка заказать вверху страницы
    public static final String OrderButtonDown = "//button[@class='Button_Button__ra12g Button_Middle__1CSJM']";
    // Поле ввода имени
    public static final String InputName = "//input[@placeholder='* Имя']";
    // Поле ввода фамилии
    public static final String InputSurname = "//input[@placeholder='* Фамилия']";
    // Поле ввода адреса
    public static final String InputAddress = "//input[@placeholder='* Адрес: куда привезти заказ']";
    // Поле выбора станции метро
    public static final String SelectMetroStation = "//input[@placeholder='* Станция метро']";
    // Список станций метро
    public static final String ListMetroStation = "//div[@class='select-search__select']";
    // Поле ввода телефона
    public static final String InputPhone = "//input[@placeholder='* Телефон: на него позвонит курьер']";
    // Кнопка перехода к второй странице формы оформления заказа
    public static final String NextButton = "//button[text()='Далее']";
    // Поле ввода даты
    public static final String InputDate = "//input[@placeholder='* Когда привезти самокат']";
    // Кнопка отображение списка сроков аренды
    public static final String DropDown = "//span[@class='Dropdown-arrow']";
    // Выбор двое суток
    public static final String DropDownSecond = "//div[text()='двое суток']";
    //Поп-ап подтверждения заказа
    public static final String ConfirmationPopup = "//div[text()='Хотите оформить заказ?']";
    //Кнопка подтверждения заказа
    public static final String ConfirmationAccept = "//button[text()='Да']";
    //Поп-ап об успешном созданном заказе
    public static final String SuccessPopup = "//div[text()='Заказ оформлен']";
}
