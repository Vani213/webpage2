package week4.day1;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://erail.in/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		driver.findElementById("chkSelectDateOnly").click();
		
		driver.findElementByXPath("//input[@id='txtStationFrom']").clear();
		driver.findElementByXPath("//input[@id='txtStationFrom']").sendKeys("Chennai Egmore",Keys.ENTER);
		
		
		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		driver.findElementByXPath("//input[@id='txtStationTo']").sendKeys("Kumbakonam",Keys.ENTER);
		
		Thread.sleep(2000);
		List<WebElement> trains = driver.findElementsByXPath("//table[contains(@class,'DataTable TrainList')]");

        System.out.println(trains.size());

        for (WebElement webElement : trains) {
            String name = webElement.getText();
            System.out.println(name);
		
		
	}
driver.close();
	}
}


