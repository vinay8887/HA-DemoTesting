package automationFramework;

//Login Controller for the UI
//This Controller drives the Page class which has selenium elements to access the UI page

 public class DemoLoginController {
//	WebDriver driver;
//	
//	public DemoLoginController(WebDriver driver){
//		this.driver = driver;
//	}

	public void loginToAccount(String userName,String password){
		DemoQaSeleniumLoginPage loginPage = new DemoQaSeleniumLoginPage();
		loginPage.goToOnlineStore();
		loginPage.myAccountButton().click();
		loginPage.userName(userName);
		loginPage.password(password);
		loginPage.loginButton().click();
		loginPage.isLogOutButtonAvailable();
		
		
	}
}
