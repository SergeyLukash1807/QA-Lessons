package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class mtsby {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.diver", "src/main/resources/chromedriver-win64");
        WebDriver driver = new ChromeDriver();


        try {
            // Открытие веб-сайта
            driver.get("https://mts.by");

            // Закрытие всплывающего окна cookie, если оно присутствует
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.layout.layout--default > main > div > div.cookie.show > div > div.cookie__buttons > button.btn.btn_gray.cookie__cancel")));
                cookieBanner.click();
            } catch (Exception e) {
                System.out.println("Cookie banner not found or not visible.");
            }

            // Задание 1: Проверить название указанного блока
            WebElement blockTitle = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2"));
            assert blockTitle.getText().equals("Онлайн пополнение без комиссии");

            // Задание 2: Проверить наличие логотипов платёжных систем
            List<String> paymentSystems = List.of("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(1) > img",
                    "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(2)",
                    "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(3)",
                    "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(4)",
                    "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(5)");
            for (String logo : paymentSystems) {
                WebElement logoElement = driver.findElement(By.cssSelector(logo));
                assert logoElement.isDisplayed();
            }

            // Задание 3: Проверить работу ссылки "Подробнее о сервисе"
            WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
            assert moreInfoLink.isDisplayed();
            moreInfoLink.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Порядок оплаты и безопасность интернет платежей"));
            driver.navigate().back();


            // Задание 4: Заполнить поля и проверить работу кнопки "Продолжить"
            WebElement phone = driver.findElement(By.cssSelector("#connection-phone"));
            phone.sendKeys("297777777");
            WebElement sum = driver.findElement(By.cssSelector("#connection-sum"));
            sum.sendKeys("100");
            WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
            assert continueButton.isEnabled();
            continueButton.click();


        } finally {
            // Закрытие WebDriver
            driver.quit();
        }
    }
}