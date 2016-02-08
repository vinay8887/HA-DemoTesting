package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

//Page to add items to cart, checkout items from cart

public class DemoQaSeleniumProductsPage extends DriverManual{

	int count = 0;
	public WebElement homeButton(){
	   return driver.findElement(By.xpath("//li[@id='menu-item-15']//span")); 
	}
	
	public void searchForItem(String itemName){
		String searchForItems = "no";
		while("no".equalsIgnoreCase(searchForItems)){
			try{
				driver.findElement(By.name("s")).sendKeys(itemName);
				searchForItems = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				System.out.println("Waiting for seachOption");
				count++;
				if(count>100){
					System.out.println("Element \"search For Items Option\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}
			catch(org.openqa.selenium.ElementNotVisibleException e){
				System.out.print("Waiting for seachOption");
				count++;
				if(count>100){
					System.out.println("Element \"search for items Option\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
		}
		
		
		driver.findElement(By.name("s")).sendKeys(Keys.RETURN);
	}
	
	
	public void addToCart(){
		String addToCartButtonAvailable = "no";
		while("no".equalsIgnoreCase(addToCartButtonAvailable)){
			try{
				driver.findElement(By.name("Buy")).click();
				addToCartButtonAvailable = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				if(count>100){
					System.out.println("Element \"addToCartButton\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}
		}
	}
	
	public void checkOutButton(){
		String checkOutButtonAvailable = "no";
		while("no".equalsIgnoreCase(checkOutButtonAvailable)){
			try{
				driver.findElement(By.className("go_to_checkout")).click();
				checkOutButtonAvailable = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				if(count>200){
					System.out.println("Element \"checkOut Button\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}
		}
	}
	
	public void continueButton(){
		String continueButton = "no";
		while("no".equalsIgnoreCase(continueButton)){
			try{
				driver.findElement(By.className("step2")).click();
				continueButton = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				System.out.println("Waiting for continue button");
				count++;
				if(count>400){
					System.out.println("Element \"continue Button\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				System.out.println("Waiting for continue button");
				count++;
				if(count>400){
					System.out.println("Element \"continue Button\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
		}
	}
}
