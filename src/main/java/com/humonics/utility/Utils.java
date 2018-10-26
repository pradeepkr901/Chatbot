package com.humonics.utility;


import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.humonics.utility.Log.log;

public class Utils {
		public static WebDriver driver = null;
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		String sBrowserName;
		try{
		sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
		System.out.println("Browser Name:"+sBrowserName);
		if(sBrowserName.equals("Chrome")){
			System.out.println("Browser is chrome");
			System.setProperty("webdriver.chrome.driver", "d:\\drivers\\chromedriver.exe" );
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//options.addArguments("--no-sandbox");
			options.addArguments("test-type=browser");
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			//options.addArguments("disable-popup-blocking");
			//options.addArguments("profile.default_content_setting_values.media_stream_mic"); 
			
			//Create prefs map to store all preferences 
			/*Map<String, Object> prefs = new HashMap<String, Object>();

			//Put this into prefs map to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create chrome options to set this prefs
			
			options.setExperimentalOption("prefs", prefs);

			//Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
			//WebDriver driver = new ChromeDriver(options);

			//Now do your further steps/options.getPlatform(Platform.WINDOWS);*/
			driver = new ChromeDriver(options);
			 driver.get(Constant.URL);
			/* Set<String> set=driver.getWindowHandles();
			Iterator it=set.iterator();
			String parentId=(String)it.next();
			String childId=(String)it.next();
			
			
			driver.switchTo().window(childId); 
			 Alert alt=driver.switchTo().alert();
			 alt.dismiss(); */
			//Thread.sleep(20000);
			WebDriverWait wait=new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[3]/button[2]")));
			driver.findElement(By.xpath("/html/body/div/div/div[3]/button[2]")).click();
			

			log.info("New driver instantiated");
		 
		    log.info("Implicit wait applied on the driver for 60 seconds");
		   
		    log.info("Web application launched successfully");
			}
		}catch (Exception e){
			log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	

	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
		
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
			} catch (Exception e){
				log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}
	 
	 
	}
