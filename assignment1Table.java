package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment1Table {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		
		WebElement TogetRows = driver.findElement(By.xpath("//table[@id='table_id']/tbody"));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement Targetcolumn = driver.findElement(By.xpath("//table[@id='table_id']/tbody"));
		List<WebElement> TotalcolumnList = Targetcolumn.findElements(By.tagName("tr"));
		System.out.println("Total number of column in the table are : "+ TotalcolumnList.size());
		
		List<WebElement> row = driver.findElementsByXPath("//table//tr//td[2]");
		
		List<Integer> vital  = new ArrayList<Integer>();
		
		for (WebElement mark : row) {
			String least = mark.getText().replaceAll("%", "");
			vital.add(Integer.parseInt(least));
			
		}
		Collections.sort(vital);
		int lowest = vital.get(0);
		
		driver.findElementByXPath("//td[contains(text(), '"+lowest+"')]/following::input").click();
		System.out.println(lowest);
		
		driver.close();
	}
	
	

}
