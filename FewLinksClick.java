package assignments;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FewLinksClick {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void fewLinksTest() throws InterruptedException
	{
		Thread.sleep(3000);
		try
		{
			driver.findElement(By.xpath("(//*[local-name()='svg'])[2]")).click();
		}
		catch(Exception e)
		{
			
		}
		
		List<WebElement> fewLinks=driver.findElements(By.xpath("//p[text()='Partner With Us']/parent::div/descendant::div"));
		System.out.println(fewLinks.size());
		
		Actions action=new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//p[text()='Partner With Us']")))
		          .pause(2000)
		          .build()
		          .perform();
		
		for(int i=0; i<fewLinks.size(); i++)
		{
			WebElement link=fewLinks.get(i);
			Thread.sleep(3000);
			link.click();
		}
		
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
