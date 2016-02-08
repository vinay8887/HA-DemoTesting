package BDDTest.steps;

//Cucumber STepDefs to edit and update profile

import java.util.Map;

import org.junit.Assert;

import automationFramework.EditProfilePage;
import automationFramework.UpdateProfilePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class EditProfileStepDefs {

//	And I edit firstName lastName and emailAddress with "vinayaKum" "Kumar" "vinay8887@gmail.com"
	Map<String, String> profileDetails;
	
	@Given("^I edit firstName lastName and emailAddress with \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void i_edit_firstName_lastName_and_emailAddress_with(String firstName, String lastName, String emailAddress) throws Throwable {
	    
		EditProfilePage profilePage = new EditProfilePage();
		profilePage.myAccountTab().click();
		
		UpdateProfilePage page = new UpdateProfilePage();
		
		page.firstName(firstName);
		page.lastName(lastName);
		page.emailAddress(emailAddress);
		
		
		page.updateButton().click();
		
	}
	
	@Then("^I verify the following updated details$")
	public void i_verify_the_following_updated_details(Map<String, String> profileDetails){
		this.profileDetails = profileDetails;
	  
		  String firstName = profileDetails.get("firstName");
		  String lastName = profileDetails.get("lastName");
		  String emailAddress = profileDetails.get("emailAddress");
		  
		  EditProfilePage profilePage = new EditProfilePage();
			profilePage.myAccountTab().click();
		  
		  
		  UpdateProfilePage page = new UpdateProfilePage();
		  
		  Assert.assertEquals("First Name matches", firstName,page.getFirstName());
		  Assert.assertEquals("last Name matches", lastName,page.getLastName());
		  Assert.assertEquals("email Address matches",emailAddress,page.getEmailAddress());
		  
//		  
//		  if(firstName.equals(page.getFirstName())){
//			  System.out.print("FirstName matches");
//		  }else{
//			  System.out.print(firstName+" FirstName doesn matches");
//		  }
//		  
//		  if(lastName.equals(page.getLastName())){
//			  System.out.print("lastName matches");
//		  }else{
//			  System.out.print(lastName+" lastName doesn matches");
//		  }
//		  
//		  if(emailAddress.equals(page.getEmailAddress())){
//			  System.out.print("email address matches");
//		  }else{
//			  System.out.print(emailAddress+" email address doesn matches");
//		  }
		  
	}

	
	
	
}
