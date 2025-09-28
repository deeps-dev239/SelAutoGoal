package com.automation.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Page {
	
	WebDriver driver;
	

	public Page(WebDriver driver) {
		this.driver=driver;
	}
	
	public void staticdropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		dropdown1.selectByVisibleText("Price (high to low)");
		
	}

}
