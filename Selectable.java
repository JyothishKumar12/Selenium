package questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Selectable.html");
		
	List<WebElement> selectable	= driver.findElements(By.xpath("//ul[@class='deaultFunc']/li"));
	
	System.out.println(selectable.size());
	Actions slIST = new Actions(driver);
	
	slIST.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1)).build().perform();
	
//	slIST.clickAndHold().click(selectable.get(0));
//	slIST.clickAndHold().click(selectable.get(1));
//	slIST.clickAndHold().click(selectable.get(2));
//	slIST.build().perform();
		
	}

}
