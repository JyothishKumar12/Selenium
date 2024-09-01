package seleniumTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Selectable {


	private WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@AfterSuite()
	public void tearDown() {
				driver.close();
	}

	@Test
	public void selectable() {
		driver.get("https://letcode.in/selectable");

		List<WebElement> sel = driver.findElements(By.xpath(" //*[@id ='container']/div"));
		Actions builder = new Actions(driver);
//		builder.keyDown(Keys.CONTROL).click(sel.get(0)).click(sel.get(1)).click(sel.get(2)).build().perform();
		builder.clickAndHold().click(sel.get(4));
		builder.clickAndHold().click(sel.get(5)).build().perform();;
	}
}
