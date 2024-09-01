package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.leafground.com/link.xhtml");
	
WebElement linkDestination =	driver.findElement(By.linkText("Find the URL without clicking me."));
String destination = linkDestination.getAttribute("href");
System.out.println(destination);

driver.findElement(By.linkText("Broken?")).click();
System.out.println(driver.getTitle());
}
}
