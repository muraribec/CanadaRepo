package com.qa.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	Properties prop;
	WebDriver driver;
	
	public void initialize_driver(Properties prop){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")){
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Please check the browser name");
		}
		
		
	}
	
	public Properties initialize_Properties(){
		
		prop= new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\LENOVO PC\\workspace\\Batch_Canada\\src\\main\\java\\com\\qa\\facebook\\configuration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;	
		
	}

}
