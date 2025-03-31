package toughXpaths;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--disable-blink-features=AutomationControlled");
		option.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		Thread.sleep(2000);
		
		WebElement close = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".commonModal__close")));
		close.click();
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
		searchButton.click();
		
		List<WebElement> time = driver.findElements(By.xpath("//div[@class='makeFlex']/div[3]/label/div/div/div/div/p\r\n"
				+ ""));
		
		for(WebElement elem : time) {
			
			String text = elem.getText();
			
			System.out.println(text);
			
		}
		
		
	}

}
