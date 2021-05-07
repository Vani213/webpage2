package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignLens {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.lenskart.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		
		Actions action = new Actions(driver);
		WebElement menu = driver.findElementByXPath("//a[text()='Computer Glasses']");
		action.moveToElement(menu).perform();
		
		driver.findElementByXPath("//span[text()='PREMIUM RANGE']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Round']").click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Black(14)']")).click();
		Thread.sleep(2000);
		String showingOf = driver.findElement(By.className("show_count")).getText();
		System.out.println(showingOf);
		
		Actions action1 = new Actions(driver);
		WebElement menu1 = driver.findElementByXPath("//div[@class='col-md-12 text-center prod-img-container padding-t15 padding-r15 padding-l15']");
		action1.moveToElement(menu1).perform();
		
		String sizeMedium = driver.findElement(By.xpath("//p[contains(@class,'fs12 no-decoration')]")).getText();
		System.out.println(sizeMedium);
		
		driver.close();	
		
	}

}

