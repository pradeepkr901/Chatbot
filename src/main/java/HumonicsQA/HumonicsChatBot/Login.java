package HumonicsQA.HumonicsChatBot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import com.humonics.utility.Constant;
import com.humonics.utility.ExcelUtils;
import com.humonics.utility.Utils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.humonics.utility.Log.log;

public class Login extends BaseClass {	
	
	
		public Login(WebDriver driver)
		{
			super(driver);
		}
		
		  public static void audioValidationSuccessful() throws SocketException
		  {		
		  	RestAssured.baseURI ="https://bot.humonics.ai:3090/auth/";
		  	RequestSpecification request = RestAssured.given();

		  	JSONObject requestParams = new JSONObject();
		  	requestParams.put("username", "bharat"); // Cast
		  	requestParams.put("password", "Admin@123");
		  	requestParams.put("audio","");
		  	
		  	Response response = request.post("/login");

		  	int statusCode = response.getStatusCode();
		  	Assert.assertEquals(statusCode, "200");
		  	String successCode = response.jsonPath().get("SuccessCode");
		  	Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		  }

	public static void Execute(int iTestCaseRow) throws Exception{
		//Utils.OpenBrowser(iTestCaseRow);
    	
    	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
    	// Here we are sending the UserName string to the UserName Textbox on the logIN Page
    	Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.name("username")));
        actions.click();
        actions.sendKeys(sUserName);
        //actions.build().perform();
        
        // Printing the logs for what we have just performed
        log.info(sUserName+" is entered in UserName text box" );
        
        String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
        System.out.println(sPassword);
        actions.moveToElement(driver.findElement(By.name("password")));
        actions.click();
        actions.sendKeys(sPassword);
        actions.build().perform();
        
        
       
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='cover-caption']/div/div[1]/div[2]/div/div[2]/div/div/div/i[1]"))).click();
        /*Alert alt=driver.switchTo().alert();
		alt.accept(); */
        Wait wait = new FluentWait<WebDriver>(driver)
        		.withTimeout(20, TimeUnit.SECONDS)
        		.pollingEvery(10, TimeUnit.SECONDS)
        		.ignoring(NoSuchElementException.class);
        
        //audioValidationSuccessful();
        
        
             wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cover-caption']/div/div[1]/div[3]/input")));
             WebElement element=driver.findElement(By.xpath("//*[@id='cover-caption']/div/div[1]/div[3]/input"));
             element.click();
        	
        
        
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cover-caption']/div/div[1]/div[2]/div/div[2]/div/div/div/i[1]"))).click();
        //actions.build().perform();
        log.info("Click action is performed on Login button");
        
        // Now it will wait 10 secs separately before jumping out to next step
        try {
      		Thread.sleep(2000);
      	} catch (InterruptedException e) {
      		e.printStackTrace();
      	}
        
        
        
        Reporter.log("Login Action is successfully perfomred");
        
    }
	
		
}
