package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class assignment3 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void mouseHoverTest()
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Fashion']")))
		.perform();
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Women Ethnic']")))
		.pause(3000)
//		.click(driver.findElement(By.xpath("//a[text()='Women Sarees']")))
//		.build()
		.perform();
		
		driver.findElement(By.xpath("//a[text()='Women Sarees']")).click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		driver.quit();
	}

}
