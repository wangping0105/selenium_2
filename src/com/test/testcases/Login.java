package com.test.testcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.LoginPage;
import com.test.page.ProjectPage;
import com.test.util.Assertion;
import com.test.util.Log;

public class Login extends TestBase{

	@Test (dataProvider="providerMethod")
	public void testLogin(Map<String, String> param){
		Assertion.flag = true;
		System.out.println(param.get("url"));
		this.goTo(param.get("url"));
		LoginPage lp = new LoginPage(driver);
//
		Log.logInfo("登录密码为:"+param.get("password"));
		lp.getElement("username").sendKeys(param.get("username"));
		lp.getElement("password").sendKeys(param.get("password"));
		lp.getElement("login_button").click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String errorMsg = lp.getElement("loginpwd_error").getText();
//		Assertion.verifyEquals(errorMsg, "您输入的账户名和密码不匹配，请重新输入");
		
	}
	

	
	@Test (dataProvider="providerMethod")
	public void testMddProject(Map<String, String> param){
		ProjectPage pdriver = new ProjectPage(driver);
		    WebElement project = pdriver.getElement("project");
		    project.click();
		    WebElement add_project = pdriver.getElement("addproject");
		    add_project.click();
		    pdriver.getElement("contractnumber").sendKeys(param.get("contractnumber"));
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    WebElement ok = pdriver.getElement("contractok");
		    ok.click();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    WebElement city = pdriver.getElement("executecity");
		    city.click();
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    WebElement choose = pdriver.getElement("choosecity");
		    choose.click();
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    WebElement shanghai = pdriver.getElement("choosecityok");
		    shanghai.click();    
		    
		    Select selposition = new Select(pdriver.getElement("pospattern"));
		    selposition.selectByIndex(1); //选择岗位用工方式
	        Select selproject = new Select(pdriver.getElement("projectdesc"));
	        selproject.selectByIndex(1);  //选择项目紧急程度
	        String getcompanyname = pdriver.getElement("companyname").getText();
	        System.out.println("公司全称是："+getcompanyname);
	        pdriver.getElement("projectname").sendKeys(getcompanyname);  //填写项目名称
	        Select selmanager = new Select(pdriver.getElement("accountmanager"));
	        selmanager.selectByVisibleText("王玲");  //选择客户经理
	        WebElement prodescription = pdriver.getElement("prodescription");
	        pdriver.getElement("prodescription").sendKeys(param.get("prodescription"));  //填写项目介绍
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Select selservicetype = new Select(pdriver.getElement("servicetype"));
	        selservicetype.selectByIndex(1); //选择服务类型   
	        Select selexpstandards = new Select(pdriver.getElement("expstandards"));
	        selexpstandards.selectByIndex(2); //选择费用标准 
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        pdriver.getElement("expenses").sendKeys(param.get("expenses"));  //填写费用标准
	        pdriver.getElement("paymenttype").sendKeys("5"); //填写付费类型
	        pdriver.getElement("Percentpay").sendKeys("100"); //支付百分比
	        Select selguaranteedtime = new Select(pdriver.getElement("guaranteedtime"));
	        selguaranteedtime.selectByIndex(1); //选择质保期 
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        WebElement companyshort = pdriver.getElement("companyshort");
	        boolean flag = companyshort.isEnabled();
	        System.out.println(flag);
	        if (flag==true){
	        	System.out.println("添加公司信息");
	        }
	        Select selmonthsalary = new Select(pdriver.getElement("monthsalary"));
	        selmonthsalary.selectByIndex(1); //月薪竞争力
	        Select selprobationary = new Select(pdriver.getElement("probationary"));
	        selprobationary.selectByIndex(1); //试用期薪资
	        Select selperiod = new Select(pdriver.getElement("period"));
	        selperiod.selectByIndex(1); //调薪周期
	        Select selsocialsecurity = new Select(pdriver.getElement("socialsecurity"));
	        selsocialsecurity.selectByIndex(1); //社保公积金
	        Select selannualbonus = new Select(pdriver.getElement("annualbonus"));
	        selannualbonus.selectByIndex(1); //年终奖
	        Select selovertime = new Select(pdriver.getElement("overtime"));
	        selovertime.selectByIndex(1); //加班处理
	        pdriver.getElement("otherwelfare").sendKeys(param.get("otherwelfare"));  //其他福利
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        
	        pdriver.getElement("othermessage").sendKeys(param.get("othermessage"));  //其他信息
	        WebElement projectok = pdriver.getElement("preserved");
	        projectok.click();
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}
	
}
