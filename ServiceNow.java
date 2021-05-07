package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://dev111627.service-now.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementByXPath("//button[text()='Login']").click();
		driver.findElementByXPath("//input[@id='filter']").sendKeys("incident",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElementById("sysverb_new").click();
		driver.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handlelist=new ArrayList<String>(windowHandles);
		System.out.println(handlelist);
		
		String secondshandle=handlelist.get(1);
		driver.switchTo().window(secondshandle);
		driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[2]").click();
		
		String firsthandle=handlelist.get(0);
		driver.switchTo().window(firsthandle);
		
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("New employee hire");

		String incident = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
		System.out.println(incident);
		
		driver.findElement(By.xpath("//button[@name='not_important']")).click();
		driver.findElementByXPath("//select[@class='form-control default-focus-outline']").sendKeys("Number");
		driver.findElementByXPath("//input[@class='form-control'][1]").sendKeys(incident,Keys.ENTER);
		String incident1=driver.findElementByXPath("//a[@class='linked formlink']").getText();
		System.out.println(incident1);
		
		if(incident.equals(incident1))
		{
			System.out.println("This is Verified");
		}else	
		{
			System.out.println("Not Verified");
		}
		driver.close();
		}
		
		
	}

