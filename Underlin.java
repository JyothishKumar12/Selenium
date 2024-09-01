package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Underlin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebElement text =	driver.findElement(By.xpath("//*[.='മലയാളം']"));
		String before =	text.getCssValue("text-decoration");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(text).build().perform();
		String After =	text.getCssValue("text-decoration");

		System.out.println(before);
		System.out.println("After houvering "+After);
	}

}
