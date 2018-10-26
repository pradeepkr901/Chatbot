package HumonicsQA.HumonicsChatBot;

import org.apache.log4j.xml.DOMConfigurator;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HumonicsQA.HumonicsChatBot.BaseClass;
import HumonicsQA.HumonicsChatBot.Login;
import com.humonics.utility.Constant;
import com.humonics.utility.ExcelUtils;
import com.humonics.utility.Log;
import com.humonics.utility.Utils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;



public class LoginTest {
	
	public WebDriver driver;
	
	private String sTestCaseName;
	private static int iTestCaseRow;
  @Test
  public static void main1() throws WebDriverException,Exception{
	  Login.Execute(iTestCaseRow);
	 
  }
  
  
 

  
  
  
  
  
   @BeforeMethod
  public void beforeMethod() throws Exception {
	
	  	DOMConfigurator.configure("log4j.xml");

	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		new BaseClass(driver);  
      }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    Thread.sleep(100000);
	    driver.quit();
		} 
}
