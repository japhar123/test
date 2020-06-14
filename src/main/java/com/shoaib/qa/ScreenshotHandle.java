package com.shoaib.qa;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenshotHandle {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\SHOAIB HANNURE\\chromedriver.exe");
		driver = new ChromeDriver();// 1.Launch Chrome Browser

		driver.get("https://www.flipkart.com/");
		takeScreenshot("Flipkart_LoginPage_Screenshot"); //static method so need to create Object 
		driver.close();
	}

	/*
	 * 1.Create a public static method for Screenshot and pass Filename as a
	 * String to it. 2.On the Basis of filename Screenshot must be generated
	 */

	public static void takeScreenshot(String filename) throws IOException {

		/*
		 * 1. Take a Screenshot and store it as a File Format
		 * 
		 * Convert driver into a Screenshot. Take Screenshot is an Interface. In
		 * short typecast Take Screenshot. Convert Driver into take screenshot
		 * Interface
		 */

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		/* Copy the Screenshot to desired location using copy file method. File Utils(Files) is a Class 
		 * and used for handling all file point of view. And Copy File from source to destination */
		
		Files.copy(file,new File("D:\\javabykiran\\Basic_Screenshot_Code_Java_Selenium\\Screenshots\\"+filename+System.currentTimeMillis()+".jpeg"));
	}
}
