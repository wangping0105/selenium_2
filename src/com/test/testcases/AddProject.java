package com.test.testcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.ProjectPage;

public class AddProject extends TestBase{

	@Test (dataProvider="providerMethod")
	public void testAddProject(Map<String, String> param){
		ProjectPage pdriver = new ProjectPage(driver);
//		WebElement project = pdriver.getElement("promanagement");
		    WebElement project = pdriver.getElement("project");
		    project.click();
		    WebElement add_project = pdriver.getElement("addproject");
		    add_project.click();
		    pdriver.getElement("contractnumber").sendKeys(("contractnumber"));
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    WebElement ok = pdriver.getElement("contractok");
		    ok.click();
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    WebElement city = driver.findElement(By.xpath(".//div[2]/div[7]/div[2]/div/div"));
		    city.click();
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    WebElement choose = driver.findElement(By.xpath(".//*[@id='cityModel']/div/div/div[2]/div/a[2]"));
		    choose.click();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    WebElement shanghai = driver.findElement(By.xpath(".//*[@id='cityModel']/div/div/div[3]/button"));
		    shanghai.click();


	}

}
