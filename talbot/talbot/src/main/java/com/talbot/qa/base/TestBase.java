/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.base;

import com.talbot.util.TestUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author kohli
 */
public class TestBase {
    
    public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\kohli\\OneDrive\\Documents\\NetBeansProjects\\jan27\\talbot\\src\\main\\java\\com\\talbot\\config\\config.properties") ;
			prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static void intialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","c:\\data\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.setHeadless(true);
			op.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(op);
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
