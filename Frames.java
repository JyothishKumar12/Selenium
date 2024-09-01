package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Frames {

	private WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@AfterSuite()
	public void tearDown() {
		//		driver.close();
	}

	@Test
	public void frames() {
		driver.get("https://letcode.in/frame");
		System.out.println("first" + driver.getTitle());
		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("kristin");
		driver.findElement(By.name("lname")).sendKeys("steve");
		WebElement iframe =	driver.findElement(By.xpath("//iframe[@src=\"innerFrame\"]"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//*[@name ='email']")).sendKeys("ghas@gmail.com");
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("king");
		
		WebElement iframe2 =	driver.findElement(By.xpath("//iframe[@src=\"innerFrame\"]"));
		driver.switchTo().frame(iframe2);
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
//		driver.findElement(By.name("fname")).sendKeys("kokkachi");

	}
}
