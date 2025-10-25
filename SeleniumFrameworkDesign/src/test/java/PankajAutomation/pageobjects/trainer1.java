package PankajAutomation.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class trainer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String productName = "ZARA COAT 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("pankaj@abc.com");
		driver.findElement(By.id("userPassword")).sendKeys("Automation123#");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));

		    WebElement prod = products.stream().filter(product->

		product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
	}

}
