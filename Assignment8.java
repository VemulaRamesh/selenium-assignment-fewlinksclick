package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment8 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void shadowDomTest()
	{
		
		WebElement shadowHost1=driver.findElement(By.cssSelector("hgf-c360nav"));
		SearchContext shadowRoot1=shadowHost1.getShadowRoot();

		WebElement shadowHost2=shadowRoot1.findElement(By.cssSelector("hgf-c360login[aria-haspopup]"));
		SearchContext shadowRoot2=shadowHost2.getShadowRoot();
		
		WebElement shadowHost3=shadowRoot2.findElement(By.cssSelector("hgf-button[aria-controls='login-unauth-content']"));
		SearchContext shadowRoot3=shadowHost3.getShadowRoot();
		WebElement login=shadowRoot3.findElement(By.cssSelector("button"));
		

		Actions action=new Actions(driver);
		action.moveToElement(login)
		          .pause(2000)
		          .moveToElement(shadowRoot2.findElement(By.cssSelector("a[data-tracking-stable='salesforceLogin']")))
		          .pause(2000)
		          .click()
		          .build()
		          .perform(); 

	}
	
	@AfterMethod
	public void tearDown()
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
