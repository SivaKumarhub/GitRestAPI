package StepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utills;

import static org.junit.Assert.*;

public class placeValidationsStepDef extends Utills {
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestData getData =new TestData();
	static String placeID;
	@Given("add place Api payload with {string} {string} {string}")
	public void add_place_api_payload_with(String name, String lang, String address) throws IOException {	    
	     res = given().spec(RequestRespone()).body(getData.addPlacePayload(name,lang,address));
	}

	@When("user hits {string} with http {string} request")
	public void user_hits_addplace_api_with_http_post_request(String resource,String method) {
		
	APIResources resAPI = APIResources.valueOf(resource);	
	 resSpec= new ResponseSpecBuilder().log(LogDetail.ALL).expectStatusCode(200)
	    		  .expectContentType(ContentType.JSON).build();
	 if(method.equalsIgnoreCase("GET")) {
		 response = res.when().get(resAPI.getAPIResource());
	 } else if(method.equalsIgnoreCase("POST")) {
	 response = res.when().post(resAPI.getAPIResource());
	}
		
	}

	@Then("vaidate status code is {string}")
	public void vaidate_status_code_is(String string) {
		assertEquals(response.statusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
        assertEquals(value,getJsonPath(response,key));
	}
	
	@Then("verify place id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String resource) throws IOException {
      placeID = getJsonPath(response,"place_id");
      res = given().spec(RequestRespone()).queryParam("place_id", placeID);
      user_hits_addplace_api_with_http_post_request(resource,"get"); 
      assertEquals(response.statusCode(),200);
      assertEquals(name,getJsonPath(response,"name"));
      
	}
	
	@Given("delete place api payload")
	public void delete_place_api_payload() throws IOException {
       res = given().spec(RequestRespone()).body(getData.deletePlacePayload(placeID));
	}
}
