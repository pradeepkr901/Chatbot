package HumonicsQA.HumonicsChatBot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.humonics.utility.Log.log;

public class BaseClass {
	public static  WebDriver driver;
	public static boolean bResult;
			public BaseClass(WebDriver driver)
			{
				BaseClass.driver=driver;
				bResult=true;
				
				//BaseClass.driver=driver;
				//InitializeWebDriver.getWebDriver(driver, log);
			
			}
			

}