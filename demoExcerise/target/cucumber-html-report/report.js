$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featureFiles/apiTest.feature");
formatter.feature({
  "id": "api-test-suite",
  "tags": [
    {
      "name": "@demo",
      "line": 1
    }
  ],
  "description": "",
  "name": "Api Test Suite",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "api-test-suite;test-case-to-query-the-nearest-station-to-austin-which-is-part-of-chargepoint-network",
  "description": "",
  "name": "test case to query the nearest station to Austin which is part of ChargePoint Network",
  "keyword": "Scenario",
  "line": 8,
  "type": "scenario",
  "comments": [
    {
      "value": "#This feature File tests API\u0027s",
      "line": 4
    },
    {
      "value": "#We use the available ApiKey and get the nearest station in austin which is part of chargePoint Network",
      "line": 6
    },
    {
      "value": "#And Later we verify whether Hyatt is present in that list",
      "line": 7
    }
  ]
});
formatter.step({
  "name": "I input my apiKey as \"4bubLC8haE5I4YEgPjfxcyc1dqWbgOGoNiEqB3Ek\"",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I search for nearest station to \"Austin\" which is part of \"ChargePoint Network\"",
  "keyword": "Given ",
  "line": 10
});
formatter.step({
  "name": "I check for \"HYATT AUSTIN\" and get its stationId",
  "keyword": "Then ",
  "line": 11
});
formatter.match({
  "arguments": [
    {
      "val": "4bubLC8haE5I4YEgPjfxcyc1dqWbgOGoNiEqB3Ek",
      "offset": 22
    }
  ],
  "location": "ApiTestStepDefs.I_input_my_apiKey_as(String)"
});
formatter.result({
  "duration": 147925503,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Austin",
      "offset": 33
    },
    {
      "val": "ChargePoint Network",
      "offset": 59
    }
  ],
  "location": "ApiTestStepDefs.I_search_for_nearest_station_to_which_is_part_of(String,String)"
});
formatter.result({
  "duration": 1100500029,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HYATT AUSTIN",
      "offset": 13
    }
  ],
  "location": "ApiTestStepDefs.I_check_for_and_get_its_stationId(String)"
});
formatter.result({
  "duration": 120478,
  "status": "passed"
});
formatter.scenario({
  "id": "api-test-suite;verify-hyatt\u0027s-street-address",
  "description": "",
  "name": "Verify Hyatt\u0027s Street Address",
  "keyword": "Scenario",
  "line": 14,
  "type": "scenario",
  "comments": [
    {
      "value": "# Get Hyatts stationId and verify its address",
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I verify HYATT\u0027s street address as \"208 Barton Springs Rd, Austin, TX, USA, 78704\" using its stationId",
  "keyword": "Then ",
  "line": 15
});
formatter.match({
  "arguments": [
    {
      "val": "208 Barton Springs Rd, Austin, TX, USA, 78704",
      "offset": 36
    }
  ],
  "location": "ApiTestStepDefs.I_verify_hyatts_street_address(String)"
});
formatter.result({
  "duration": 183501750,
  "status": "passed"
});
});