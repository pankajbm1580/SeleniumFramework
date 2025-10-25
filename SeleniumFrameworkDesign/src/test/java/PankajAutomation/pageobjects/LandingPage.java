package PankajAutomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajAutomation.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Passwordone;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalog loginApplication(String email, String Password)
	{
	
	userEmail.sendKeys(email);
	Passwordone.sendKeys(Password);
	submit.click();
	ProductCatalog productcatalog = new ProductCatalog(driver);
	return productcatalog;
	}
	
	public void goTo()
	
	{
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
