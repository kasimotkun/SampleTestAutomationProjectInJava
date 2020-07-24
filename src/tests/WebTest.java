package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automationFramework.Pages.*;
import automationFramework.DataProviderFromTextFile;

import automationFramework.testBase;

import java.util.Date;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(automationFramework.TestListener.class)	
public class WebTest extends DataProviderFromTextFile {


	 String existingUserEmail = "gk123@gk.com";
	 String existingUserPassword = "123456";
	// String baseUrl = "http://automationpractice.com/index.php";


	 @Test
	 public void signInTestNew(ITestContext context) {
		 

		 WebDriver driver = testSetup(context);
	
		 
		 context.setAttribute("WebDriver", driver);
		 WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		 
		 
	
		 String timestamp = String.valueOf(new Date().getTime());
		 String email = "gk_" + timestamp + "@gk" + timestamp.substring(7) + ".com";
		 String name = "Firstname";
		 String surname = "Lastname";
		 
		 homePage hmPage = new homePage(driver,wait);
		 
		 PageFactory.initElements(driver, hmPage);
		 signInPage signInPage = hmPage.gotoSignInPage();
		 
		 PageFactory.initElements(driver, signInPage);
	     createNewUserPage crtUsrPage = signInPage.gotoCreateNewUser(email);
	     
	     PageFactory.initElements(driver, crtUsrPage);
	     crtUsrPage.createNewUser(name, surname);
		

		 WebElement heading =
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		 AssertJUnit.assertEquals(heading.getText(), "MY ACCOUNT");
		 AssertJUnit.assertEquals(driver.findElement(By.className("account")).getText(), name + " " + surname);
		 AssertJUnit.assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		 AssertJUnit.assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		 AssertJUnit.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		 
		 driver.close();
	
	 }
	 
	
	 
	 @Test
	 public void logInTestNew(ITestContext context) {
		 
		 WebDriver driver = testSetup(context);
		 context.setAttribute("WebDriver", driver);
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		
		 
		
		 String fullName = "Ankit Nigam";
		 homePage hmPage = new homePage(driver,wait);
		 
		 PageFactory.initElements(driver, hmPage);
		 signInPage signInPage = hmPage.gotoSignInPage();
		 
		 PageFactory.initElements(driver, signInPage);
		 signInPage.signIn(existingUserEmail, existingUserPassword);
		 
		 WebElement heading =
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		 AssertJUnit.assertEquals("MY ACCOUNT", heading.getText());
		 AssertJUnit.assertEquals(fullName, driver.findElement(By.className("account")).getText());
		 AssertJUnit.assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		 AssertJUnit.assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		 AssertJUnit.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		 
		 driver.close();
		
	 }

	
	 @Test(dataProvider = "getDataFromTextFile", enabled=true)
	public void checkoutTestNew(ITestContext context, HashMap<String,String> hashMapValue) {
		 
		 
		 Reporter.log(hashMapValue.get("category"),true);
		 

		 Reporter.log(hashMapValue.get("productName"),true);
		 
		 WebDriver driver = testSetup(context);
		 context.setAttribute("WebDriver", driver);
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		

		 
		 homePage hmPage = new homePage(driver,wait);
		 
		 PageFactory.initElements(driver, hmPage);
		 signInPage signInPage = hmPage.gotoSignInPage();
		 
		 PageFactory.initElements(driver, signInPage);
		 myAccountPage myAccountPage = signInPage.signIn(existingUserEmail, existingUserPassword);
		
		 PageFactory.initElements(driver, myAccountPage);
		 myAccountPage.checout(hashMapValue);
		 
		
		 WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		 AssertJUnit.assertEquals("ORDER CONFIRMATION", heading.getText());


		 AssertJUnit.assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
		 AssertJUnit.assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
		 AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText()
				 .contains("Your order on My Store is complete."));
		 AssertJUnit.assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
		 driver.close();
	 }

	
}
