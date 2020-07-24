package automationFramework.Pages;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.Utils;
import automationFramework.pageBase;

public class createNewUserPage extends pageBase {
	
	private WebDriver driver;
	private WebDriverWait wait;
	

    @FindBy(how = How.ID, using = "customer_firstname")
	private WebElement customer_firstname;
    
    @FindBy(how = How.ID, using = "customer_lastname")
	private WebElement customer_lastname;
    
    @FindBy(how = How.ID, using = "passwd")
  	private WebElement password;
    
    @FindBy(how = How.ID, using = "days")
	private WebElement days;
    
    @FindBy(how = How.ID, using = "months")
	private WebElement months;
    
    @FindBy(how = How.ID, using = "years")
	private WebElement years;
    
    @FindBy(how = How.ID, using = "company")
	private WebElement company;
    
    @FindBy(how = How.ID, using = "address1")
	private WebElement address1;
    
    @FindBy(how = How.ID, using = "city")
	private WebElement city;
    
    @FindBy(how = How.ID, using = "id_state")
	private WebElement state;
    
    @FindBy(how = How.ID, using = "postCode")
	private WebElement postcode;
    
    @FindBy(how = How.ID, using = "phone")
	private WebElement phone;
    
    @FindBy(how = How.ID, using = "other")
	private WebElement other;
    
    @FindBy(how = How.ID, using = "alias")
	private WebElement alias;

    @FindBy(how = How.ID, using = "phone_mobile")
	private WebElement phone_mobile;
    
    @FindBy(how = How.ID, using = "submitAccount")
	private WebElement submitAccount;


	public createNewUserPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait=wait;
		
	}
	
	public void createNewUser(String name, String surname)
	{

		PageFactory.initElements(driver, this);
		
		String phoneNumber = Utils.getRandomNumberInRange(111111111,999999999);
		String postCode = Utils.getRandomNumberInRange(11111,99999);
		String passwd = "Gfk@"+Utils.getRandomNumberInRange(1111111,9999999);
		String address= "Street"+Utils.getRandomNumberInRange(11111111,99999999)+", No:1";
		
	
		
		 
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
		 customer_firstname.sendKeys(name);
		 
		 customer_lastname.sendKeys(surname);
		 password.sendKeys(passwd);
		 Select select = new Select(days);
		 select.selectByValue("1");
		 select = new Select(months);
		 select.selectByValue("1");
		 select = new Select(years);
		 select.selectByValue("2000");
		 company.sendKeys("Company");
		 address1.sendKeys(address);
		 city.sendKeys("Qwerty");
		 select = new Select(state);
		 select.selectByVisibleText("Colorado");
		 postcode.sendKeys(postCode);
		 other.sendKeys("Qwerty");
		 phone.sendKeys(phoneNumber);
		 phone_mobile.sendKeys(phoneNumber);
		 alias.sendKeys("gk");
		 submitAccount.click();
		 
		 

	}

	
	}
