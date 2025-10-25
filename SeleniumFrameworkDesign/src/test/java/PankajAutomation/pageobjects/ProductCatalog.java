package PankajAutomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PankajAutomation.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy =By.cssSelector(".mb-3");
	By addTocart =By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName)
	
	{
		WebElement prod = getProductList().stream().filter(product-> 
		//product.findElement(By.xpath("(//img[@class='card-img-top'])[1]")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName)
	
	{
		WebElement prod = getProductName(productName);
		prod.findElement(addTocart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}

	public OrdersPage goToOrdersPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
