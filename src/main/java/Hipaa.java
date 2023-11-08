import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class Hipaa {
    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.insidetracker.com/");
    }

   @Test
    public  void checkHeaderText (){
       WebElement hipaaButton = driver.findElement(By.id("HIPAA"));
       hipaaButton.click();
       ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(handles.get(1));
       WebElement headerHipaa = driver.findElement(By.id("hs_cos_wrapper_name"));
       assertTrue(headerHipaa.getText().contains("HIPAA"));
    }
    @Test
    public void checkHeaderText2 (){
        WebElement hipaaButton = driver.findElement(By.id("HIPAA"));
        hipaaButton.click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        WebElement headerHipaa = driver.findElement(By.id("hs_cos_wrapper_name"));
        assertTrue(headerHipaa.getText().contains("HIPAA"));
        assertTrue(driver.getCurrentUrl().contains("hipaa-compliant"));

    }




    @After
    public void tearDow() {
        driver.quit();
    }

}
