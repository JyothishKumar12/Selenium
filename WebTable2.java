package questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");

		WebElement shoppingTable =	driver.findElement(By.id("shopping"));
		List<WebElement>allRows = shoppingTable.findElements(By.xpath("//table[@id='shopping']/tbody/tr"));
		int sum =0;
		
		String value = driver.findElement(By.xpath("//tfoot/td[2]")).getText();
		int tablePrice = Integer.parseInt(value);
		System.out.println("Table price is "+ tablePrice);
		
//		for (WebElement tr : allRows) {
//			System.out.println(tr.getText() );
//		String price =	tr.findElement(By.xpath("td[2]")).getText();
//		System.out.println(">>>>>>>>>");
//		System.out.println(price);
//		}
		
		for(int i =0; i<allRows.size();i++) {	
		
		WebElement trlist =	allRows.get(i);
		System.out.println(trlist.getText());
		String price = trlist.findElement(By.xpath("td[2]")).getText();
			System.out.println(price);
			sum = sum+ Integer.parseInt(price);
		}
		
		
		System.out.println("sum is "+ sum);
		if(sum == tablePrice) {
			System.out.println("Price is correct");
		}
	}
}
