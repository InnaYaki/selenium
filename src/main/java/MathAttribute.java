import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.tagName;

public class MathAttribute {

    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/get_attribute.html");
    }

    public double funcCalc (double x) {
        return log(abs (12*sin(x)));
    }

    @Test

    public void validAnswer () throws InterruptedException {

        WebElement treasure = driver.findElement(By.id("treasure"));



        double xValue = parseDouble (treasure.getAttribute("valuex"));
        double result = funcCalc(xValue);

        WebElement answerInputField = driver.findElement(By.id ("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        sleep (10000);
    }

    @Test
    public void inputFields3 () throws InterruptedException {
        WebElement x = driver.findElement(By.id ("input_value"));
        double xValue = parseDouble (x.getText());
        double result = funcCalc(xValue);
        WebElement answerInputField = driver.findElement(By.id ("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        WebElement checkbox = driver.findElement(By.id ("robotCheckbox"));

        WebElement submit = driver.findElement(tagName("button"));
        WebElement robotsRule = (WebElement) driver.findElements(By.id("robotsRule"));
        checkbox.sendKeys("form-check -input");

        submit.click();

        sleep (5000);


    }





    @After
    public void tearDow() {
        driver.quit();
    }
}
