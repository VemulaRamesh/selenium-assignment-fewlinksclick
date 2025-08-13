package assignments;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserLaunch {
	
	public static void main(String[] args) {
		
		System.out.println("Choose the browser to launch: ");
		Scanner input=new Scanner(System.in);
		String browsername=input.next();
		WebDriver driver;
		
		switch (browsername) {
		
		case "chrome":
		    driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default :
			System.out.println("enter correct browser");
			
		}	
	}
}


		
	
	
		
		
		
		
		
		
		
	
			
	
