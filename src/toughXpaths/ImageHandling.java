package toughXpaths;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImageHandling {

	public static void main(String[] args) throws InterruptedException {
		
		//clickOnEyewear();
		//getCoordinates();
		scrollToBottom();
	}
	
	static void clickOnEyewear() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2300);");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement eyeWear = wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("//img[contains(@src, 'XqaxSD9u_dca274c91343460682f8a1e31611e63d.jpg')]")));
	
	 //XqaxSD9u_dca274c91343460682f8a1e31611e63d.jpg	
		
		eyeWear.click();
		
	}
	
	static void getCoordinates() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		
//		WebElement eyeWear = wait.until(ExpectedConditions.elementToBeClickable
//				(By.xpath("//img[contains(@src, 'XqaxSD9u_dca274c91343460682f8a1e31611e63d.jpg')]")));
		
		WebElement eyeWear = driver.findElement(By.xpath("//img[contains(@src, 'XqaxSD9u_dca274c91343460682f8a1e31611e63d.jpg')]"));
		
		Point point = eyeWear.getLocation();
		int x = point.getX();
		int y = point.getY();
		System.out.println("X Coordinate is: " +x +" and Y Coordinate is " +y);
		driver.quit();
		
		//not working with this code
	}
	
	static void scrollToBottom() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollTo(0,0);");
	}


}
