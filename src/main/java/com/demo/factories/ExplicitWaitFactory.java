package com.demo.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.constants.FrameworkConstants;
import com.demo.driver.DriverManager;
import com.demo.enums.WaitStrategy;

public class ExplicitWaitFactory {
	
	public static void performExplicitWait(WaitStrategy waitstrategy, By by) {
		

		if(waitstrategy==WaitStrategy.CLICKABLE) {
			new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
	           .until(ExpectedConditions.elementToBeClickable(by));
			
		}
		else if(waitstrategy==WaitStrategy.PRESENCE) {
			new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
	        .until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy==WaitStrategy.VISIBLE) {
			new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
	        .until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitstrategy==WaitStrategy.NONE) {
			System.out.println("Just perform the action without any wait");
		}
	}

}
