package PankajAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.List;

import PankajAutomation.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
		// TODO Auto-generated constructor stub
	

	WebDriver driver;
	
	@FindBy( css= ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy (css= ".cartSection h3")
	private static List<WebElement> productTitles;

	public static Object checkoutPage;
	
	public CartPage(WebDriver driver) {
		super(driver);
	this.driver = driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	public static boolean VerifyproductDisplay(String productName) {
		
		Boolean match = productTitles.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
		}
	
	public Checkoutpage goToCheckout() {
		checkoutEle.click();
		return new Checkoutpage(driver);
		
		
	}
	
}
