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

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.tagName;

public class Huge {
    ChromeDriver driver;

    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/huge_form.html");
    }


    @Test
    public void allFields (){

        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        for (WebElement inputField:
                inputFields) {
             inputField.sendKeys("hello");}
        WebElement submit =
                driver.findElement(tagName("button"));
        submit.click();
        WebDriverWait waitingTime = new WebDriverWait(driver,Duration.ofSeconds(20));
        Alert alert = waitingTime.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }
@Test
    public void emptyInputFields(){
        WebElement submit = driver.findElement(tagName("button"));
        submit.click();
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        System.out.println(inputFields.get(0).getAttribute("validationMessage"));
        assertEquals("Заполните это поле.",inputFields.get(0).getAttribute("validationMessage"));
    }











    @After
    public void tearDow() {
        driver.quit();
    }

}
