package com.demo.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demo.driver.Driver;
import com.demo.reports.ExtentReportsDemo;

public class BaseTest {
	
     protected BaseTest() {
		
	}
	
     @BeforeSuite
     protected void setUpExtentReport() {
    	 
    	 ExtentReportsDemo.initReports();
     }
	@BeforeMethod
	protected void setup() throws Exception {
	
		Driver.initDriver();
	}
	
	@AfterMethod
	protected void closeBrowser() {
		Driver.quitDriver();
		}
	
	@AfterSuite
	protected void flushReport() throws IOException {
		ExtentReportsDemo.flushReport();
		
	}
	

}
