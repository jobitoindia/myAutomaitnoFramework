package automationPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException, IOException  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver-win64\\chromedriver.exe");  // set the broswer exe path
		
		FileInputStream fis=new FileInputStream("D:\\test.xlsx");

		Workbook wb=new XSSFWorkbook(fis);
		
		Sheet sh=wb.getSheet("Sheet1");
		
		int rowCount=sh.getLastRowNum()-sh.getFirstRowNum();
		
		for(int i=0;i<=rowCount;i++) {
			
			Row rw=sh.getRow(i);
			
			for(int j=0;j<=rw.getLastCellNum();j++) {
				System.out.println(rw.getCell(j).getStringCellValue()+ " ");
			}
		}
	
		wb.close();
		fis.close();
		
	}

}
