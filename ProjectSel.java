package Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class ProjectSel {



    @Test

    void checkEmptyLoginField() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("Haslo123");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface:Username is required", errorBox.getText());
        driver.quit();

    }

    @Test
    void checkEmptyPasswordField()  {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        loginInput.sendKeys("loginTest");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface:Password is required", errorBox.getText());
        driver.quit();
    }


    @Test
    void checkLogoFiled() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//img[@class = 'logo img-responsive']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("search_query_top")).isDisplayed());
        driver.quit();

    }

    @Test
    void homePageToContactPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.id("contact-link")).click();
        driver.findElement(By.xpath("//a[@title = 'Contact us']")).isDisplayed();
        Assertions.assertTrue(driver.findElement(By.id("Contact us")).isDisplayed());
        driver.quit();

    }

    @Test
    void loginPageToMainPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("img-responsive")).click();
        Assertions.assertTrue(driver.findElement(By.id("Main Page")).isDisplayed());
        driver.quit();
    }

    @Test
    void productAddToCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        emailInput.sendKeys("standard_user");
        submitButton.click();
        Assertions.assertTrue(driver.findElement(By.id("Password is required")).isDisplayed());
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface:Username is required", errorBox.getText());
        WebElement ProductAddToCart = driver.findElement(By.cssSelector("add-to-cart-sauce-labs-onesie"));
        ProductAddToCart.click();
        Assertions.assertTrue(driver.findElement(By.id("sauce-lab-onesie-has-been-added-to-cart")).isDisplayed());
        driver.quit();

    }


    static WebDriver driver;


        @BeforeAll

        static void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\bin\\chromedriver.exe");
            driver= new ChromeDriver();

        }

        @AfterAll
        static void afterTests () {
            driver.quit();
        }

        @Test
        void removeProductToCartWithImplicitWait() {

            driver.get("https://www.saucedemo.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement removeProductToCart = driver.findElement(By.cssSelector("remove-to-cart-sauce-labs-onesie"));
            removeProductToCart.click();
            Assertions.assertTrue(driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed());
            driver.quit();

    }
}
