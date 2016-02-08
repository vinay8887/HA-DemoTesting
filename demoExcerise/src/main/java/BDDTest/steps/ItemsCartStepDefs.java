package BDDTest.steps;

//Cucumber STepDefs to add items to cart.
//This inturn calls the controller which runs the selenium elements from page class

import java.util.List;

import org.junit.Assert;

import automationFramework.DemoQaSeleniumProductsController;
import automationFramework.ShippingController;
import automationFramework.ShippingInfoPage;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ItemsCartStepDefs {

	private List<String> itemList;

	
	@Then("^I add following items to cart$")
	public void i_add_following_items_to_cart( List<String> itemList) throws Throwable {
	    this.itemList = itemList;
	    
	    DemoQaSeleniumProductsController prodController = new DemoQaSeleniumProductsController();
	    
	    for(String list :itemList){
	    	prodController.addItemsToCart(list);
	    }
	}
	
//	And I checkout and purchase items    And I checkout item present in the cart

	@And("^I checkout items present in the cart$")
	public void I_checkout_items_present_in_the_cart(){
		ShippingController shipController = new ShippingController();
		shipController.checkOutItems();
	}
	
	@Then("^I purchase items$")
	public void I_purchase_items(){
		ShippingInfoPage info = new ShippingInfoPage();
		info.purchaseButton();
	}
	
	@And("^I check whether my cart is empty$")
	public void I_check_whether_my_cart_is_empty(){
		ShippingInfoPage itemsFromcart = new ShippingInfoPage();
		itemsFromcart.editCart().click();
		
		if(!("Oops, there is nothing in your cart.".equalsIgnoreCase(itemsFromcart.entryContent()))){
			itemsFromcart.numberOfItemsToRemove();
			if("Oops, there is nothing in your cart.".equalsIgnoreCase(itemsFromcart.entryContent())){
				System.out.println("Emptied the cart and found Empty Cart Message...");
			}else{
				System.out.println("Emptied the Cart but didnot find empty cart message....");
			}
		}else{
			System.out.print("Please Add items to your cart......");
		}
	}
	
}
