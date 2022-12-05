package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.Console;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {
    WebDriver driver=new ChromeDriver();

    @BeforeEach
    void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Disabled
    @BeforeAll
    public static void setup(){
        String projectPath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectPath+"/chromedriver");
    }

    @Test
    void checkProsSite() throws InterruptedException {
        driver.get("https://pros.unicam.it/");

        Thread.sleep(3000);

        String at = driver.getTitle();
        String et = "PROS - PROcesses & Services lab | Computer Science division @Unicam";

        Thread.sleep(4000);

        assertEquals(et,at);
        driver.close();
        driver.quit();
    }

    @Test
    void checkProsSiteSearch() throws InterruptedException {
        driver.get("http://pros.unicam.it");

        Thread.sleep(2000);

        driver.findElement(By.className("toggle-search")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("search")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("search")).sendKeys("bprove");
        Thread.sleep(2000);

        driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        System.out.println(driver.findElements(By.className("type-portfolio-title")));

        driver.close();
        driver.quit();

    }

    @Test
    void checkTitleTomCatSite() throws InterruptedException {
        driver.get("http://localhost:8080/SPM_webapp/");

        Thread.sleep(3000);

        String at = driver.getTitle();
        String et = "SPM Lab Lecture";

        Thread.sleep(4000);

        assertEquals(et,at);
        driver.close();
        driver.quit();
    }
}
