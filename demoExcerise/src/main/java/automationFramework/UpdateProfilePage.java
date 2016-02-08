package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Selenium page to update profile.
//Updates FirstName, LastName and EmailAddress

public class UpdateProfilePage extends DriverManual{

//	WebDriver driver;
//	
//	public UpdateProfilePage(WebDriver driver){
//		this.driver = driver;
//	}

	
	public void firstName(String fName){
		 String reachedFisrtName = "no";
		 int count = 0;
		 while("no".equals(reachedFisrtName) && count<100){
			 try{
				 driver.findElement(By.id("first_name")).clear();
					driver.findElement(By.id("first_name")).sendKeys(fName);
				 reachedFisrtName = "yes";
		 }catch(org.openqa.selenium.NoSuchElementException e){
			 count++;
		   }
		 }
	}
	
	public void lastName(String lName){
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys(lName);;
	}
	
	public void nickName(String nickName){
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys(nickName);;
	}
	
	public void displayName(String name){
		driver.findElement(By.cssSelector("select[id='display_name']")).sendKeys(name);
	}
	
	public void emailAddress(String emailAddress){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailAddress);
	}
	
	public void bioInfo(String info){
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(info);
	}
	
	public void password(String password){
		driver.findElement(By.id("pass1")).clear();
		driver.findElement(By.id("pass1")).sendKeys(password);
	}
	
	public void retypePassword(String password){
		driver.findElement(By.id("pass2")).clear();
		driver.findElement(By.id("pass2")).sendKeys(password);
	}
	
	public WebElement updateButton(){
		return driver.findElement(By.id("submit"));
	}
	
	 public String getFirstName(){
		 String firstName = null;
		 String reachedFisrtName = "no";
		 int count = 0;
		 while("no".equals(reachedFisrtName) && count<100){
			 try{
				 firstName = driver.findElement(By.id("first_name")).getAttribute("value");
				 reachedFisrtName = "yes";
		 }catch(org.openqa.selenium.NoSuchElementException e){
			 count++;
		   }
		 }
		 
		 if("no".equals(reachedFisrtName)){
			 throw new org.openqa.selenium.NoSuchElementException("Not Able to find firstName...");
		 }
		 
		return firstName;	 
	}
	 
	 public String getLastName(){
	    return driver.findElement(By.id("last_name")).getAttribute("value");
     }
		
	public String getNickName(){
		return	driver.findElement(By.id("nickname")).getAttribute("value");
	}
		
		
	public String getEmailAddress(){
		return driver.findElement(By.id("email")).getAttribute("value");
	}
		
	 
	 
	
}
