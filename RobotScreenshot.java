package questions;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotScreenshot {

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		
		Robot rb = new Robot();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rectangle = new Rectangle(screenSize);
		
	    BufferedImage source =	rb.createScreenCapture(rectangle);
	    
	    File destination = new File("./Pictures/alertIMage.png");
	    
	    ImageIO.write(source,"png", destination);
	}

}
