package PankajAutomation.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import PankajAutomation.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	
	{
		//Properties prop = new Properties();

		//InputStream is = Base.class.getClassLoader().getResourceAsStream("C:/Users/lenovo/eclipse-workspace/SeleniumFrameworkDesign/src/main/resources/GlobalData.properties ");

		//String filePath = System.getProperty("user.dir") + "/src/main/resources/GlobalData.properties";
//
		//FileInputStream fis = new FileInputStream(filePath);

		//prop.load(fis);
		//String browserName = prop.getProperty("browser");
		
		//if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	
	}
		//else if (browserName.equalsIgnoreCase("edge"))
		{
			
			//System.setProperty("webdriver.edge.driver",  "edge.exe");
			//driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
		
	}
	
		public LandingPage launchApplication() throws IOException
		{
			 driver=initializeDriver();
			 LandingPage landingPage = new LandingPage(driver);
			 landingPage.goTo();
			 return landingPage;
		}
	
}

