@demo
Feature: Empty Cart Test Suite

#This feature checks whether cart is empty, if so will send a message saying Cart is empty
  Scenario: I login to demo
   Given I login to qaDemoPage
    |userName|vinay8887|
    |password|eOBXcE3ED5x1|
   Then I add following items to cart
    |Apple iPhone 4S 16GB SIM-Free - Black|
    |Apple iPhone 4S 32GB SIM-Free - White|
    |iPhone 5|
   Then I check whether my cart is empty
   Then I close my browser