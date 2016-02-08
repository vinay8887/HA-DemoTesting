package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Shipping info page which interacts and fills in required shipping and billing info details

public class ShippingInfoPage extends DriverManual{
	
	int count = 0;
	
	public void countryName(String cName){
		String countrySelectOption = "no";
		while("no".equalsIgnoreCase(countrySelectOption)){
			try{
				driver.findElement(By.cssSelector("select[id='current_country']")).sendKeys("Please select a country");
				driver.findElement(By.cssSelector("select[id='current_country']")).sendKeys(cName);
				countrySelectOption = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				System.out.println("Waiting for country select option");
				if(count>100){
					System.out.println("Element \"countrySelectOption\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count++;
				System.out.println("Waiting for country select option");
				if(count>100){
					System.out.println("Element \"countrySelectOption\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
		}
	}
	
	public void stateName(String sName){
		driver.findElement(By.cssSelector("select[id='wpsc_checkout_form_16_region']")).sendKeys(sName);
	}
	
	public void calculateButton(){
		String calculateButtonPresent = "no";
		while("no".equals(calculateButtonPresent)){
			try{
				driver.findElement(By.name("wpsc_submit_zipcode")).click();
				calculateButtonPresent = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				if(count>200){
					System.out.println("Element \"calculateButton\" cannot be found. Error Message "+e.getMessage());
				    throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}
		}
	}
	
	public void emailAddress(String email){
		String emailAddress = "no";
		while("no".equalsIgnoreCase(emailAddress)){
			try{
				driver.findElement(By.id("wpsc_checkout_form_9")).clear();
				driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys(email);
				emailAddress = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count++;
				if(count>100){
					System.out.println("Element \"emailAddress\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.InvalidElementStateException e){
				count++;
				if(count>100){
					System.out.println("Element \"emailAddress\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.InvalidElementStateException();
				}
			}catch(org.openqa.selenium.StaleElementReferenceException e){
				count++;
				if(count>100){
					System.out.println("Element \"emailAddress\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.StaleElementReferenceException(e.getMessage());
				}
			}
		}
	}
	
	public void firstName(String fName){
		driver.findElement(By.id("wpsc_checkout_form_2")).clear();
		driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys(fName);
	}
	
	public void lastName(String lName){
		driver.findElement(By.id("wpsc_checkout_form_3")).clear();
		driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys(lName);
	}
	
	
	public void cityName(String city){
		driver.findElement(By.id("wpsc_checkout_form_5")).clear();
		driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys(city);
	}
	
	public void physicalStateName(String stateName){
		driver.findElement(By.id("wpsc_checkout_form_6")).clear();
		driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys(stateName);
	}
	
	public void physicalAddress(String address){
		driver.findElement(By.id("wpsc_checkout_form_4")).clear();
		driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys(address);
	}
	
	public void pinCode(String pCode){
		driver.findElement(By.id("wpsc_checkout_form_8")).clear();
		driver.findElement(By.id("wpsc_checkout_form_8")).sendKeys(pCode);
	}
	
	public void phone(String phoneNumber){
		driver.findElement(By.id("wpsc_checkout_form_18")).clear();
		driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys(phoneNumber);
	}
	
	public void country(String countryName){
		driver.findElement(By.cssSelector("select[id='wpsc_checkout_form_7']")).sendKeys(countryName);
//		driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys(pAddress);
	}
	
	public void shippingAddressInfo(){
		String shippingSameBilling = "no";
		driver.manage().window().maximize();
		while("no".equalsIgnoreCase(shippingSameBilling)){
			try{
				driver.findElement(By.id("shippingSameBilling")).click();
		        shippingSameBilling="yes";
			}catch(org.openqa.selenium.WebDriverException e){
				count = count +1;
				if(count>500){
					System.out.println("Element \"shippingSameBilling\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.WebDriverException();
				}
			}
		}
	}
	
	public void purchaseButton(){
		String purchaseButtonAvailable = "no";
		while("no".equalsIgnoreCase(purchaseButtonAvailable)){
			try{
				driver.findElement(By.xpath("//div[@class='input-button-buy']//span")).click();
				purchaseButtonAvailable = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count = count +1;
//				Check if the counter is greater than 100, if so then throw error
				if(count>100){
					System.out.println("Element \"purchaseButton\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count = count +1;
				if(count>100){
					System.out.println("Element \"purchaseButton\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}
		}
	}
	
	public WebElement editCart(){
		return driver.findElement(By.className("cart_icon"));
	}
	
	public String  entryContent(){
		String content = null;
		String entryContentavailable = "no";
		while("no".equalsIgnoreCase(entryContentavailable)){
			try{
				content = driver.findElement(By.xpath("//div[@class='entry-content']")).getText();
				entryContentavailable = "yes";
			}catch(org.openqa.selenium.NoSuchElementException e){
				count = count +1;
				if(count>100){
					System.out.println("Element \"entryContent\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.NoSuchElementException(e.getMessage());
				}
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count = count +1;
				if(count>100){
					System.out.println("Element \"entryContent\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}catch(org.openqa.selenium.StaleElementReferenceException e){
				count = count +1;
				if(count>100){
					System.out.println("Element \"entryContent\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.StaleElementReferenceException(e.getMessage());
				}
			}
		}
		
		if(content==null){
			System.out.println("Content is null...Please check");
			throw new NullPointerException();
		}
		
		return content;
	}
	
	public void numberOfItemsToRemove(){
		int numberOfItems = driver.findElements(By.xpath("//table[@class='checkout_cart']/tbody/tr")).size();
		
		for(int i = 1;i<numberOfItems;i++){
			removeButton();
		}
		
		System.out.println("Removed all the items...");
	}
	
	public void removeButton(){
		String removeButton = "no";
		while("no".equalsIgnoreCase(removeButton)){
			try{
		        driver.findElement(By.xpath("//form[@class='adjustform remove']//input[@name='submit']")).click();
		        removeButton = "yes";
			}catch(org.openqa.selenium.ElementNotVisibleException e){
				count++;
				if(count>300){
					System.out.println("Element \"removeButton\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.ElementNotVisibleException(e.getMessage());
				}
			}catch(org.openqa.selenium.StaleElementReferenceException e){
				if(count>300){
					System.out.println("Element \"removeButton\" cannot be found. Error Message "+e.getMessage());
					throw new org.openqa.selenium.StaleElementReferenceException(e.getMessage());
				}
			}
		}
	}
}

