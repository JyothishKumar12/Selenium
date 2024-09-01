package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_tooltip");
		
//		WebElement toolTip = driver.findElement(By.xpath("//div[@class='tooltip']")).click();
//		System.out.println(toolTip);
		 }

}
