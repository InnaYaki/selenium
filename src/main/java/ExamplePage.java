import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;

public class ExamplePage {

    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://crossbrowsertesting.github.io/selenium_example_page.html");
    }

@Test
    public  void listElementAreDisplayed () throws InterruptedException {
        WebElement list = driver.findElement (By.id("list-test"));
        List<WebElement> listElements = driver.findElements (By.xpath("//ul[@class='list']//li"));
        assertEquals (4,listElements.size());
        sleep(2000);


    }






    @After
    public void tearDow() {
        driver.quit();
    }

}
