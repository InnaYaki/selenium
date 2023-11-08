import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Hover {
    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://crossbrowsertesting.github.io/hover-menu.html#");
    }
@Test
public void hoverTest () throws InterruptedException {
    WebElement dropDown = driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]"));
    Actions actions = new Actions(driver);
    actions.moveToElement(dropDown).perform();
    WebElement secondaryMenu = driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[2]"));
    actions.moveToElement(secondaryMenu).perform();
    WebElement secondaryAction = driver.findElement(By.xpath("//a[@onclick ='handleSecondaryAction()']"));
    secondaryAction.click();
    WebElement SecondaryPage = driver.findElement(By.xpath("//div[@class='jumbotron secondary-clicked']/h1"));
    assertEquals ("Secondary Page",SecondaryPage.getText());
    sleep (5000);
}




    @After
    public void tearDow() {
        driver.quit();
    }
}
