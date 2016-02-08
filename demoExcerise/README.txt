Requirements to run this test code....

To run this code you will need:

1. Cucumber natural plugin for eclipse
2. Selenium webdriver
3. Maven 3.0
4. Java 1.7
5. Junit

Cucumber, Selenium, Junit are been taken care by the pom file attached to the project. So no need 
to download any jars for this project 


Install and setup Maven:
http://www.mkyong.com/maven/how-to-install-maven-in-windows/

Setup Maven on eclipse:
In eclipse, maven Installation should be pointing for the location where Maven is installed

Cucumber plugin for eclipse:
Get Cucumber natural plugin for eclipse: http://rlogiacco.github.com/Natural

How to cucumber natural plugin in eclipse
Go to Help --> Install New Software...
In the Available Software dialog, set "Working With" to  http://rlogiacco.github.com/Natural
Hit Enter
Select "natural" from the Software List
Click "Next >"
On the "Install Details" page, click "Next >"
On the "Review Licence" page, select "I accept the terms of the licence agreement" and click "Finish"
When the "Security Warning" dialog appears, click "OK"
When the "Software Updates" dialog appears, click "Yes" (this will restart Eclipse)
After installing make sure the feature files are green in color. 

Install: Cucumber Eclipse Plugin
Repeat the steps from above:
In the Available Software dialog, set "Working With: http://cucumber.github.com/cucumber-eclipse/update-site


RUN TESTS :-
How to run:
To run UI tests
1. Go to src/test/java/BDDTest package and run AddItemsRunner.java as junit test. This should run the first requirement in Automation Excerise1
   To view the feature steps, go to src/test/resources/featureFiles/addItems.feature  

2. Go to src/test/java/BDDTest package and run UpdateAccountRunner.java as junit. This should run the second requirement in Automation Excerise1
      To view the feature steps, go to src/test/resources/featureFiles/updateAccount.feature

3. Go to src/test/java/BDDTest package and run EmptyCartRunner.java as junit. This should run the second requirement in Automation Excerise1
    To view the feature steps, go to src/test/resources/featureFiles/emptyCart.feature

To Run Api Test
   Go to src/test/java/BDDTest package and run ApiTestRunner.java as junit. This should run the Automation Excerise2
   To view the feature steps, go to src/test/resources/featureFiles/apiTest.feature