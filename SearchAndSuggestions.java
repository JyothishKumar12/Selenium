package questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAndSuggestions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Game of Thrones");
		Thread.sleep(3000);
	List<WebElement> results =	driver.findElements(By.xpath("(//ul[@role='listbox'])[1]/li"));
	
//	for (WebElement suggestions : results) {
//		
//		System.out.println(suggestions.getText());
//		System.out.println("h");
//	}

//	int positions =0;
//	for (WebElement suggestions : results) {
//		System.out.println(suggestions.getText());
//		positions++;
//		System.out.println(positions);
//		if(positions ==4) {
//			System.out.println("--------------");
//		System.out.println(suggestions.getText());
//		suggestions.click();
//		break;
//		}
//		
//	}
	
	
	for (WebElement suggestions : results) {
	String key = suggestions.getText();
	if(key.contains("cast")) {
		suggestions.click();
	}
}

	
	
		}

}
