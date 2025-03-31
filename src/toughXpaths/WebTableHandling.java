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

public class WebTableHandling {

	public static void main(String[] args) {
		
	//	findStudentName("Java");
		
		selectHealToToe("8");

	}
	
	//find student name if subject name is given in input
	static void findStudentName(String name) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Static Table - Subject Topper')]")));
		
		
		WebElement studentTable = driver.findElement(By.xpath("//*[contains(text(), 'Static Table - Subject Topper')]"));
		studentTable.click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + name + "')]/following-sibling::td[3]")));
		
		WebElement studentName = driver.findElement(By.xpath("//td[contains(text(), '" + name + "')]/following-sibling::td[2]"));
		String textName = studentName.getText();
		System.out.println(textName);
		
		driver.quit();
	}
	
	static void selectHealToToe(String size) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		
		List<WebElement> shoeSize = driver.findElements(By.xpath("//tr//td[2]"));
		
		for(WebElement elem : shoeSize) {
			
			if(elem.getText().equals(size)) {
				
				WebElement radioButton = elem.findElement(By.xpath("./preceding-sibling::td//input[@type='radio']"));
				
				radioButton.click();
				
			}
			
		}
		
		
		
	}

}
