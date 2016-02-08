package automationFramework;

//Controller to provide shipping and billing info while checkout
public class ShippingController {
	
	
	public void checkOutItems(){
		ShippingInfoPage info = new ShippingInfoPage();
		info.countryName("USA");
        info.calculateButton();
//		info.stateName("Texas");
        info.shippingAddressInfo();
		info.emailAddress("vinay.konke@gmail.com");
		info.firstName("Vinay");
		info.lastName("konke");
		info.physicalAddress("North Austin, near oak knoll drive, 1431");
		info.cityName("Austin");
//		info.physicalStateName("Texas");
		info.phone("xxx-xx-xxxx");
		info.pinCode("78727");
		info.country("USA");
		
	}
	
}
