package PankajAutomation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PankajAutomation.pageobjects.CartPage;

public class AbstractComponents {
	
	WebDriver driver; 

	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css =("[routerlink*='cart']"))
			WebElement cartHeader;
	
		public void waitForElementToAppear(By findBy)
		
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			
			}
		
		public CartPage goToCartPage()
		{
			
			cartHeader.click();
			CartPage cartpage = new CartPage(driver);
			return cartpage;
		}
		
		public void waitForElementToDisappear(WebElement ele)
		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	

}

