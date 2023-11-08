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



import static org.junit.Assert.*;

import static org.openqa.selenium.By.xpath;

public class RegistrationAlert {



        ChromeDriver driver;
        @Before

        public void SetUp(){
            System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("http://suninjuly.github.io/simple_form_find_task.html");
        }



        @Test
        public void inputAllFields2 ()  {

            WebElement firstName =
                    driver.findElement(xpath("//input [@name='first_name']"));
            WebElement lastName =
                    driver.findElement(xpath("//input [@name='last_name']"));
            WebElement city =
                    driver.findElement(xpath("//input[@class='form-control city']"));
            WebElement country =
                    driver.findElement(xpath("//input[@id='country']"));


            firstName.sendKeys("Mark");
            lastName.sendKeys("Shagal");
            country.sendKeys("Finland");
            city.sendKeys("Helsinki");
            WebElement submit = driver.findElement(By.id("submit_button"));

            submit.click();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

        }


    @Test
    public void inputAllFieldsNegative2 () throws InterruptedException {

        WebElement firstName =
                driver.findElement(xpath("//input [@name='first_name']"));
        WebElement lastName =
                driver.findElement(xpath("//input [@name='last_name']"));
        WebElement city =
                driver.findElement(xpath("//input[@class='form-control city']"));
        firstName.sendKeys("Mark");
        lastName.sendKeys("Shagal");
        city.sendKeys("Helsinki");
        WebElement submit = driver.findElement(By.id("submit_button"));
        assertTrue("disabled",submit.isEnabled());





    }




    @After
        public void tearDow() {
            driver.quit();
        }


    }













