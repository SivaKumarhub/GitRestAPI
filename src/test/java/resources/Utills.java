package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utills {
	
	public static RequestSpecification reqSpec;
	
	public RequestSpecification RequestRespone() throws IOException {
		if(reqSpec==null) {
		  PrintStream log = new PrintStream(new FileOutputStream("loggin.txt"));
	      reqSpec=new RequestSpecBuilder().setBaseUri(getApplicationValue("baseUrl"))
	     .setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
	     .addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	      return reqSpec;
		}
	      return reqSpec;
	}
	
	public static String getApplicationValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\aetig\\eclipse-workspace\\APIFrameWork\\src\\test\\java\\resources\\application.properties");
	    prop.load(file);
	    return prop.getProperty(key);
	}

	public String getJsonPath(Response response,String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.getString(key);
	}
}
