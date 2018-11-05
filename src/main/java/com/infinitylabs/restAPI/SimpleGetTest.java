package com.infinitylabs.restAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

/*	@Test
	public void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}*/

/*	@Test
	public void GetWeatherDetails()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Get the status code from the Response. In case of 
		// a successfull interaction with the web service, we
		// should get a status code of 200.
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode, actual value,200  expected value  "Correct status code returned");
	}*/
	
	
	
/*	@Test
	public void GetWeatherDetailsInvalidCity()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/78789798798");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode actual value, 200 expected value, "Correct status code returned");
	}
	*/
	/*@Test
	public void GetWeatherStatusLine()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		
		// Get the status line from the Response and store it in a variable called statusLine
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine actual value, "HTTP/1.1 200 OK" expected value, "Correct status code returned");
	}*/
	
/*	@Test
	public void getWeatherHeaders()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.get("/Hyderabad");
		//Get the headers
		String contentType=response.getHeader("Content-Type");
		System.out.println("Content-Type :"+contentType);
		String server=response.getHeader("Server");
		System.out.println("Server Type :"+server);
		String contentEncoding=response.getHeader("Content-Encoding");
		System.out.println("Content-Encoding type:"+contentEncoding);
	}*/
	
/*	@Test
	public void getWeatherAllHeaders()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.get("/Hyderabad");
		//Get the all headers
		Headers allHeader=response.getHeaders();
		for ( Header header: allHeader)
		{
			System.out.println("Key:"+header.getName()+","+"Value:"+header.getValue());
		}
		
		
	}*/
	/*@Test
	public void GetWeatherHeaders()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
	 
		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType  actual value , "application/json"  expected value );
	 
		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType =  response.header("Server");
		Assert.assertEquals(serverType  actual value , "nginx/1.14.0"  expected value );
	 
		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding  actual value , "gzip"  expected value );
	}*/
	


/*@Test
	public void WeatherMessageBody()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
	 
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
	 
		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Hyderabad") Expected value, true Actual Value, "Response body contains Hyderabad");
	}*/
	
	/*@Test
	public void DisplayAllNodesInWeatherAPI()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		System.out.println(response.asString());
		System.out.println("---------------------------------------------------------------------------------");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + jsonPathEvaluator.get("City"));

		// Print the temperature node
		System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));

		// Print the humidity node
		System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));

		// Print weather description
		System.out.println("Weather description received from Response " + jsonPathEvaluator.get("WeatherDescription"));

		// Print Wind Speed
		System.out.println("Windspeed  received from Response " + jsonPathEvaluator.get("WindSpeed"));

		// Print Wind Direction Degree
		System.out.println("wind direction degree  received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
	}*/
	
/*	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimp2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "sample2ee77d90@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().asString());
	}*/
/*	
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "63userf2d3d2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed26dff39@gmail.com");
	 
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
	 
		ResponseBody body = response.getBody();
	 
		// Deserialize the Response body into RegistrationSuccessResponse
		RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
	 
		// Use the RegistrationSuccessResponse class instance to Assert the values of 
		// Response.
		Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
		Assert.assertEquals("Operation completed successfully", responseBody.Message);
	}
	*/
/*	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "65userf2d3d2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed296dff39@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());

		if(response.statusCode() == 200)
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);	
		}
		else if (response.statusCode() == 201)
		{
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	
		}	
	}
	*/
	
}