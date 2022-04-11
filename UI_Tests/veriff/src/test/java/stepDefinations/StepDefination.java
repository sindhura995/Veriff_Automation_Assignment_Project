package stepDefinations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefination {
	

	private static WebDriver driver;
	Boolean alert;
	
	@Given("User selects a {string} {string} {string} {string} from respective dropdowns")
	public void user_selects_a_from_respective_dropdowns(String Language, String Country, String Document_type, String Launch_type) throws InterruptedException {
		//Initial Configuration Settings
		System.setProperty("webdriver.chrome.driver", "E:\\veriff\\auto\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.saas-3.veriff.me");
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Let's verify the name which is already typed in the box
     	WebElement wb = driver.findElement(By.name("name"));
   	    String string_name = wb.getAttribute("value");
   	    System.out.println(string_name);
   	
       //TO SELECT A LANGUAGE FROM A DROPDOWN
   	    WebElement wb1 = driver.findElement(By.name("language"));
   	    wb1.click();
   	    WebElement dropdown = driver.findElement(By.id("downshift-0-menu"));
   	    List<WebElement> options = dropdown.findElements(By.tagName("li"));
   	    for (WebElement option : options)
   	    {
   	        if (option.getText().equals(Language))
   	        {
   	            option.click(); // click the desired option
   	            break;
   	        }
   	    } 
   	    
   	 // TO INPUT DATA AND VERIFY IF COUNTRY IS IN DROPDOWN
	    WebElement wb2 = driver.findElement(By.name("documentCountry"));
	    wb2.click();
	    Thread.sleep(7000);
	    wb2.sendKeys(Country);
	    Actions act = new Actions(driver);
	    WebElement dropdown1 = driver.findElement(By.id("downshift-1-menu"));
	    List<WebElement> options1 = dropdown1.findElements(By.tagName("li"));
	    for (WebElement option : options1)
	    {
	        if (option.getText().equals(Country))
	        {
	            act.doubleClick(option).perform(); // click the desired option
	            break;
	        }
	    }
	    
	    
	    // TO SELECT DOCUMENT TYPE IN DROPDOWN
	    Thread.sleep(3000);
	    WebElement wb3 = driver.findElement(By.name("documentType"));
	    wb3.click();
	    System.out.println("Button clicked");
	    WebElement dropdown2 = driver.findElement(By.id("downshift-2-menu"));
	    List<WebElement> options2 = dropdown2.findElements(By.tagName("li"));
	    for (WebElement option : options2)
	    {
	        if (option.getText().equals(Document_type))
	        {
	            option.click();// click the desired option
	            break;
	        }
	    }
	    
	    
	    //TO CHECK LAUNCH BUTTONS
	    WebElement wb4 = driver.findElement(By.xpath("//span[text()=\'"+Launch_type+"']"));
	    wb4.click();
	    Thread.sleep(3000);
	    WebElement wb5 = driver.findElement(By.xpath("//button[@type='submit']"));
	    wb5.click();
	    Thread.sleep(3000);
	}

	@When("If the selected document is valid")
	public void if_the_selected_document_is_valid() {
		 
	    // Write code here that turns the phrase above into concrete actions
		try {
  		  //  Block of code to try
  		Thread.sleep(10000);
  	    WebElement wb6 = driver.findElement(By.xpath("//p[@class='Banner-module_text__2WoMt']"));
  	    String alert_msg = wb6.getText();
  	    System.out.println(alert_msg + " " + "The document is invalid");
  	    alert = true;
  		}
  		catch(Exception e) {
  		  //  Block of code to handle errors
  			System.out.println("The document is valid ");
  		}
	}

	@Then("the user is navigated to veriff's Home page")
	public void the_user_is_navigated_to_veriff_s_home_page() {
	    // To check if alert is present
		if(alert == true)
		{
  			System.out.println("Status code 400 generated, please select a valid document type");
		}
		else
		{
			System.out.println("Successfully logged in as a user!!!");
		}
	}

	}

