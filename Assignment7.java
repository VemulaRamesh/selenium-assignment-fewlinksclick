package assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void alertHandlingTest() throws InterruptedException
	{
		//click for Js alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert=driver.switchTo().alert();
		String actualJsAlertText=alert.getText();
		Assert.assertEquals(actualJsAlertText,"I am a JS Alert");
		alert.accept();
		
		//click for Js confirm
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert=driver.switchTo().alert();
		String actualJsConfirmAlertText=alert.getText();
		Assert.assertEquals(actualJsConfirmAlertText,"I am a JS Confirm");
		alert.dismiss();
		
		//click for Js prompt
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		alert=driver.switchTo().alert();
		String actualJsPromptAlertText=alert.getText();
		Assert.assertEquals(actualJsPromptAlertText,"I am a JS prompt");
		alert.sendKeys("selenium");
		alert.accept();
		String actualResultText=alert.getText();
		Assert.assertEquals(actualResultText,"You entered: selenium");
		Thread.sleep(2000);
		
		//System.out.println(alert.getText());
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
