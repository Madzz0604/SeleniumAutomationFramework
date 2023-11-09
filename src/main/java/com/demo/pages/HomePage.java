package com.demo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import com.demo.enums.WaitStrategy;
import com.demo.reports.ExtentManager;
import com.demo.reports.ExtentReportsDemo;
import com.google.common.util.concurrent.Uninterruptibles;

public class HomePage extends BasePage{
	
	private final By user_dropdown = By.cssSelector(".oxd-userdropdown-icon");
	
	private final By link_logout = By.xpath("//a[text()='Logout']");
	
	public HomePage clickUserDropdown() {
		
		Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);//Alternative of thread.sleep
		//ExtentReportsDemo.test.pass("login successful");
		ExtentManager.getExtentTest().pass("login successful");
		click(user_dropdown,WaitStrategy.CLICKABLE);
		return this;
		
	}
	
	public LoginPage clickLogout() {
	
		click(link_logout,WaitStrategy.CLICKABLE);
		return new LoginPage();
		
	}

}
