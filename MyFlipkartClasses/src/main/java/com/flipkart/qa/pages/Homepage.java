package com.flipkart.qa.pages;

import java.awt.AWTException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.FlipkartBase;

public class Homepage extends FlipkartBase {
	
	//This is the Flipkart Homepage. 
	
	WebElement element;
	String final_path = "";;
	String s1 = "//div[text() = '";
    String s2 = "']/preceding-sibling::div[@class = '_24_Dny']";
    JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public void searchMobile(String mob) {
		
		//This method takes the mobile name from the testdata file as parameter and search the mobiles
		
		element = driver.findElement(By.xpath("//input[@title = 'Search for products, brands and more']"));
		element.sendKeys(mob);
		action.sendKeys(Keys.ENTER).build().perform();
}
	
	public void setCriteria(String minPrice) {
		
		//This method takes the minimum price from the testdata file as parameter and filter the mobiles
		String s = "₹" + minPrice;
		System.out.println("Minimum value "+s);
		Select min = new Select(driver.findElement(By.className("_2YxCDZ")));
		min.selectByVisibleText(s);
	}
	
	public void setRAM(String raM) throws AWTException, InterruptedException {
		
		//This method takes the RAM from the testdata file as parameter and filter the mobiles
		
        Thread.sleep(2000);
        wait = new WebDriverWait(driver,30);        
        final_path =s1 + raM + s2;
        element = driver.findElement(By.xpath(final_path));
        jse.executeScript("arguments[0].click();", element);
        
	}
	
	public void setProcessor(String pros) throws InterruptedException {
		
		//This method takes the processor name from the testdata file as parameter and filter  the mobiles
		Thread.sleep(2000);
		final_path =s1 + pros + s2;		
		element = driver.findElement(By.xpath("//div[text() = 'Processor Brand']"));
		jse.executeScript("arguments[0].scrollIntoView()", element);
		jse.executeScript("arguments[0].click();", element);
		element = driver.findElement(By.xpath(final_path));
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", element);
	}
}
