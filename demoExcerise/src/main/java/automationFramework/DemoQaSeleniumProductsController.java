package automationFramework;


//Controller to add items to cart and checkout items in the cart

public class DemoQaSeleniumProductsController {

	
	public void addItemsToCart(String itemName){
		DemoQaSeleniumProductsPage selectProduct = new DemoQaSeleniumProductsPage();
		selectProduct.searchForItem(itemName);
		selectProduct.addToCart();
		selectProduct.checkOutButton();
		selectProduct.continueButton();
	}
	
}
