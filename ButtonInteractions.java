package seleniumTestNG;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import graphql.Assert;

public class ButtonInteractions {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/buttons");
		driver.manage().window().maximize();
	}
	
	@Ignore
	@Test()
	public void buttonFunction() {
		
		System.out.println();
		System.out.println("----------------");
//		driver.navigate().to("https://letcode.in/buttons");
		driver.get("https://letcode.in/buttons");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getTitle());
	}
	
	
	@Test(enabled = false)
	public void backToBtnPage() {
		driver.navigate().back();
		System.out.println(driver.getTitle());
	}
	
	
	@Test(enabled = false)
	public void colorButn() throws InterruptedException {
//		driver.get("https://letcode.in/buttons");
		Thread.sleep(3000);	
		String color =	driver.findElement(By.id("color")).getCssValue("background-color");
	     System.out.println(color);
	}
	
	@Test(enabled=false)
	public void btnVerification() {
	boolean btn =	driver.findElement(By.id("isDisabled")).isEnabled();
		Assert.assertFalse(btn);
	}
	
	@Test(priority = 1)
	public void sizeBtn() {
	Dimension size =	driver.findElement(By.id("property")).getSize();
	System.out.println("Height " +size.height );
	System.out.println("Width "+ size.width);
	}
	
	@Test
	public void HoldBtn() {
	WebElement hold =	driver.findElement(By.id("isDisabled"));
		Actions act = new Actions(driver);
				act.clickAndHold(hold).build().perform();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println();
		System.out.println("Test completed");
	}
	
	@BeforeMethod
	public void methodTest(Method m) {
		System.out.println();
		System.out.println(m.getName() + " Started");
	}
	
	@AfterMethod
	public void methodCompleteTest(Method m) {
		System.out.println();
		System.out.println(m.getName() +" completed");
	}
}
