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
import static org.junit.Assert.assertTrue;


public class Cats {
    ChromeDriver driver;
    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/cats.html");
    }



@Test
    public  void checkHeaderText () {

        WebElement header = driver.findElement(By.className("jumbotron-heading"));
        String expectedText = "Cat memes";
        assertEquals ("Header text is not expected",expectedText,header.getText());

    }
@Test
    public void timeOfLastCat() {

        WebElement timeValueOfLastCat = driver.findElement( By.xpath("//div[@class='col-sm-4'][6]//small[@class='text-muted']"));
        assertEquals("9 mins",timeValueOfLastCat.getText() );

    }

@Test
    public void checkCatsCardsQuantity(){

        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        assertEquals(6,cards.size());

    }
@Test
    public void checkCatsCardsNameTwo (){
        WebElement name = driver.findElement(By.xpath("//div[@class='col-sm-4'][2]//p[@class='card-text second']"));
        assertEquals("Serious cat",name.getText() );
    }

@Test
      public void editButtonSecondCardsIsDisplayed (){
        WebElement editButtonSecondCat = driver.findElement(By.xpath("//div[@class='col-sm-4'][2]//button[@class='btn btn-sm btn-outline-secondary'][2]"));
          assertTrue(editButtonSecondCat.isDisplayed());
      }
@Test
      public void displayedCatsAlbum (){
         WebElement catsAlbum = driver.findElement(By.tagName("strong"));
          assertTrue(catsAlbum.isDisplayed());
          assertEquals("Cats album",catsAlbum.getText());

    }

    @Test
    public void allCardsAreDisplayed (){
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        for (WebElement card:
             cards ) {
            assertTrue(card.isDisplayed());
            
        }
    }

@After
public void tearDown(){
        driver.quit();
}


}









