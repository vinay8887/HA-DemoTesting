@demo
Feature: Api Test Suite

#This feature File tests API's

#We use the available ApiKey and get the nearest station in austin which is part of chargePoint Network
#And Later we verify whether Hyatt is present in that list
  Scenario: test case to query the nearest station to Austin which is part of ChargePoint Network
  Given I input my apiKey as "4bubLC8haE5I4YEgPjfxcyc1dqWbgOGoNiEqB3Ek"
  Given I search for nearest station to "Austin" which is part of "ChargePoint Network"
  Then I check for "HYATT AUSTIN" and get its stationId
  
# Get Hyatts stationId and verify its address
  Scenario: Verify Hyatt's Street Address
     Then I verify HYATT's street address as "208 Barton Springs Rd, Austin, TX, USA, 78704" using its stationId
  