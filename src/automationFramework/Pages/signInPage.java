package automationFramework.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.pageBase;

public class signInPage extends pageBase {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public signInPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait=wait;
		
	}
	
	public myAccountPage signIn(String username, String pwd)
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(username);
		 driver.findElement(By.id("passwd")).sendKeys(pwd);
		 driver.findElement(By.id("SubmitLogin")).click();
		 
		 return new myAccountPage(driver,wait);
	}
	
	public createNewUserPage gotoCreateNewUser(String email)
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create"))).sendKeys(email);
		 driver.findElement(By.id("SubmitCreate")).click();
		 
		 return new createNewUserPage(this.driver,this.wait);
	}
	}
