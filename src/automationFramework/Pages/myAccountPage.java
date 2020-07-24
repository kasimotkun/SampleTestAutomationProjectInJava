package automationFramework.Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.pageBase;

public class myAccountPage extends pageBase {
	
  private WebDriver driver;
  private WebDriverWait wait;
  
  @FindBy(how = How.XPATH, using = "//a[@title='\"+hashMapValue.get(\"productName\")+\"']")
  private WebElement productName;
  
  @FindBy(how = How.NAME, using = "processCarrier")
  private WebElement processCarrier;
  
  private By Submit = By.name("Submit");
  private By Proceedtocheckout1 =  By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");
  private By Proceedtocheckout2 = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
  private By processAddress = By.name("processAddress");
  private By uniformcgv = By.id("uniform-cgv"); 
  private By bankwire =By.className("bankwire");
  private By button = By.xpath("//*[@id='cart_navigation']/button");
  
   public myAccountPage(WebDriver driver, WebDriverWait wait) {
	   
	   this.driver=driver;
	   this.wait=wait;
   }

   public void checout( HashMap<String,String> hashMapValue)
   {
	   	 PageFactory.initElements(driver, this);
	   	 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(hashMapValue.get("category")))).click();
		 productName.click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(Submit)).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(Proceedtocheckout1)).click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(Proceedtocheckout2)).click();

		

		 wait.until(ExpectedConditions.visibilityOfElementLocated(processAddress)).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(uniformcgv)).click();


		 processCarrier.click();


		 wait.until(ExpectedConditions.visibilityOfElementLocated(bankwire)).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(button))
				 .click();
   }
		
	
	
	
}
