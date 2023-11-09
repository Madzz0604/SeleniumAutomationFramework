package com.demo.driver;

import java.util.Objects;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.demo.constants.FrameworkConstants;
import com.demo.enums.ConfigProperties;
import com.demo.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	//private static WebDriver driver;
	
	
	public static void initDriver() throws Exception {
		
		//System.setProperty("webdriver.chrome.driver",FrameworkConstants.getCHROMEDRIVERPATH());
		if(Objects.isNull(DriverManager.getDriver())) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriverManager.chromedriver().setup();
        DriverManager.setDriver(new ChromeDriver(options));
        DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));//key value coming from enum class
        Thread.sleep(5000);
		}
	}

	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
	}}
}
