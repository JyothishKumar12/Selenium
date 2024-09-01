package seleniumTestNG;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandle {

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

	@Test(enabled = false)
	public void windows() {
		driver.get("https://letcode.in/windows");
		driver.findElement(By.id("home")).click();
		System.out.println("main "+ driver.getTitle());
		String pHandle =	driver.getWindowHandle();

		Set<String>	Handles = driver.getWindowHandles();

		for(String windows : Handles) {

			if(!windows.equals(pHandle)) {
				driver.switchTo().window(windows);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}

		driver.quit();

	}

	@Test
	public void multipleWindow() {
		driver.get("https://letcode.in/windows");
		driver.findElement(By.id("multi")).click();
		Set<String>	Handles = driver.getWindowHandles();
		for (String windows : Handles) {
			String title =	driver.switchTo().window(windows).getTitle();
			System.out.println(title);
		}
		driver.close();
	}
}
