package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsbyTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=0.0.0.0");

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();

            driver = new ChromeDriver(service, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        closeCookieBanner();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Закрыть баннер cookies")
    private void closeCookieBanner() {
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.layout.layout--default > main > div > div.cookie.show > div > div.cookie__buttons > button.btn.btn_gray.cookie__cancel")));
            cookieBanner.click();
        } catch (Exception e) {
            System.out.println("Баннер cookies не найден или не виден.");
        }
    }

    @Test
    @DisplayName("Проверка текстов полей для всех вариантов оплаты")
    @Description("Проверить, что тексты заполнителей для всех вариантов оплаты корректны.")
    public void testFieldTextForAllPaymentOptions() {
        checkFieldText("Услуги связи", "Номер телефона", "Сумма", "E-mail для отправки чека");
        checkFieldText("Домашний интернет", "Номер абонента", "Сумма", "E-mail для отправки чека");
        checkFieldText("Рассрочка", "Номер счета на 44", "Сумма", "E-mail для отправки чека");
        checkFieldText("Задолженность", "Номер счета на 2073", "Сумма", "E-mail для отправки чека");
    }

    @Step("Проверка текстов полей для услуги: {mainService}")
    private void checkFieldText(String mainService, String expectedSecondPlaceholder, String expectedSumPlaceholder, String expectedEmailPlaceholder) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__header")));
        dropdownButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select__list")));

        List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".select__item .select__option")));

        for (WebElement item : listItems) {
            if (mainService.equals(item.getText())) {
                item.click();
                break;
            }
        }

        String secondPlaceholder = null;
        String sumPlaceholder = null;
        String emailPlaceholder = null;

        switch (mainService) {
            case "Услуги связи":
                secondPlaceholder = "#connection-phone";
                sumPlaceholder = "#connection-sum";
                emailPlaceholder = "#connection-email";
                break;
            case "Домашний интернет":
                secondPlaceholder = "#internet-phone";
                sumPlaceholder = "#internet-sum";
                emailPlaceholder = "#internet-email";
                break;
            case "Рассрочка":
                secondPlaceholder = "#score-instalment";
                sumPlaceholder = "#instalment-sum";
                emailPlaceholder = "#instalment-email";
                break;
            case "Задолженность":
                secondPlaceholder = "#score-arrears";
                sumPlaceholder = "#arrears-sum";
                emailPlaceholder = "#arrears-email";
                break;
        }

        WebElement secondFieldInFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(secondPlaceholder)));
        String actualSecondPlaceholder = secondFieldInFrame.getAttribute("placeholder");
        assertEquals(expectedSecondPlaceholder, actualSecondPlaceholder);

        WebElement sumFieldInFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sumPlaceholder)));
        String actualSumPlaceholder = sumFieldInFrame.getAttribute("placeholder");
        assertEquals(expectedSumPlaceholder, actualSumPlaceholder);

        WebElement emailFieldInFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(emailPlaceholder)));
        String actualEmailPlaceholder = emailFieldInFrame.getAttribute("placeholder");
        assertEquals(expectedEmailPlaceholder, actualEmailPlaceholder);
    }

    @Test
    @DisplayName("Проверка процесса оплаты услуг")
    @Description("Проверить процесс оплаты для услуги 'Услуги связи'.")
    public void testServicePaymentProcess() {
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__header")));
        dropdownButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select__list")));

        List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".select__item .select__option")));

        for (WebElement item : listItems) {
            if ("Услуги связи".equals(item.getText())) {
                item.click();
                break;
            }
        }
        processPaymentForServices("297777777", "100");
    }

    @Step("Обработка платежа для телефона: {phone} с суммой: {amount}")
    private void processPaymentForServices(String phone, String amount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#connection-phone")));
        phoneField.sendKeys(phone);

        WebElement sumField = driver.findElement(By.cssSelector("#connection-sum"));
        sumField.sendKeys(amount);

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        assertTrue(continueButton.isEnabled());
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("body > div.bepaid-app > div > iframe")));

        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__cost > span:nth-child(1)")));
        assertEquals(amount + ".00 BYN", amountField.getText());
        WebElement amountFieldButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")));
        assertEquals("Оплатить " + amount + ".00 BYN", amountFieldButton.getText());
        WebElement phoneFieldInFrame = driver.findElement(By.xpath("//span[contains(text(), '" + phone + "')]"));
        assertEquals("Оплата: Услуги связи Номер:375" + phone, phoneFieldInFrame.getText());

        WebElement cardNumberField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]"));
        assertTrue(cardNumberField.getText().contains("Номер карты"));

        WebElement cardExpiryField = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.expires-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-4 > label"));
        assertTrue(cardExpiryField.getText().contains("Срок действия"));

        WebElement cardCvcField = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.cvc-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-5 > label"));
        assertTrue(cardCvcField.getText().contains("CVC"));

        WebElement paymentIcons = driver.findElement(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(1) > app-input > div > div > div.icons-container.ng-tns-c46-1 > div > div"));
        assertTrue(paymentIcons.isDisplayed());

        driver.switchTo().defaultContent();
    }
}