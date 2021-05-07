package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearntoInteractMultipleElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement men=driver.findElementByXPath("//span[text()='Men's Fashion']");
		Actions builder=new Actions(driver);
		builder.contextClick(men);
		

		WebElement men=driver.findElementByXPath("//span[text()='T-Shirts & Polos']");
		Actions build=new Actions(driver);
		build.contextClick(men);
		
		

	}

}
