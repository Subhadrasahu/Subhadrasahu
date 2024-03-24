package com.home.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetPostExamples {

	@Test
	
	public void testGet()
	{
		baseURI ="https://reqres.in/api";
		given().
		  get("/users?page=2").
		 
		then().
		  statusCode(200).
	      body("data[4].first_name",equalTo("George")).
		  body("data[4].last_name",equalTo("Edwards")).
		  body("data[4].email",equalTo("george.edwards@reqres.in")).
		  body("data[4].id",equalTo(11)).
		  body("data[4].avatar",equalTo("https://reqres.in/img/faces/11-image.jpg")).
		  body("data.last_name",hasItems("Edwards","Howell","Funke","Ferguson"));
		 
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {
		Map<String,Object> map = new HashMap<String,Object>();
		
	    map.put("name","Sbhadra");
     	map.put("job", "Tester");
		System.out.println(map);
//Added JSON object to get the value in JSON format
		JSONObject request = new JSONObject();
		request.put("name","Malay");
		request.put("job","Developer");

//To show the  values in JSOn format		
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in/api";
		given().
		 header("Content-Type","application/json").
		 //Sending content type to server as JSON and accept Json
		 contentType(ContentType.JSON).accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		  post("/users").
		  then().
		  statusCode(201)
		  .log().all();
	}
}
