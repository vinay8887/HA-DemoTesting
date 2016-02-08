package automationFramework;
//parent class which initializes WebDriver. Using Chrome Driver for UI access

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManual {

	static WebDriver driver;
	static int frameCount = 0;
	
	
	
	public DriverManual(){
		
		if(frameCount == 0){
//			this.driver = new RemoteWebDriver(DesiredCapabilities.chrome());
			this.driver = new ChromeDriver();
			frameCount = 1;
		}
	}
	
}
