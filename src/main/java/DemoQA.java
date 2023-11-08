import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;


public class DemoQA {
    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/upload-download");
    }
@Test
public void upLoadCheekSuccess () throws InterruptedException {
    WebElement ChooseFileButton = driver.findElement(By.id("uploadFile"));
    ChooseFileButton.sendKeys("/Users/inna/Desktop/Ewidencja sprzedaży bezrachunkowej - wzór .doc");
    WebElement fileName = driver.findElement(By.id("uploadedFilePath"));
    assertTrue (fileName.getText().contains("Ewidencja sprzedaży bezrachunkowej - wzór .doc"));
    sleep (10000);
}















    @After
    public void tearDow() {
        driver.quit();
    }





}
