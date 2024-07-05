package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class mtsbyTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        driver.get("https://mts.by");

        // Закрытие всплывающего окна cookie, если оно присутствует
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.layout.layout--default > main > div > div.cookie.show > div > div.cookie__buttons > button.btn.btn_gray.cookie__cancel")));
            cookieBanner.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or not visible.");
        }

        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2")));
        String actualText = blockTitle.getText();
        String expectedText = "Онлайн пополнение\nбез комиссии";

        assertEquals(expectedText, actualText, "Block title does not match expected text.");

    }

    @Test
    public void testPaymentSystemsLogos() {
        driver.get("https://mts.by");

        // Закрытие всплывающего окна cookie, если оно присутствует
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.layout.layout--default > main > div > div.cookie.show > div > div.cookie__buttons > button.btn.btn_gray.cookie__cancel")));
            cookieBanner.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or not visible.");
        }

        List<String> paymentSystems = List.of(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(1) > img",
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(2)",
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(3)",
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(4)",
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(5)");

        for (String logo : paymentSystems) {
            WebElement logoElement = driver.findElement(By.cssSelector(logo));
            assertTrue(logoElement.isDisplayed(), "Payment system logo is not displayed.");
        }
    }

    @Test
    public void testMoreInfoLink() {
        driver.get("https://mts.by");

        // Закрытие всплывающего окна cookie, если оно присутствует
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.layout.layout--default > main > div > div.cookie.show > div > div.cookie__buttons > button.btn.btn_gray.cookie__cancel")));
            cookieBanner.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or not visible.");
        }

        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertTrue(moreInfoLink.isDisplayed(), "More info link is not displayed.");
        moreInfoLink.click();

        wait.until(ExpectedConditions.titleContains("Порядок оплаты и безопасность интернет платежей"));
        assertEquals("Порядок оплаты и безопасность интернет платежей", driver.getTitle(), "Page title does not match expected.");
    }

    @Test
    public void testContinueButton() {
        driver.get("https://mts.by");

        // Закрытие всплывающего окна cookie, если оно присутствует
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.layout.layout--default > main > div > div.cookie.show > div > div.cookie__buttons > button.btn.btn_gray.cookie__cancel")));
            cookieBanner.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or not visible.");
        }

        WebElement phone = driver.findElement(By.cssSelector("#connection-phone"));
        phone.sendKeys("297777777");
        WebElement sum = driver.findElement(By.cssSelector("#connection-sum"));
        sum.sendKeys("100");
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        assertTrue(continueButton.isEnabled(), "Continue button is not enabled.");

        continueButton.click();

    }
}