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

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class upLoadFile {

    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/file_input.html");
    }


@Test
public void successFullOutForm () throws InterruptedException {
    WebElement firstName = driver.findElement(By.cssSelector("[placeholder = 'Enter first name']"));
    firstName.sendKeys("Mark");
    WebElement lastName = driver.findElement(By.cssSelector("[placeholder = 'Enter last name']"));
    lastName.sendKeys("Shagal");
    WebElement email = driver.findElement(By.cssSelector("[placeholder = 'Enter email']"));
    email.sendKeys("rtyujhb@gkld.com");
    WebElement uploadFile = driver.findElement(By.id("file"));
    uploadFile.sendKeys("/Users/inna/Desktop/Ewidencja sprzedaży bezrachunkowej - wzór .doc");
    WebElement submitButton = driver.findElement(By.tagName("button"));
    submitButton.click();
    WebDriverWait waitingTime = new WebDriverWait(driver,Duration.ofSeconds(20));
    Alert alert = waitingTime.until(ExpectedConditions.alertIsPresent());
    assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    sleep (5000);


}









    @After
    public void tearDow() {
        driver.quit();
    }

}



