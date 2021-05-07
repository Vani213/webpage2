package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {

		String check = null,check1=null, sample="L'Oreal Paris Colour Protect Shampoo";
		String grandtotal = null;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement brand = driver.findElementByXPath("//a[text()='brands']");
		Actions builder=new Actions(driver);
		builder.moveToElement(brand).perform();
		WebElement jacket = driver.findElementByXPath("(//a[text()=\"L'Oreal Paris\"])[1]");
		builder.moveToElement(jacket).click().perform();
		//div[@class='filter-heading-section ']
		List<WebElement> CC=driver.findElementsByXPath("//div[@class='filter-heading-section ']");
		System.out.println("total no of value "+ CC.size());
		for (WebElement product : CC)
		{
			System.out.println(product.getText());
			check = product.getText();
		

	}
		if (check!="L'Oreal Paris") {
			
			System.out.println("Product not matched");
			
		}

		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("//span[text()='Hair']").click();
		driver.findElementByXPath("//span[text()='Hair Care']").click();
		driver.findElementByXPath("//span[text()='Shampoo']").click();
		
		List<WebElement> CC1=driver.findElementsByXPath("//div[@class='m-content_product-list_title']");
		System.out.println("total no of value "+ CC.size());
		for (WebElement product : CC1)
		{
			//System.out.println(product.getText());
			check1=product.getText();
			if (sample.equals(check1)) {
				
				
				System.out.println("Matched");
			}
			
	}

		driver.findElementByXPath("(//span[text()=\"L'Oreal Paris Colour Protect Shampoo\"])[1]").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handlelist=new ArrayList<String>(windowHandles);
		String secondshandle=handlelist.get(1);
		driver.switchTo().window(secondshandle);
		driver.findElementByXPath("//span[text()='175ml']").click();
		List<WebElement> CC3=driver.findElementsByXPath("(//span[@class='post-card__content-price-offer'])[1]");
		//System.out.println("total no of value "+ CC3.size());
		for (WebElement product : CC3)
		{
			System.out.println("MRP is "+product.getText());
		
		}

		driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		
		
		List<WebElement> grand=driver.findElementsByXPath("//div[@class='value medium-strong']");
		for (WebElement product : grand)
		{
			grandtotal=product.getText();
			System.out.println("Grand total is "+product.getText());
		
		}
		WebElement ele =driver.findElement(By.xpath("//span[text()='Proceed']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		List<WebElement> grand2=driver.findElementsByXPath("(//div[@class='value'])[2]");
		for (WebElement product : grand2)
		{
			String grandtotal2 = product.getText();
			System.out.println("Grand total is "+product.getText());
			if(grandtotal.equals(grandtotal2)) {
				System.out.println("Price matches");
				
			}
		driver.quit();
		}		
		}
}

