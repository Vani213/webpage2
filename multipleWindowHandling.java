package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multipleWindowHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			
		driver.findElementById("home").click();
		String title = driver.getTitle();
		System.out.println(title);
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String eachHandle : windowHandles) {
			
			System.out.println(eachHandle);
		}
		
	List<String> handleList = new ArrayList<String>(windowHandles);
	
	String secondHandle = handleList.get(1);
	
	//to switch control to second window
	driver.switchTo().window(secondHandle);
	String title2 = driver.getTitle();
	System.out.println(title2);
	
	driver.quit();//to close both window
	}

}
