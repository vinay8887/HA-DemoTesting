package automationFramework;

//Login Page contains selenium elements for UI page access.
//Allows user to login to UI page

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoQaSeleniumLoginPage extends DriverManual {

	int count = 0;
	String error = null;
	
	public void goToOnlineStore(){
		driver.get("http://store.demoqa.com ");
	}
	
	public WebElement myAccountButton(){
		return driver.findElement(By.className("account_icon"));
	}
	
	public void userName(String userName){
		String userNameAvailable = "no";
		
		//The while and try catch part of code checks that the element which we are searching for is 
		//present in the page...i.e.. it provides sufficient time for the page to load 
		
		while("no".equalsIgnoreCase(userNameAvailable) && count<100){
			try{
				driver.findElement(By.id("log")).sendKeys(userName);
				userNameAvailable = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;if(count>100){
					System.out.println("Element \"userName\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count++;
				if(count>100){
					System.out.println("Element \"userName\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
	    }
	}
	
	public void password(String password){
		driver.findElement(By.id("pwd")).sendKeys(password);
	}
	
	public WebElement loginButton(){
		return driver.findElement(By.id("login"));
	}
	
	public WebElement logoutButton(){
		String logoutButtonVisisble = "no";
		int count = 0;
		WebElement element = null;
		while("no".equalsIgnoreCase(logoutButtonVisisble) && count<100){
			try{
				element =  driver.findElement(By.partialLinkText("Logout"));
				logoutButtonVisisble = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				if(count>100){
					System.out.println("Element \"uselogoutButton\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count++;
				if(count>100){
					System.out.println("Element \"logoutButton\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
	    }
		
		if(element==null){
			throw new NullPointerException();

		}
		
		return element;
	}
	
	
	public void closeBrowser(){
		 driver.close();
	}
	
	public Boolean isLogOutButtonAvailable(){
		String logoutButton = "no";
		int count = 0;
		Boolean status = false;
		while("no".equalsIgnoreCase(logoutButton) && count<100){
			try{
				driver.findElement(By.partialLinkText("Logout")).isDisplayed();
				return true; 
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				if(count>100){
					System.out.println("Element \"logoutButton\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count++;
				if(count>100){
					System.out.println("Element \"logoutButton\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
	    }
		return status;
	}
	
	
	public void throwEc(int count,Exception e) throws Exception{
		if(count>100){
			throw new Exception();
		}
	}
}
