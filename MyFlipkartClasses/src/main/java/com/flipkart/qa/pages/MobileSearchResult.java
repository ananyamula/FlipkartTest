package com.flipkart.qa.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.FlipkartBase;
import com.opencsv.CSVWriter;

public class MobileSearchResult extends FlipkartBase {
	
	List<WebElement> price;
	List<WebElement> list;
	String[][] csvdata;
	
	public void fetchResult() throws InterruptedException {
		
		//This method fetch the list of mobiles and store in the list & also print in console
		
		wait = new WebDriverWait(driver,30);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class = '_13oc-S']")));
		price = driver.findElements(By.xpath("//div[@class = '_30jeq3 _1_WHN1']"));
		list = driver.findElements(By.xpath("//div[@class = '_4rR01T']"));
		csvdata= new String[list.size()+1][price.size()+1];
		
		if(list.size() != 0)
			System.out.println("No of phones " +list.size());
		csvdata[0][0] = "MOBILE NAME";
		csvdata[0][1] = "PRICE";
		
		 for (int i=0; i<list.size();i++)
		 {
		      
		      String str = price.get(i).getText();
		      csvdata[i+1][0] = list.get(i).getText();
		      csvdata[i+1][1] = str.substring(1);
		      System.out.println(list.get(i).getText() + " " + str.substring(1));
		      
		 }

}
	
	public void writeInCsvFile() {
		
		//This method write the output in CSV file
		 
	        try {
	           	CSVWriter csvOutput = new CSVWriter(new FileWriter(output, true));
	            for (int i = 0; i < csvdata.length; i++) {
	            	csvOutput.writeNext(csvdata[i]);
	            }
	            csvOutput.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
}
