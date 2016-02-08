package BDDTest.steps;

import java.util.Map;


import automationFramework.DemoLoginController;
import automationFramework.DemoQaSeleniumLoginPage;
import automationFramework.EditProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefs {

	
	@Given("^I login to qaDemoPage$")
	 public void I_login_to_login_demoPage(Map<String,String> loginDetails){
		DemoLoginController loginController = new DemoLoginController();
		String userName = loginDetails.get("userName");
		String password = loginDetails.get("password");
		
		loginController.loginToAccount(userName,password);
	}
	
	@And("^I logout of my profile$")
	 public void I_logout_of_my_profile(){
		EditProfilePage profilePage = new EditProfilePage();
		profilePage.onlineStoreTab();
		DemoQaSeleniumLoginPage logout = new DemoQaSeleniumLoginPage();
		logout.logoutButton().click();
	}
	
	
	@Then("^I logout and close the browser")
	public void I_logout_and_close_browser(){
		EditProfilePage profilePage = new EditProfilePage();
		profilePage.onlineStoreTab();
		DemoQaSeleniumLoginPage logout = new DemoQaSeleniumLoginPage();
		logout.logoutButton().click();
		logout.closeBrowser();
	}
	
	@Then("^I close my browser")
	public void I_close_my_browser(){
		DemoQaSeleniumLoginPage logout = new DemoQaSeleniumLoginPage();
		
		String logoutAvailable = "no";
		int count = 0;
		while("no".equalsIgnoreCase(logoutAvailable) && count<100){
			try{
				logout.logoutButton().click();
				logoutAvailable = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
			}catch(org.openqa.selenium.InvalidElementStateException e){
				count++;
			}catch(org.openqa.selenium.StaleElementReferenceException e){
				count++;
			}
		}
		logout.closeBrowser();
	}
}
