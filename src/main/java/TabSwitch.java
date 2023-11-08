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

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.tagName;

public class TabSwitch {
    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/redirect_accept.html");
    }


    @Test
    public void switchToSecondTab () throws InterruptedException {
        WebElement redirectButton = driver.findElement(By.tagName("button"));
        redirectButton.click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));

        //sleep (5000);
        WebElement x = driver.findElement(By.id("input_value"));
        double xValue = parseDouble(x.getText());
        //double result = funcCalc(xValue);
        WebElement answerInputField = driver.findElement(By.id("answer"));
        //answerInputField.sendKeys(String.valueOf(result));
        WebElement submitbutton = driver.findElement(By.tagName("button"));
        submitbutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }





    @After
    public void tearDow() {
        driver.quit();
    }


}


