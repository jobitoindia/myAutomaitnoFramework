package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidereDemo 
{	
	WebDriver driver;
	
	@BeforeMethod
	public void launchingtheBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver-win64\\chromedriver.exe");  // set the broswer exe path
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.zoho.in/signin?servicename=ZohoHome&signupurl=https://www.zoho.com/signup.html");	
	}	
	
	@Test(dataProvider = "usersBulkData")
	public void validateusers(String un,String password) throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement username =driver.findElement(By.xpath("//input[@id='login_id']"));
		username.sendKeys(un);
	
		Thread.sleep(3000);
		WebElement nextbtn=driver.findElement(By.xpath("//button[@id='nextbtn']"));
		nextbtn.click();
		
		Thread.sleep(3000);
		WebElement pass =driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys(password);
		
		nextbtn.click();
		Thread.sleep(3000);
		String homUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(homUrl.contains("home"), true);
	}
	
	
	@DataProvider(name="usersBulkData")
	public Object[][] userData(){
		return new Object[][] {
			{"abc@gmail.com","abc@123"},
			{"lahupande2017@gmail.com","abcxyz@12345"},
			{"abc1@gmail.com","abc1@123"},
			{"abc2@gmail.com","abc2@123"},
			{"abc3@gmail.com","abc3@123"},
			{"abc4@gmail.com","abc4@123"},
			{"abc5@gmail.com","abc5@123"},
			{"abc6@gmail.com","abc6@123"},
		};
		
	}
}
