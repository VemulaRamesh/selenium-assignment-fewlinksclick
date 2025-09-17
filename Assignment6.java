package assignments;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void frameHandlingTest()
	{
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
		driver.switchTo().defaultContent();
		
		Set<String> allWindowIds=driver.getWindowHandles();
		
		for(String windowId:allWindowIds)
		{
			driver.switchTo().window(windowId);
			
			if(driver.getTitle().equals("Selenium Live Project for Practice"))
			{
				break;
			}
		}
		
		/*System.out.println(driver.findElement(By.xpath("//span[text()='Python']")).getText()); 
		System.out.println(driver.findElement(By.xpath("(//span[text()='Testing'])[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[text()='Hacking']")).getText());
		System.out.println(driver.findElement(By.xpath("(//span[text()='SAP'])[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[text()='Java']")).getText()); 
		System.out.println(driver.findElement(By.xpath("//span[text()='Selenium']")).getText());
		*/
			
		List<WebElement> allTopTutorials=driver.findElements(By.xpath("//p[text()='Top Tutorials']/ancestor::div[contains(@class,'wp-block-kadence-column')][1]/descendant::span[@class='kt-blocks-info-box-title']"));
		
		for(int i=0; i<allTopTutorials.size(); i++)
		{
			System.out.println(allTopTutorials.get(i).getText());
		}
		
		/*
		List<WebElement> allTopTutorials=driver.findElements(By.xpath("//p[text()='Top Tutorials']/ancestor::div[contains(@class,'wp-block-kadence-column')][1]/descendant::span[@class='kt-blocks-info-box-title']"));
		
		for(WebElement allText:allTopTutorials)
		{
			System.out.println(allText.getText());
		}
		*/
		
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
