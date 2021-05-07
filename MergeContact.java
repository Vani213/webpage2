package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement username=driver.findElementByXPath("//input[@id='username']");
		username.sendKeys("Demosalesmanager");
		WebElement password=driver.findElementByXPath("//input[@id='password']");
		password.sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> target = new ArrayList<String>(windows);
		driver.switchTo().window(target.get(1));
		Thread.sleep(2000);
		driver.findElementByXPath("//table//tr//td[1]//a[@class='linktext'][1]").click();
		driver.switchTo().window(target.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windows2 = driver.getWindowHandles();
		List<String> target2 = new ArrayList<String>(windows2);
		driver.switchTo().window(target2.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//table//tr//td[1]//a[@class='linktext'])[2]")).click();
		driver.switchTo().window(target2.get(0));
		Thread.sleep(2000);
		driver.findElementByLinkText("Merge").click();
		
		driver.switchTo().alert().accept();
		String text = driver.getTitle();
		System.out.println(text);
		driver.close();
		
	}

}
