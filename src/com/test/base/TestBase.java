package com.test.base;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.test.bean.Config;
import com.test.bean.Global;
import com.test.page.LoginPage;
import com.test.util.Log;
import com.test.util.ParseXml;
import com.test.util.Util;

public class TestBase {

	protected WebDriver driver;

	private ParseXml px;

	private Map<String, String> commonMap;

	private static WebDriver save_driver = null;

	private void initialPx(){
		if(px==null){
			px = new ParseXml("test-data/"+this.getClass().getSimpleName()+".xml");
		}
	}

	private void getCommonMap(){
		if(commonMap==null){
			Element element = px.getElementObject("/*/common");
			commonMap = px.getChildrenInfoByElement(element);
		}
	}

	private Map<String, String> getMergeMapData(Map<String, String> map1, Map<String, String> map2){
		Iterator<String> it = map2.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = map2.get(key);
			if(!map1.containsKey(key)){
				map1.put(key, value);
			}
		}
		return map1;
	}

	@DataProvider
    public Object[][] providerMethod(Method method){
		this.initialPx();
		this.getCommonMap();
		String methodName = method.getName();
		List<Element> elements = px.getElementObjects("/*/"+methodName);
		Object[][] object = new Object[elements.size()][];
		for (int i =0; i<elements.size(); i++) {
			Map<String, String> mergeCommon = this.getMergeMapData(px.getChildrenInfoByElement(elements.get(i)), commonMap);
			Map<String, String> mergeGlobal = this.getMergeMapData(mergeCommon, Global.global);
			Object[] temp = new Object[]{mergeGlobal};
			object[i] = temp;
		}
		return object;
	}

//	@BeforeClass
//	@AfterClass
//	@BeforeSuite

	@BeforeClass
	public void initialDriver(){
		if(save_driver != null){
			driver = save_driver;
		}else{
			SeleniumDriver selenium = new SeleniumDriver();
			driver = selenium.getDriver();
		}
	}
	@AfterClass
	public void saveDriver(){
		save_driver = driver;
	}

	@AfterSuite
	public void closeDriver(){
		if(driver!=null){
			driver.close();
			driver.quit();
		}
	}

	public void goTo(String url){
		driver.get(url);
		if(Config.browser.equals("chrome")){
			Util.sleep(1);
		}else if(Config.browser.equals("firefox")){
			Util.sleep(1);
		}
	}

	public void simple_login(String username, String password){
		Map<String, String> param = golbalData();
		LoginPage lp = new LoginPage(driver);
		this.goTo(param.get("url"));
		Log.logInfo("username 是 "+ username + "pwd 是" + password);
		if(username.equals(null)){
			lp.getElement("username").sendKeys(param.get("username"));
		}else{
			lp.getElement("username").sendKeys(username);
		}

		if(password.equals(null)){
			lp.getElement("password").sendKeys(param.get("password"));
		}else{
			lp.getElement("password").sendKeys(password);
		}

		Log.logInfo("点击登录");
		lp.getElement("login_button").click();
	}

	public Map<String, String> golbalData(){
		ParseXml px1 = new ParseXml("test-data/global.xml");
		Element element = px1.getElementObject("/*/common");
		Map<String, String> commonMap1 = px1.getChildrenInfoByElement(element);
		String methodName = "login";
		List<Element> elements = px1.getElementObjects("/*/"+methodName);
		Map<String, String> mergeCommon = null;
		Object[][] object = new Object[elements.size()][];
		for (int i =0; i<elements.size(); i++) {
			mergeCommon = this.getMergeMapData(px1.getChildrenInfoByElement(elements.get(i)), commonMap1);
			break;
		}

		return mergeCommon;
	}

	public static void main(String[] args){
		TestBase t = new TestBase();
//		Log.logInfo(t.golbalData());
		t.golbalData();
    }

}