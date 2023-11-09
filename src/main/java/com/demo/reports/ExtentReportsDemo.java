package com.demo.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demo.constants.FrameworkConstants;

public final class ExtentReportsDemo {
	
	private ExtentReportsDemo() {
		
	}
	
	private static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initReports() {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("OrangeHRM Report");
		spark.config().setReportName("Selenium Framework Demo");
		}
	}
	
	public static void flushReport() throws IOException {
		if(Objects.nonNull(extent)) {
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}}
	
    public static void createTest(String testcasename) {
    	
    	ExtentManager.setExtentTest(extent.createTest(testcasename));
    }

	
	
	

}
