package BDDTest.steps;

//Cucumber StepDefs for Api Based Test

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import automationFramework.APIClient;
import automationFramework.APIException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ApiTestStepDefs {

	static private String availableApiKey;
	private JSONObject stationList;
	static private Long stationId;
	
	//Used https://api.data.gov/docs/nrel/transportation/alt-fuel-stations-v1/  and got 302 moved temporarily
	//According to this link https://developer.nrel.gov/docs/transportation/alt-fuel-stations-v1/nearest/
	//the URL for GET is /api/alt-fuel-stations/v1/nearest.format?parameters
	String restEndPoint = "https://api.data.gov/nrel/alt-fuel-stations/v1/";
	
	@Given("^I input my apiKey as \"(.*?)\"$")
	public void I_input_my_apiKey_as(String apiKey){
		 this.availableApiKey = apiKey;
	}
	
	//Api to search for nearsest station in AUstin with ChargePoint Network
	@Given("^I search for nearest station to \"(.*?)\" which is part of \"(.*?)\"$")
	public void I_search_for_nearest_station_to_which_is_part_of(String cityName, String groupName) throws MalformedURLException, IOException, APIException{
		 restEndPoint = restEndPoint+"nearest.json";
		Map<String, String> parameter = new HashMap();
		parameter.put("api_key",availableApiKey);
		parameter.put("location",cityName);
		
		APIClient client = new APIClient(restEndPoint);
		groupName = URLEncoder.encode(groupName,"UTF-8");
		parameter.put("ev_network",groupName);
		stationList = (JSONObject) client.sendGet(restEndPoint,parameter);
	}
	
	
	//https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?location=Austin&api_key=Dz4uMiZpWfFX60654FnNLDuvHAlUULu8vXOVVYIR&ev_network=ChargePoint+Network
	//Api to get StationId
	@Then("^I check for \"(.*?)\" and get its stationId$")
	public void I_check_for_and_get_its_stationId(String stationName){
		JSONArray stations = (JSONArray) stationList.get("fuel_stations");
		
		for(int i = 0;i<stations.size();i++){
			JSONObject stationEntries = (JSONObject) stations.get(i);
			if(stationName.equals(stationEntries.get("station_name"))){
				stationId = (Long) stationEntries.get("id");
				break;
			}
		}
	}
	
	//stationId = 62029
	//https://api.data.gov/nrel/alt-fuel-stations/v1/62029.json?api_key=Dz4uMiZpWfFX60654FnNLDuvHAlUULu8vXOVVYIR
	//Api to get street Address and verify the street address
	@SuppressWarnings("deprecation")
	@Then("^I verify HYATT's street address as \"(.*?)\" using its stationId$")
	public void I_verify_hyatts_street_address(String streetAddress) throws MalformedURLException, IOException, APIException{
		Map<String, String> parameter = new HashMap();
		String country = null;
		parameter.put("api_key",availableApiKey);
		restEndPoint = restEndPoint+stationId+".json";
		APIClient client = new APIClient(restEndPoint);
		JSONObject stationInfo = (JSONObject) client.sendGet(restEndPoint,parameter);
		stationInfo = (JSONObject) stationInfo.get("alt_fuel_station");
		if("78704".equals((String) stationInfo.get("zip")))
			 country = "USA";
		
		
		if(streetAddress.equals((String) stationInfo.get("street_address")+", "+(String) stationInfo.get("city")+
				", "+(String) stationInfo.get("state")+", "+country+", "+(String) stationInfo.get("zip"))){
			System.out.println("The Station Address matches with the given input...");
		}else{
			System.out.println((String) stationInfo.get("street_address")+", "+(String) stationInfo.get("city")+
					", "+(String) stationInfo.get("state")+", "+(String) stationInfo.get("zip") + " Station address doesn't match");
		}
		
		Assert.assertEquals("The Station Address matches", streetAddress, (String) stationInfo.get("street_address")+", "+(String) stationInfo.get("city")+
				", "+(String) stationInfo.get("state")+", "+country+", "+(String) stationInfo.get("zip"));
	}
}

