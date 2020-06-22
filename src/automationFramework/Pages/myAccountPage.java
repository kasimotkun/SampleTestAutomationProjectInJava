package automationFramework.Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.pageBase;

public class myAccountPage extends pageBase {
	
  private WebDriver driver;
  private WebDriverWait wait;
  
   public myAccountPage(WebDriver driver, WebDriverWait wait) {
	   
	   this.driver=driver;
	   this.wait=wait;
   }

   public void checout( HashMap<String,String> hashMapValue)
   {
	   
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(hashMapValue.get("category")))).click();
		 driver.findElement(By.xpath("//a[@title='"+hashMapValue.get("productName")+"']")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(
				 By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(
				 By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();

		

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();


		 driver.findElement(By.name("processCarrier")).click();


		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button")))
				 .click();
   }
		
	
	
	
}
