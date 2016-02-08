@demo
Feature: Add Items Test Suite

#This feature file logins into the UI page and adds Apple iPhone 4S 16GB SIM-Free - Black to the car
#And Allows user to checkout items and purchase items in the cart


  Scenario: I login to demo
    Given I login to qaDemoPage
    |userName|vinay8887|
    |password|eOBXcE3ED5x1|
    Then I add following items to cart
    |Apple iPhone 4S 16GB SIM-Free - Black|
    And I checkout items present in the cart
    Then I purchase items
    Then I close my browser