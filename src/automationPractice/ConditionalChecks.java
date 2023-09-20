package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalChecks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver-win64\\chromedriver.exe");  // set the broswer exe path
		WebDriver driver=new ChromeDriver();		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

		WebElement chkBox=driver.findElement(By.xpath("(//div[@class='col-md-4 col-sm-12'])[2]"));
		
		if(chkBox.isEnabled()) {
			System.out.println("enabled");
		}
		else{
			System.out.println("Failed");
		}
		
		
	}

}
