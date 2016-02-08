package automationFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditProfilePage extends DriverManual{
  
	
	public WebElement myAccountTab(){
		return driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']//a"));
	}
	
	public WebElement editMyProfileOption(){
		return driver.findElement(By.xpath("//li[@id='wp-admin-bar-edit-profile']//a"));
	}
	
	public void  onlineStoreTab(){
		String onLineStoreTab = "no";
		int count = 0;
		while("no".equalsIgnoreCase(onLineStoreTab) && count<100){
			try{
				driver.findElement(By.xpath("//li[@id='wp-admin-bar-site-name']//a")).click();
				onLineStoreTab = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count++;
			}catch(org.openqa.selenium.StaleElementReferenceException e){
				count++;
			}
			
	   }
	}
	
}
