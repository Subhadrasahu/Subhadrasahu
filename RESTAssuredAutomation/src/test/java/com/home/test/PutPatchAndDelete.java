package com.home.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDelete {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {
		
//Added JSON object to get the value in JSON format
		JSONObject request = new JSONObject();
		request.put("name","Malay");
		request.put("job","Developer");


		baseURI ="https://reqres.in";
		given().
		 header("Content-Type","application/json").
		 //Sending content type to server as JSON and accept Json
		 contentType(ContentType.JSON).accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		  patch("/api/users/2").
		  then().
		  statusCode(200)
		  .log().all();
	}

	@Test
	public void testPut() {
		
		//Added JSON object to get the value in JSON format
				JSONObject request = new JSONObject();
				request.put("name","Subha");
				request.put("job","Tester");


				baseURI ="https://reqres.in";
				given().
				 header("Content-Type","application/json").
				 //Sending content type to server as JSON and accept Json.
				 contentType(ContentType.JSON).accept(ContentType.JSON).
				 body(request.toJSONString()).
				when().
				  put("/api/users/2").
				  then().
				  statusCode(200)
				  .log().all();
			}
	
	@Test
	public void testDelete() {
		
    			baseURI ="https://reqres.in";
				
				when().
				  delete("/api/users/2").
				  then().
				  statusCode(204)
				  .log().all();
			}
}
