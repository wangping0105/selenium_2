package com.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Page extends Locator{
	
	public Page(WebDriver driver) {		
		super(driver);		
		this.setYamlFile(this.getClass().getSimpleName());
		this.getYamlFile();
	}
	
	protected Actions getAction(){
		return new Actions(driver);
	}
	
	/**
	 * 该方法为示例方法
	 */
	public void test(){
		driver.navigate().to("");
	}

}
