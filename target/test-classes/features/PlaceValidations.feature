Feature: place api validations

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
     