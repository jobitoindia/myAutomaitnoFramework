package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(partialLinkText="Forgotten passwo")
	private WebElement fogetPass;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validatepage() {
		return userName.isDisplayed(); // return driver.getCurrentUrl("login");
		
	}
	
	public boolean validateLogin() {
		userName.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return driver.getCurrentUrl().contains("facebook");	
	}
	
	public boolean validateForgetLink() {
		fogetPass.click();
		return driver.getCurrentUrl().contains("identify");		
	}
}
