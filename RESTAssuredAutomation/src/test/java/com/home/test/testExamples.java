package com.home.test;

import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//import io.restassured.RestAssured;


public class testExamples {
	@Test
	public void tests() {
		
		Response response =get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		//Assertions
	int statuscode = response.getStatusCode();	
	Assert.assertEquals(statuscode, 200);
	}
	

	@Test
	public void test1() {
		
		baseURI ="https://reqres.in/api";
		given().
		  get("/users?page=2").
		  
		 then().
		   statusCode(200).
		   body("data[1].id", equalTo(8)).log().all();
		
		   
		
		
	}
	

}