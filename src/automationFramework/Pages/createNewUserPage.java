package automationFramework.Pages;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.pageBase;

public class createNewUserPage extends pageBase {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public createNewUserPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait=wait;
		
	}
	
	public void createNewUser(String name, String surname)
	{
		
		String phoneNumber = getRandomNumberInRange(111111111,999999999);
		String postCode = getRandomNumberInRange(11111,99999);
		String passwd = "Gfk@"+getRandomNumberInRange(1111111,9999999);
		String address= "Street"+getRandomNumberInRange(11111111,99999999)+", No:1";
		
	
		
		 
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
		 driver.findElement(By.id("customer_firstname")).sendKeys(name);
		 driver.findElement(By.id("customer_lastname")).sendKeys(surname);
		 driver.findElement(By.id("passwd")).sendKeys(passwd);
		 Select select = new Select(driver.findElement(By.id("days")));
		 select.selectByValue("1");
		 select = new Select(driver.findElement(By.id("months")));
		 select.selectByValue("1");
		 select = new Select(driver.findElement(By.id("years")));
		 select.selectByValue("2000");
		 driver.findElement(By.id("company")).sendKeys("Company");
		 driver.findElement(By.id("address1")).sendKeys(address);
		 driver.findElement(By.id("city")).sendKeys("Qwerty");
		 select = new Select(driver.findElement(By.id("id_state")));
		 select.selectByVisibleText("Colorado");
		 driver.findElement(By.id("postcode")).sendKeys(postCode);
		 driver.findElement(By.id("other")).sendKeys("Qwerty");
		 driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		 driver.findElement(By.id("phone_mobile")).sendKeys(phoneNumber);
		 driver.findElement(By.id("alias")).sendKeys("gk");
		 driver.findElement(By.id("submitAccount")).click();
		 
		 

	}
	private static String getRandomNumberInRange(long min, long max) {

		Random r = new Random();
		return String.valueOf(r.longs(min, (max + 1)).limit(1).findFirst().getAsLong());

	}
	
	}
