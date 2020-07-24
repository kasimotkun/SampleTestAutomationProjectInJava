package automationFramework.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.pageBase;

public class signInPage extends pageBase {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how = How.ID, using = "passwd")
	private WebElement passwd;	
	
	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement SubmitLogin;	

	@FindBy(how = How.ID, using = "SubmitCreate")
	private WebElement SubmitCreate;
	
	private By email = By.id("email");
	
	private By email_create = By.id("email_create");
	
	public signInPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait=wait;
		
	}
	
	public myAccountPage signIn(String username, String pwd)
	{
		 PageFactory.initElements(driver, this);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(username);
		 passwd.sendKeys(pwd);
		 SubmitLogin.click();
		 
		 return new myAccountPage(driver,wait);
	}
	
	public createNewUserPage gotoCreateNewUser(String email)
	{
		 PageFactory.initElements(driver, this);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(email_create)).sendKeys(email);
		 SubmitCreate.click();
		 
		 return new createNewUserPage(this.driver,this.wait);
	}
	}
