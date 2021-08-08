package com.flipkart.qa.util;

import java.io.File;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.flipkart.qa.base.FlipkartBase;

public class ScreenshotCapture extends FlipkartBase {
	
	public static void takeSnapShot() throws IOException{

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(screenshotPath + System.currentTimeMillis() + ".png"));

    }

}
