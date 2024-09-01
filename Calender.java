package seleniumTestNG;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calender {

	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void calender() throws Exception {


		Calendar calendar = Calendar.getInstance();
		String date = "6-Feb-2024";
		SimpleDateFormat targetFormatDate = new SimpleDateFormat("dd-MMM-yyyy");;
		Date FormattedTargetDate;
		try {
			targetFormatDate.setLenient(false);
			FormattedTargetDate =targetFormatDate.parse(date);
			calendar.setTime(FormattedTargetDate);

			int targetDate = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println(targetDate);
			int targetMonth = calendar.get(Calendar.MONTH);
			System.out.println(targetMonth);
			int targetYear = calendar.get(Calendar.YEAR);

			driver.findElement(By.id("second_date_picker")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td[not(contains(@class,' ui-datepicker-other-month '))]/a[.='"+targetDate+"']")).click();
		} catch (Exception e) {
			throw new Exception("Invalid date/month , Please check input");
		}			
	}

	@Test(enabled=false)
	public void selectPastMonthAndYear() throws ParseException, InterruptedException {

		String targetDate = "02-12-2023";

		SimpleDateFormat targetDateFormat= new SimpleDateFormat("dd-MM-yyy");
		Date FormattedDate =targetDateFormat.parse(targetDate);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(FormattedDate);

		int TargetDate = calendar.get(Calendar.DAY_OF_MONTH);
		int TargetMonth = calendar.get(Calendar.MONTH);
		int TargetYear = calendar.get(Calendar.YEAR);

		driver.findElement(By.id("second_date_picker")).click();
		Thread.sleep(3000);
		String actualDate =	driver.findElement(By.className("ui-datepicker-title")).getText();

		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
		int calendarMonth = calendar.get(Calendar.MONTH);
		System.out.println(calendarMonth);
		int calendarYear = calendar.get(Calendar.YEAR);
		System.out.println(calendarYear);

		while(TargetMonth<calendarMonth || TargetYear<calendarYear) {
			driver.findElement(By.xpath("//span[.='Prev']")).click();
			Thread.sleep(3000);
			actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
			calendarMonth = calendar.get(Calendar.MONTH);
			System.out.println(calendarMonth +"inside");
			calendarYear = calendar.get(Calendar.YEAR);
			System.out.println(calendarYear +"inside");
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td[not(contains(@class,' ui-datepicker-other-month '))]/a[.='"+TargetDate+"']")).click();
	}
	
	@Test
	public void futureMonthAndYear() throws InterruptedException {
		
		String Date = "3/5/2026";
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
	    Date formattedDate;
		try {
			formattedDate = dateFormat.parse(Date);
			calendar.setTime(formattedDate);
		int userDate = calendar.get(Calendar.DAY_OF_MONTH);
		int userYear = calendar.get(Calendar.YEAR);
		int userMonth = calendar.get(Calendar.MONTH);
		
		driver.findElement(By.id("second_date_picker")).click();
		Thread.sleep(3000);
		
		String actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
		
		calendar.setTime(new SimpleDateFormat("MMM yyy").parse(actualDate));
		int calendarMonth = calendar.get(Calendar.MONTH);
		int calendarYear = calendar.get(Calendar.YEAR);
		
		while(calendarMonth<userMonth || calendarYear < userYear ) {
			
			driver.findElement(By.className("ui-datepicker-next")).click();
			
			actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			
			calendar.setTime(new SimpleDateFormat("MMM yyy").parse(actualDate));
			calendarMonth = calendar.get(Calendar.MONTH);
			calendarYear = calendar.get(Calendar.YEAR);
			
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td[not(contains(@class,' ui-datepicker-other-month '))]/a[.='"+userDate+"']")).click();
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}
}

