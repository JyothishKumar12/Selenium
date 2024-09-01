package questions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");
			
	WebElement table =	driver.findElement(By.xpath("//table[@id='simpletable']"));

	WebElement tbdy = table.findElement(By.xpath("//table[@id='simpletable']/tbody"));
//	List<WebElement>check =tbdy.findElements(By.xpath("tr/td[2]"));
	List<WebElement> trList =	tbdy.findElements(By.xpath("tr"));
	List<WebElement> tdList =	tbdy.findElements(By.xpath("tr/td"));
	for(int i=0;i<tdList.size();i++) {

	
	WebElement name =tdList.get(i);
	System.out.println(name.getText());
	if(name.getText().equals("Raj")) {
		tdList.get(i+2).findElement(By.tagName("input")).click();
		break;
	}
		
	}
	


	}

}
