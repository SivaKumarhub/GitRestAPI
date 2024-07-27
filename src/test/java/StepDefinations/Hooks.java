package StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

@Before("@DeletePlace")	
 public void befoeScenario() throws IOException {
	 placeValidationsStepDef p = new placeValidationsStepDef();
	 if(placeValidationsStepDef.placeID==null) {
	 p.add_place_api_payload_with("manu", "telugu", "telagana");
	 p.user_hits_addplace_api_with_http_post_request("AddPlaceAPI", "POST");
	 p.verify_place_id_created_maps_to_using("manu", "GetPlaceAPI");
	 }
	 }

}
