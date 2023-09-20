package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public BaseClass() {
		
		try {
			FileInputStream fis=new FileInputStream("E:\\Java_Development\\AutomationAprilBatch\\src\\Config\\configuratinoData.properties");
			prop=new Properties();
			prop.load(fis);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startTheBrowser() {
		
		String browswerName=prop.getProperty("broswerName");
		
		if(browswerName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver-win64\\chromedriver.exe");  // set the broswer exe path
			driver=new ChromeDriver();
		}
		else if(browswerName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\softwares\\chromedriver-win64\\gecko.exe");  // set the broswer exe path
			driver=new FirefoxDriver();
		}
		else if(browswerName.contains("ie")) {
			System.setProperty("webdriver.ie.driver", "E:\\softwares\\chromedriver-win64\\ie.exe");  // set the broswer exe path
			driver=new InternetExplorerDriver();
		}
		else if(browswerName.contains("safari")) {
			System.setProperty("webdriver.safari.driver", "E:\\softwares\\chromedriver-win64\\safari.exe");  // set the broswer exe path
			driver=new SafariDriver();
		}
		else {
			System.out.println("please enter correct name of the browser");
		}
		
		driver.get(prop.getProperty("baseurl"));
		driver.manage().window().maximize();
	}
	

}
