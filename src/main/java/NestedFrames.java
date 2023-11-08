import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NestedFrames {
    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/nestedframes");
    }
@Test
public void NestedFrame () {


    driver.switchTo().frame("frame1");
    WebElement parent = driver.findElement(By.tagName("body"));
    //System.out.println(parent.getText());
    assertEquals("Parent frame",parent.getText());

    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
    driver.switchTo().frame(iframes.get(0));
    WebElement child = driver.findElement(By.tagName("p"));
    //System.out.println(driver.findElement(By.tagName("p")));
    assertEquals("Child Iframe",child.getText());

}




    @After
    public void tearDow() {
        driver.quit();
    }

}
