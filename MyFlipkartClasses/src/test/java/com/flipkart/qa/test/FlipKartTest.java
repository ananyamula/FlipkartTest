package com.flipkart.qa.test;

import org.testng.annotations.Test;

import com.flipkart.qa.base.FlipkartBase;
import com.flipkart.qa.pages.Homepage;
import com.flipkart.qa.pages.MobileSearchResult;
import com.flipkart.qa.util.Readxls;
import com.flipkart.qa.util.ScreenshotCapture;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterClass;

public class FlipKartTest extends FlipkartBase {
	
  //This class is to execute the Test Cases
	
  Homepage home;
  MobileSearchResult ms;
  String minPrice;
  String raM;
  String pros;

  @DataProvider
  	public Iterator<Object[]> dp() {
	ArrayList<Object[]> data = Readxls.getData(testdata, "Search");
    return data.iterator();
  }
  
  public FlipKartTest() {
	  super();
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException, AWTException {
	  initialization();
  }

  @Test(dataProvider = "dp")
  public void openHomePage(String mob,String min_price,String ram,String processor) {
	 // This method fetch the input from TestData file through the Dataprovider and serach mobile
	  minPrice = min_price;
	  raM =ram;
	  pros = processor;
	  home = new Homepage();
	  home.searchMobile(mob);
  }
  
  @Test(dependsOnMethods = {"openHomePage"})
  public void setCriteria() {
	  //TestCase : verify if minimum price Criteria is set
	  
	  home.setCriteria(minPrice);
  }
  
  @Test(dependsOnMethods = {"setCriteria"})
  public void setRAM() throws AWTException, InterruptedException {
	  
	  //TestCase : verify if RAM Criteria is set
	  
	  home.setRAM(raM);
  }
  
  @Test(dependsOnMethods = {"setRAM"})
  public void setProcessor() throws AWTException, InterruptedException {
	  
	//TestCase : verify if Processor Criteria is set
	  home.setProcessor(pros);
  }
  
  @Test(dependsOnMethods = {"setProcessor"})
  public void getTotalNoOfMobiles() throws InterruptedException {
	  
	  //TestCase :verify if Mobiles are listed based on the criteria
	  
	  ms = new MobileSearchResult();
	  ms.fetchResult();
  }
  
  @Test(dependsOnMethods = {"getTotalNoOfMobiles"})
  public void writeInCSVFile() throws InterruptedException {
	  
	  //TestCase : write the result in CSV file
	  ms.writeInCsvFile();
  }
  
  @Test(dependsOnMethods = {"writeInCSVFile"})
  public void captureScreenshot() throws InterruptedException, IOException {
	  
	  // Take Screenshot of the result
	  
	  ScreenshotCapture.takeSnapShot();
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
