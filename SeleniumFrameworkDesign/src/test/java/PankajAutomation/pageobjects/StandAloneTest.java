package PankajAutomation.pageobjects;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PankajAutomation.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class StandAloneTest extends BaseTest{
	@Test(dataProvider ="getData", groups= {"Purchase"})
	public void submitorder(String email, String password) throws IOException 
	{
		// TODO Auto-generated method stub

	String productName = "ZARA COAT 3";
	LandingPage landingPage = launchApplication();
		WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	
	ProductCatalog productcatalog = landingPage.loginApplication(email, password);
	productcatalog.addProductToCart(productName);
	CartPage cartPage = productcatalog.goToCartPage();
	Boolean match = CartPage.VerifyproductDisplay(productName);
	Assert.assertTrue(match);
	Checkoutpage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry("india");
	ConfirmationPage confirmationpage = checkoutPage.submitOrder();
	String confirmMessage = confirmationpage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
		}

	@Test (dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		LandingPage landingPage = null;
		@SuppressWarnings("null")
		ProductCatalog productcatalog = landingPage.loginApplication("pankaj@abc.com", "Automation123#");
		OrdersPage ordersPage = productcatalog.goToOrdersPage();
		Object productName = null;
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	public String getScreenshot(String testCaseName) throws IOException	
	{
		
		TakeScreenshot ts = (TakeScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" +testCaseName+ ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	@DataProvider
	public Object[] [] getData()
	{
		return new Object[] []	{{"pankaj@abc.com", "Automation123#"},{"niraj@abc.com", "Testing124#"}};
	}

	{
		driver.close();
	}
}
