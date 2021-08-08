package com.flipkart.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public static Actions action;
	public static String testdata;
	public static String output;
	public static String screenshotPath;
		
	public static void initialization() throws InterruptedException, AWTException {	
		
		//This is the Base class. The Initialization method opens the Flipkart URL & read all the data from Properties file
		
		prop = new Properties();
		
		try {
		FileInputStream ip= new FileInputStream("C:\\Users\\smula46\\eclipse-workspace\\MyFlipkartClasses\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		prop.load(ip);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String path = prop.getProperty("url");
		String chromePath = prop.getProperty("chromeDriverPath");
		testdata = prop.getProperty("testdataPath");
		output = prop.getProperty("outputPath");
		screenshotPath = prop.getProperty("screenshot_Path");
		
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(path);
		Thread.sleep(2000);
		
		action = new Actions(driver);
		//action.sendKeys(Keys.ESCAPE).build().perform();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
	}

}
