package seleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LetCodePage {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void goToUrl() {
		driver.get("https://letcode.in/");
		String title =	driver.getTitle();
		String url = driver.getCurrentUrl();

		System.out.println(title);
		System.out.println(url);
	}


	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
