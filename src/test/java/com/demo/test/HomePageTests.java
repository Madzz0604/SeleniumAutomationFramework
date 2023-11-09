package com.demo.test;
import java.util.List;

import static org.assertj.core.api.Assertions.*; //importing static so that no need to use assertions.assertThta().We can directly use assertThat()
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.driver.Driver;
import com.demo.driver.DriverManager;

public final class HomePageTests extends BaseTest{
	
	private HomePageTests() {
		
	
		
	}
	
	
	@Test
	public void test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		//Assertions.assertThat(title)
		           assertThat(title)
		          .isNotNull()
		          .containsIgnoringCase("google search")
		          .matches("\\w.*"+"Google Search")
		          .hasSizeBetween(15, 100);
		
		List <WebElement> elements= DriverManager.getDriver().findElements(By.xpath("//h3"));
		//Assertions.assertThat(elements)
		           assertThat(elements)
		          
		         // .hasSize(4)
		        //  .extracting(e->e.getText())
		          .extracting(WebElement :: getText)
		          .contains("Testing Mini Bytes");
		           
		
       
	}


}
