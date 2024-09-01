package seleniumTestNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.Assert;
import org.testng.annotations.*;

public class RadioButton {
	
	private WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/radio");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}

	@AfterSuite()
	public void tearDown() {
				driver.close();
	}
	
	@Test
	public void radionBtn() {
		
		driver.findElement(By.id("yes")).click();
	}
	
	@Test
	public void oneBtn() {
	WebElement btn = driver.findElement(By.id("one"));
	btn.click();
	btn.isSelected();
	WebElement btn2 = driver.findElement(By.id("yes"));
	btn2.click();
	
	if(btn!=btn2) {
		System.out.println("Only one is clicked");
	}
	}
	
	@Test
	public void multipleSelection() {
	WebElement btn = driver.findElement(By.id("nobug"));
	btn.click();
	btn.isSelected();
	WebElement btn2 = driver.findElement(By.id("bug"));
	btn2.click();
	
	if(btn==btn2) {
		System.out.println("Multiple Selection of Radio button");
	}
	}
	
	@Test
	public void selctdBtn() {
	WebElement fooBtn =	driver.findElement(By.id("foo"));
	fooBtn.click();
	System.out.println(fooBtn.getText());
	}
	
	@Test
	public void isSelect() {
	WebElement btn = driver.findElement(By.id("maybe"));
	System.out.println(btn.isEnabled());
	try {
		Assert.assertTrue(btn.isEnabled(),"Not enabled");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	}
	
	@Test
	public void CheckBx() {
		driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
	}
}
