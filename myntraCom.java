package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myntraCom {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		WebElement women = driver.findElementByXPath("//a[@class='desktop-main'][text()='Women']");
		Actions builder=new Actions(driver);
		builder.moveToElement(women).perform();
		Thread.sleep(5000);
		System.out.println("women selected");
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		
		//int count=driver.findElementByXPath("//span[@class='title-count']");
		List<WebElement> CC=driver.findElementsByXPath("//span[@class='title-count']");
		System.out.println("total no of value "+ CC.size());
		for (WebElement product : CC)
		{
			System.out.println(product.getText());
		

	}

		driver.findElementByXPath("//label[@class='common-customCheckbox vertical-filters-label'][text()='Coats']").click();
		driver.findElementByXPath("//div[@class='brand-more']").click();
		//driver.findElementByLinkText("50").click();
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("mango");
		driver.findElementByXPath("//label[text()='MANGO'][@class=' common-customCheckbox']").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		Thread.sleep(2000);
		List<WebElement> ListofNames = driver.findElements(By.xpath("//h3[text()='MANGO']"));
		
		for(int i=0;i<ListofNames.size();i++)
		{
			if(ListofNames.get(1).getText().equals("MANGO"))
			{
				System.out.println("All brand matches");
			}else
			System.out.println("Doesnt Match");
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebElement sort = driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite sort-downArrow')]");
		Actions builder1=new Actions(driver);
		builder1.moveToElement(sort).perform();
		
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		String price = driver.findElementByXPath("//span[@class='product-discountedPrice']").getText();
		System.out.println(price);
		
		WebElement wishlist = driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]"));
		builder1.moveToElement(wishlist).perform();
		
		driver.findElement(By.xpath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']")).click();
		System.out.println("Wishlist Added");
		driver.close();
	}

}
