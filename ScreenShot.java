package seleniumTestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import 	org.openqa.selenium.io.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScreenShot {

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
	public void screenShot() throws IOException {
		
		TakesScreenshot tS = (TakesScreenshot) driver;
	File source =	tS.getScreenshotAs(OutputType.FILE);
	File destination = new File("./Screenshots/image.png");
    FileHandler.copy(source, destination);
	}
}
