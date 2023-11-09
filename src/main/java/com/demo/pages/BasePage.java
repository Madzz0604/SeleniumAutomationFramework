package com.demo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import com.demo.driver.DriverManager;
import com.demo.enums.WaitStrategy;
import com.demo.factories.ExplicitWaitFactory;
import com.google.common.util.concurrent.Uninterruptibles;

public class BasePage {
	
	

	protected void click(By by,WaitStrategy waitstrategy) {
		
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		
		DriverManager.getDriver().findElement(by).click();
		

	}
	
	protected void sendkeys(By by, String value, WaitStrategy waitstrategy) {

		ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getTitleByText(By by) {
		
		return DriverManager.getDriver().findElement(by).getText();
		
	}
    protected String getPageTitle() {
		
		return DriverManager.getDriver().getTitle();
		
	}
    
    protected void wait(int time) {
    	
    	Uninterruptibles.sleepUninterruptibly(time,TimeUnit.SECONDS);
    }
    
}
