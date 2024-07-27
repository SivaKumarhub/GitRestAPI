package resources;

import java.util.ArrayList;
import java.util.List;

import pojoClasses.PojoAddPLaceLocation;
import pojoClasses.PojoAddPlace;

public class TestData {

	public PojoAddPlace addPlacePayload(String name, String lang, String address) {
	     PojoAddPlace p = new PojoAddPlace();
	     p.setAccuracy(50);
	     p.setName(name);
	     p.setPhone_number("(+91) 983 893 3937");
	     p.setAddress(address);
	     p.setWebsite("http://google.com");
	     p.setLanguage(lang);
	     
	     List<String> myList = new ArrayList<String>();
	     myList.add("shoe park");
	     myList.add("shop");
	     
	     p.setTypes(myList);
	     
	     PojoAddPLaceLocation l = new PojoAddPLaceLocation();
	     l.setLat(-38.383494);
	     l.setLng(33.427362);
	     
	     p.setLocation(l);
	     
	     return p;
	}
	
	public String deletePlacePayload(String placeId) {
		return "{\r\n"
	       		+ "		    \"place_id\":\""+placeId+"\"\r\n"
	       		+ "		}";
	}
}
