package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctcAss {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//button[@type='submit']").click();
		driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> handleList = new ArrayList<String>(windowHandles);
		String secondHandle = handleList.get(1);
		driver.switchTo().window(secondHandle);
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		
		driver.findElementByXPath("//button[text()='Ok']").click();
	}

}
