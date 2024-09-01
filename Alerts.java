package seleniumTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {

private	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
	}
	
	
	@AfterTest()
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void alerts() {
		driver.findElement(By.id("accept")).click();
	Alert a1 =	driver.switchTo().alert();
	a1.accept();
	}
	
	@Test
	public void confirm() {
		driver.findElement(By.id("confirm")).click();
	Alert cnfirm =	driver.switchTo().alert();
	System.out.println(cnfirm.getText());
	cnfirm.dismiss();
	}
	
	@Test
	public void prompt() {
		driver.findElement(By.id("prompt")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Jyothish");
		prompt.accept();
	}
	
	@Test
	public void sweetAlert() {
		driver.findElement(By.xpath("//button[@class='modal-close is-large']")).click();
	}
}
