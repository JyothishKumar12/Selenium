package seleniumTestNG;

import org.testng.annotations.Test;

public class Groups {

	
	@Test(groups = {"Smoke"})
	public void signUp() {
		System.out.println("Successful");
	}
	
	@Test(groups={"Smoke","Sanity"})
	public void login() {
		System.out.println("Login........");
	}
	
	@Test(groups = "Regression")
	public void homePage() {
		System.out.println("Home page");
	}
}
