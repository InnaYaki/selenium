import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.tagName;

public class DropDown {

    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/selects2.html");
    }
@Test
public void correctSum(){
    WebElement num1 = driver.findElement(By.id("num1"));
    WebElement num2 = driver.findElement(By.id("num2"));

     int result = 0;
     int a = Integer.parseInt(num1.getText());
     int b = Integer.parseInt(num2.getText());
     result = a+b;
    WebElement dropDown = driver.findElement(By.id ("dropdown"));
    dropDown.click();
    WebElement answerInputField = driver.findElement(By.cssSelector("[value ='"+ result +"']"));


    WebElement submit = driver.findElement(tagName("button"));
    submit.click();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


}





    @After
    public void tearDow() {
        driver.quit();
    }

}
