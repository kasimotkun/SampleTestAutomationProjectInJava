package automationFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.pageBase;

public class homePage extends pageBase {
	
  private WebDriver driver;
  private WebDriverWait wait;
  
   public homePage(WebDriver driver, WebDriverWait wait) {
	   
	   this.driver=driver;
	   this.wait=wait;
   }

   public signInPage gotoSignInPage()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(By.className("login"))).click();
	   
	   return new signInPage(this.driver,this.wait);
   }
		
	
	
	
}
