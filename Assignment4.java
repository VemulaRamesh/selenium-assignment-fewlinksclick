package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment4 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void mouseHoverTest()
	{
		Actions action=new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[1]")),80,0)
		.build()
		.perform();
		
		action.dragAndDropBy(driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[2]")), 150, 0)
		.build()
		.perform();
		
		action.dragAndDropBy(driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[3]")),-110, 0)
		.build()
		.perform();
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
