package BDDTest;

//??Cucumber Runner for AddItemsTo Cart test case

	import org.junit.runner.RunWith;

	import cucumber.api.CucumberOptions;

	import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)

	@CucumberOptions(

			    features = {"src/test/resources/featureFiles/addItems.feature"},
			    plugin = {"pretty","html:target/cucumber-html-report",
                           "junit:target/cucumber-junit-report/allcukes.xml"},
                          tags = {"@demo"})
		        


	public class AddItemsRunner {

 }

