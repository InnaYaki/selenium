import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.*;

public class Registration {

    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/registration1.html");
}

@Test
public  void checkRegistrationText () {
    WebElement header = driver.findElement(tagName("h1"));
    assertEquals("Registration",header.getText());

}


    @Test
    public void inputAllFields1 ()  {
        WebElement inputFirstName =
                driver.findElement(xpath("//input[@placeholder='Input your first name']"));
        WebElement inputLastName =
                driver.findElement(xpath("//input[@placeholder='Input your last name']"));
        WebElement inputYourEmail =
                driver.findElement(xpath("//input[@placeholder='Input your email']"));
        WebElement inputYourPhone =
                driver.findElement(xpath("//input[@placeholder='Input your phone:']"));
        WebElement inputYourAddress =
                driver.findElement(xpath("//input[@placeholder='Input your address:']"));
        WebElement submit =
                driver.findElement(tagName("button"));
        inputFirstName.sendKeys("Mark");
        inputLastName.sendKeys("Shagal");
        inputYourEmail.sendKeys( "erty@gmail.com");
        inputYourPhone.sendKeys("+ 54 8976544");
        inputYourAddress.sendKeys( "Solidarnosti,45");
        submit.click();
        //sleep (10000);
        WebElement header = driver.findElement(tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                header.getText());

    }


    @Test
    public void inputAllFieldsNegative () throws InterruptedException {
        WebElement inputFirstName =
                driver.findElement(xpath("//input[@placeholder='Input your first name']"));
        WebElement inputLastName =
                driver.findElement(xpath("//input[@placeholder='Input your last name']"));
        WebElement inputYourEmail =
                driver.findElement(xpath("//input[@placeholder='Input your email']"));
        WebElement inputYourPhone =
                driver.findElement(xpath("//input[@placeholder='Input your phone:']"));
        WebElement inputYourAddress =
                driver.findElement(xpath("//input[@placeholder='Input your address:']"));
        WebElement submit =
                driver.findElement(tagName("button"));
        inputFirstName.sendKeys("Mark");
        inputLastName.sendKeys("");
        inputYourEmail.sendKeys( "erty@gmail.com");
        inputYourPhone.sendKeys("+ 54 8976544");
        inputYourAddress.sendKeys( "Solidarnosti,45");
        submit.click();
        sleep (2000);
        WebElement header = driver.findElement(tagName("h1"));
        String text = "Congratulations! You have successfully registered!";
        assertNotEquals("Failed",text,header.getText());

    }



    @Test
    public void inputAllFields ()  {
        WebElement inputFirstName =
                driver.findElement(xpath("//input[@placeholder='Input your first name']"));

        WebElement inputYourEmail =
                driver.findElement(xpath("//input[@placeholder='Input your email']"));
        WebElement inputYourPhone =
                driver.findElement(xpath("//input[@placeholder='Input your phone:']"));
        WebElement inputYourAddress =
                driver.findElement(xpath("//input[@placeholder='Input your address:']"));
        WebElement submit =
                driver.findElement(tagName("button"));
        inputFirstName.sendKeys("Mark");

        inputYourEmail.sendKeys( "erty@gmail.com");
        inputYourPhone.sendKeys("+ 54 8976544");
        inputYourAddress.sendKeys( "Solidarnosti,45");
        submit.click();
        //sleep (10000);
        WebElement header = driver.findElement(tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                header.getText());

    }


    @After
    public void tearDow() {
        driver.quit();
    }


}
















