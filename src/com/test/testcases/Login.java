package com.test.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.LoginPage;
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
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String errorMsg = lp.getElement("loginpwd_error").getText();
//		Assertion.verifyEquals(errorMsg, "您输入的账户名和密码不匹配，请重新输入");
//
	}
}
