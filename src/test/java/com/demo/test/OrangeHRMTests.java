package com.demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.reports.ExtentReportsDemo;

public final class OrangeHRMTests extends BaseTest {
	
	private OrangeHRMTests() {
		
	}
	
	@Test
	public void login() throws InterruptedException {
		
		//LoginPage login = new LoginPage();
		
		ExtentReportsDemo.createTest("test1");
		String actualTitle=new LoginPage()
				          .enterUserName("Admin").enterPassword("admin123").clickLoginButton()
				          .clickUserDropdown().clickLogout()
				          .getLoginTitle();//method chaining
	
		Assert.assertEquals(actualTitle, "Login");
	}

}
