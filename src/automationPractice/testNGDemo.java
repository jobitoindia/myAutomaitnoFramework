package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNGDemo {
WebDriver driver;
	
	@BeforeMethod
	public void initiateBrowser() {		
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver-win64\\chromedriver.exe");  // set the broswer exe path
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.zoho.in/signin?servicename=ZohoHome&signupurl=https://www.zoho.com/signup.html");
	}
	
	
	@Test(dataProvider = "usersBulkData")
	public void validateUsers(String uName,String password) throws InterruptedException 
	{
		Thread.sleep(3000);
		WebElement userName=driver.findElement(By.xpath("//input[@id='login_id']"));
		userName.sendKeys(uName);
		
		WebElement nextBtn=driver.findElement(By.xpath("//button[@id='nextbtn']"));
		nextBtn.click();
		
		Thread.sleep(3000);
		
		WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys(password);
		
		nextBtn.click();
		Thread.sleep(5000);
		
		WebElement validatePage=driver.findElement(By.xpath("//div[text()='Bigin']"));
		
		Assert.assertEquals(validatePage.isDisplayed(), true);	
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
