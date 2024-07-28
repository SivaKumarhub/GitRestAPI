Feature: place api validations

 @AddPlace @Regession
  Scenario Outline: add api place validation
    Given add place Api payload with "<name>" "<language>" "<address>"
    When user hits "AddPlaceAPI" with http "POST" request
    Then vaidate status code is "200"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place id created maps to "<name>" using "GetPlaceAPI"
Examples:
   | name | language | address|
   | Nikki | english  | banglore |
   | Kokku | telugu  | nandyal |
      
     @GetPlace @Regession
   Scenario: verify get Place api functionality
      Given get place api payload
      When user hits "GetPlaceAPI" with http "Get" request
      Then vaidate status code is "200"
      And "status" in response body is "OK"        
      
   @editPlace @Regession
   Scenario: verify Updeditate Place api functionality
      Given edit place api payload
      When user hits "UpdatePlaceAPI" with http "POST" request
      Then vaidate status code is "200"
      And "status" in response body is "OK"  
      
     @GetNewPlace @Regession
   Scenario: verify get new Place api functionality
      Given get new place api payload
      When user hits "GetPlaceAPI" with http "Get" request
      Then vaidate status code is "200"
      And "status" in response body is "OK" 