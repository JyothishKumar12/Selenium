package questions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
				System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://letcode.in/table");
				WebElement table =	driver.findElement(By.xpath("//table[contains(@class,'mat-sort')]"));
				List<WebElement> allrows = table.findElements(By.xpath("//table[contains(@class,'mat-sort')]/tr"));


	ArrayList<Integer> ar1 = new ArrayList<Integer>();

				for(int i=0;i<allrows.size();i++) {
					WebElement tableRows =	allrows.get(i);
					String cholestrols =	tableRows.findElement(By.xpath("td[6]")).getText();
					int cholestrol = Integer.parseInt(cholestrols);
					ar1.add(cholestrol);
					
				}

		int checking =0;
		for(int j =0;j<ar1.size()-1;j++) {
			
			if(checking==0) {

				for(int k=j+1;k<=j+1;k++) {
					if(ar1.get(j) < ar1.get(k)) {

					}
					else {
						checking++;
						System.out.println("Not a sorted values");
					}
					System.out.println(ar1.get(j) + " "+ ar1.get(k));
				}

			}
	
		}
		if(checking ==0) {
			System.out.println("sorted");
		}
	}

}


