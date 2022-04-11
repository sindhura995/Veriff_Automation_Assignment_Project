package pkg;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test_class {
public static void main(String[] args) throws InterruptedException {
	

	System.setProperty("webdriver.chrome.driver", "E:\\veriff\\auto\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.saas-3.veriff.me");
    Thread.sleep(5000);

    //TO VERIFY THE NAME IN TEXTBOX
    WebElement wb = driver.findElement(By.name("name"));
    String string_name = wb.getAttribute("value");
    System.out.println(string_name);
    
    //TO SELECT A LANGUAGE FROM A DROPDOWN
    WebElement wb1 = driver.findElement(By.name("language"));
    wb1.click();
    String searchText = "English";
    WebElement dropdown = driver.findElement(By.id("downshift-0-menu"));
    List<WebElement> options = dropdown.findElements(By.tagName("li"));
    for (WebElement option : options)
    {
        if (option.getText().equals(searchText))
        {
            option.click(); // click the desired option
            break;
        }
    }
    
    // TO INPUT DATA AND VERIFY IF COUNTRY IS IN DROPDOWN
    WebElement wb2 = driver.findElement(By.name("documentCountry"));
    wb2.click();
    wb2.sendKeys("India");
    Thread.sleep(5000);
    String searchCountry = "India";
    Actions act = new Actions(driver);
    WebElement dropdown1 = driver.findElement(By.id("downshift-1-menu"));
    List<WebElement> options1 = dropdown1.findElements(By.tagName("li"));
    for (WebElement option : options1)
    {
        if (option.getText().equals(searchCountry))
        {
            act.doubleClick(option).perform(); // click the desired option
            break;
        }
    }
  
   // TO SELECT DOCUMENT TYPE IN DROPDOWN
    WebElement wb3 = driver.findElement(By.name("documentType"));
    wb3.click();
    Thread.sleep(5000);
    String searchDocument = "Residence Permit";
    WebElement dropdown2 = driver.findElement(By.id("downshift-2-menu"));
    List<WebElement> options2 = dropdown2.findElements(By.tagName("li"));
    for (WebElement option : options2)
    {
        if (option.getText().equals(searchDocument))
        {
            option.click(); // click the desired option
            break;
        }
    }
    //TO CHECK LAUNCH BUTTONS
    WebElement wb4 = driver.findElement(By.xpath("//span[text()='Redirect']"));
    wb4.click();
    Thread.sleep(3000);
    WebElement wb5 = driver.findElement(By.xpath("//button[@type='submit']"));
    wb5.click();
    Thread.sleep(3000);
    /*String context_title = driver.getTitle();
    System.out.println(context_title);
    Thread.sleep(3000);
    driver.switchTo().defaultContent();*/
    
    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
    //switch to new tab
    driver.switchTo().window(newTb.get(0));
    System.out.println("Page title of new tab: " + driver.getTitle());
    
    //IF DOCUMENT IS INVALID WE GET AN ALERT MESSAGE
    Thread.sleep(10000);
    WebElement wb6 = driver.findElement(By.xpath("//p[@class='Banner-module_text__2WoMt']"));
    String alert_msg = wb6.getText();
    System.out.println(alert_msg);
    
    
}
}