@demo
Feature: Update Account Suite

#This feature allows user to update his account
#Allows user to logn to his profile
#and then update his firstName, lastName and emailAddress.
#Logs out and logs in again 
#Verifies the same
 
  Scenario: I Update my profile
    Given I login to qaDemoPage
    |userName|vinay8887|
    |password|eOBXcE3ED5x1|
    And I edit firstName lastName and emailAddress with "vinayaKum" "Kumar" "vinay8887@gmail.com"
    And I logout of my profile
    And I login to qaDemoPage
    |userName|vinay8887|
    |password|eOBXcE3ED5x1|
    And I verify the following updated details
    |firstName|vinayaKum|
    |lastName|Kumar|
    |emailAddress|vinay8887@gmail.com|
    Then I logout and close the browser