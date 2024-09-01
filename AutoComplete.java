package questions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoComplete {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='searchbox']"))).sendKeys("in");
//		driver.findElement(By.xpath("//*[@id='searchbox']/..")).sendKeys("in");
		Thread.sleep(3000);
//	List<WebElement>countries =	driver.findElements(By.xpath("//*[@id='menucontainer']//li"));
		List<WebElement>countries	= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='menucontainer']//li")));
	
	for (WebElement cn : countries) {
		
		if(cn.getText().equals("India")) {
			cn.click();
			break;
		}
	}
	}

}
