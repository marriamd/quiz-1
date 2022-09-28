package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        exercise1();
    }

    public static void exercise1 () throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement elementButton = driver.findElement(By.cssSelector("#input-example > button[type=button]"));
        elementButton.click();

        Thread.sleep(5000);

        WebElement elementInput = driver.findElement(By.cssSelector("#input-example > input"));
        System.out.println("Is enabled: " + elementInput.isEnabled());

        WebElement elementText = driver.findElement(By.cssSelector("#message"));
        System.out.println("Text says it is: " + elementText.getText());

        System.out.println("Button text is: " + elementButton.getText());

        Thread.sleep(5000);

        System.out.println(elementInput.isEnabled());
        elementInput.sendKeys("Test Automation");
        Thread.sleep(5000);
        elementInput.clear();

        driver.quit();
    }
}
