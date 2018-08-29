package utils;

import au.com.bytecode.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author kumar on 29/08/18
 * @project X-search
 */
public class ImportData {

 private static String PATH_OF_FILE = "/Users/kumar/movie.csv";
  public static void main(String args[]){
    try{
      CSVReader reader = new CSVReader(new FileReader(PATH_OF_FILE));
      String [] csvCell;
      HashMap<String,String> hashMap = new HashMap();
      //while loop will be executed till the last line In CSV.
      while ((csvCell = reader.readNext()) != null) {
        String movieName = csvCell[0].split("\\.")[1].trim();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.co.in/");
        driver.findElement(By.id("lst-ib")).sendKeys("movie:"+movieName+" wikipedia");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
        WebElement webElement = driver.findElements(By.xpath("//*[contains (@href,'en.wikipedia.org/wiki/')]")).get(0);
        if(webElement !=null){
          webElement.click();
          hashMap.put(movieName,driver.getCurrentUrl());
        }
        else
          hashMap.put(movieName,"No url found");
        driver.close();
      }

      for (Map.Entry<String, String> entry : hashMap.entrySet()) {
        System.out.println(entry.getKey()+" : "+entry.getValue());
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
