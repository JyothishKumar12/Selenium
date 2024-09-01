package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropBy {

	
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/draggable");
		driver.manage().window().maximize();
	}
	
	@AfterTest()
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void drag() {
		
	WebElement box =	driver.findElement(By.id("sample-box"));
	Actions builder = new Actions(driver);
	int x = box.getLocation().getX();
	int y = box.getLocation().getY();
	
	builder.dragAndDropBy(box,x+60,y+250).build().perform();
	
	
		}
}
