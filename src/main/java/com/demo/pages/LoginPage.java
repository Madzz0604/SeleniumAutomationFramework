package com.demo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.demo.driver.DriverManager;
import com.demo.enums.WaitStrategy;
import com.demo.reports.ExtentManager;
import com.demo.reports.ExtentReportsDemo;
import com.google.common.util.concurrent.Uninterruptibles;

public final class LoginPage extends BasePage{
	
	private final By textbox_username = By.name("username");
	private final By textbox_password = By.name("password");
	private final By buttonLogin = By.cssSelector("button[type=submit]");
	private final By login_title = By.cssSelector(".orangehrm-login-title");
	
	public LoginPage enterUserName(String username) {
		
		//DriverManager.getDriver().findElement(textbox_username).sendKeys(username);

		sendkeys(textbox_username,username,WaitStrategy.PRESENCE);
		//ExtentReportsDemo.test.pass("entered username");
		ExtentManager.getExtentTest().pass("entered username");
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		
		//DriverManager.getDriver().findElement(textbox_password).sendKeys(password);
		sendkeys(textbox_password,password,WaitStrategy.PRESENCE);
		ExtentManager.getExtentTest().pass("entered password");
		return this;
	}
	
	public HomePage clickLoginButton() {
		
		//DriverManager.getDriver().findElement(buttonLogin).click();
		click(buttonLogin,WaitStrategy.PRESENCE);
		return new HomePage();
	}
	
	public String getLoginTitle() {
		wait(3);
		ExtentManager.getExtentTest().pass("logout successful");
		return getTitleByText(login_title);
		
		//Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);//Alternative of thread.sleep
		//return DriverManager.getDriver().findElement(login_title).getText();
		
		
	}

}
