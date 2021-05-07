package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignCalender {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://leafground.com/pages/Calendar.html");
		
		driver.findElementById("datepicker").click();
		driver.findElementByXPath("//table/tbody/tr[3]/td[2]").click();
		
		driver.close();

	}

}
