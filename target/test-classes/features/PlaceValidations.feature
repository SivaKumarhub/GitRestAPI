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
   
  @DeletePlace @Regession
   Scenario: verify delete api functionality
      Given delete place api payload
      When user hits "DeletePlaceAPI" with http "POST" request
      Then vaidate status code is "200"
      And "status" in response body is "OK"
      
    @UpdatePlace @Regession
   Scenario: verify Update Place api functionality
      Given update place api payload
      When user hits "UpdatePlaceAPI" with http "POST" request
      Then vaidate status code is "200"
      And "status" in response body is "OK"  
      
     @GetPlace @Regession
   Scenario: verify get Place api functionality
      Given get place api payload
      When user hits "GetPlaceAPI" with http "Get" request
      Then vaidate status code is "200"
      And "status" in response body is "OK"        