package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.excel.Xls_Reader;


public class DataDrivenTest {
	
	public static void main(String[] arg) {
		//Get data from excel	
		Xls_Reader reader = new Xls_Reader("C:\\Users\\User1\\eclipse-workspace\\javaenv\\DDDExcel\\src\\test\\java\\com\\testdata\\user.xlsx");
		
		String firstname = reader.getCellData("Sheet1", "firstname", 2);
		String lastname = reader.getCellData("Sheet1", "lastname", 2);
		String phone = reader.getCellData("Sheet1", "phone", 2);
		String email = reader.getCellData("Sheet1", "email", 2);
		String password = reader.getCellData("Sheet1", "password", 2);
		String tin = reader.getCellData("Sheet1", "tin", 2);
		
		//Driver launch
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://staging.industrybuying.com/register/");
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.xpath("//span/input[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//span/input[@name=\"phone\"]")).sendKeys(phone);
		driver.findElement(By.name("tin_no")).sendKeys(tin);
		
		
		
		driver.quit();
	}
	

}
