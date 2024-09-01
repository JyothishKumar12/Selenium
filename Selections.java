package seleniumTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selections {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
	}

	@Test
	public void selectFruit() {
		WebElement fruitSelect =	driver.findElement(By.id("fruits"));
		Select apple = new Select(fruitSelect);
		apple.selectByVisibleText("Apple");
		List<WebElement> li = apple.getOptions();

		for (WebElement fList : li) {
			System.out.println(fList.getText());
		}

	}

	@Test(enabled=true)
	public void suprHro() {
		WebElement superHero =	driver.findElement(By.id("superheros"));
		Select sHero = new Select(superHero);
		sHero.selectByIndex(1);
		sHero.selectByValue("am");
		sHero.selectByVisibleText("Wonder Woman");
		boolean t = sHero.isMultiple();
		System.out.println(t);
		
	WebElement fOptions =	sHero.getFirstSelectedOption();
	System.out.println(fOptions.getText() + "first options");
	List<WebElement>all = sHero.getAllSelectedOptions();
	for (WebElement allOp : all) {
		System.out.println(allOp.getText());
	}

	}

	@Test(enabled=true)
	public void language() {
		WebElement lang =	driver.findElement(By.id("lang"));
		Select langu = new Select(lang);
		langu.selectByVisibleText("C#");
	}


	@Test
	public void scrollSelect() {
		WebElement team = driver.findElement(By.id("country"));
		JavascriptExecutor jE = (JavascriptExecutor)driver;
		jE.executeScript("arguments[0].scrollIntoView(true);",team);
		//		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Select country = new Select(team);
		country.selectByValue("India");
	}
	@AfterTest
	public void tearDown() {
//		driver.close();
	}
}
