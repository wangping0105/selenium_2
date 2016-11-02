package com.test.testcases;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.LoginPage;
import com.test.page.PositionPage;
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



//	@Test (dataProvider="providerMethod")
//	public void testMddProject(Map<String, String> param){
//		ProjectPage pdriver = new ProjectPage(driver);
//		    WebElement project = pdriver.getElement("project");
//		    project.click();
//		    WebElement add_project = pdriver.getElement("addproject");
//		    add_project.click();
//		    pdriver.getElement("contractnumber").sendKeys(param.get("contractnumber")); //输入合同编号
//		    try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    WebElement ok = pdriver.getElement("contractok");  //导入合同信息
//		    ok.click();
//		    try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		    boolean getcontractcity = pdriver.getElement("opencontractcity").isEnabled();
//		    boolean contractcity = pdriver.getElement("opencontractcity").isDisplayed();
//		    System.out.println(getcontractcity);
//		    System.out.println(contractcity);
//	        if (getcontractcity==true){
//	        	 WebElement opencontractcity = pdriver.getElement("opencontractcity"); //选择合同执行城市
//	        	 opencontractcity.click();
//	        	  try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	 		   WebElement chocontcity = pdriver.getElement("chocontcity");  //选择合同执行城市窗口选择城市
//	 		   chocontcity.click();
//			    WebElement chocontcityok = pdriver.getElement("chocontcityok"); //关闭合同执行城市窗口
//			    chocontcityok.click();
//			    try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			    pdriver.getElement("amountadvance").sendKeys(param.get("amountadvance"));  //输入预付金额
//
//	        }
//
//		    WebElement city = pdriver.getElement("executecity"); //选择项目执行城市
//		    city.click();
//		    try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    WebElement choose = pdriver.getElement("choosecity");  //选择项目执行城市窗口选择城市
//		    choose.click();
//		    WebElement shanghai = pdriver.getElement("choosecityok"); //关闭项目执行城市选择窗口
//		    shanghai.click();
//
//		    Select selposition = new Select(pdriver.getElement("pospattern"));
//		    selposition.selectByIndex(1); //选择岗位用工方式
//	        Select selproject = new Select(pdriver.getElement("projectdesc"));
//	        selproject.selectByIndex(1);  //选择项目紧急程度
//
//	        pdriver.getElement("projectname").sendKeys(param.get("projectname"));  //填写项目名称
//	        Select selmanager = new Select(pdriver.getElement("accountmanager"));
//	        selmanager.selectByVisibleText("王玲");  //选择客户经理
//	        WebElement prodescription = pdriver.getElement("prodescription");
//	        pdriver.getElement("prodescription").sendKeys(param.get("prodescription"));  //填写项目介绍
//	        try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	        Select selservicetype = new Select(pdriver.getElement("servicetype"));
//	        selservicetype.selectByIndex(1); //选择服务类型
//	        Select selexpstandards = new Select(pdriver.getElement("expstandards"));
//	        selexpstandards.selectByIndex(2); //选择费用标准
//	        try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        pdriver.getElement("expenses").sendKeys(param.get("expenses"));  //填写费用标准
//	        pdriver.getElement("paymenttype").sendKeys("5"); //填写付费类型
//	        pdriver.getElement("Percentpay").sendKeys("100"); //支付百分比
//	        Select selguaranteedtime = new Select(pdriver.getElement("guaranteedtime"));
//	        selguaranteedtime.selectByIndex(1); //选择质保期
//	        try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        WebElement companyshort = pdriver.getElement("companyshort");
//	        boolean flag = companyshort.isEnabled();
//	        System.out.println(flag);
//	        if (flag==true){
//	        	System.out.println("添加公司信息");
//	        	pdriver.getElement("companyshort").sendKeys(param.get("companyshort")); //输入公司简称
//	        	 Select naturecompany = new Select(pdriver.getElement("naturecompany"));
//	        	 naturecompany.selectByIndex(1); //选择公司性质
//	        	  WebElement ownedindustry = pdriver.getElement("ownedindustry");
//	        	  ownedindustry.click();  //选择所属行业
//	        	  try {
//		  				Thread.sleep(1000);
//		  			} catch (InterruptedException e) {
//		  				// TODO Auto-generated catch block
//		  				e.printStackTrace();
//		  			}
//	        	  WebElement chooseindustry = pdriver.getElement("chooseindustry");
//	        	  chooseindustry.click();
//	        	  WebElement industryok = pdriver.getElement("industryok");
//	        	  industryok.click();  //关闭所属行业
//
//	        	  pdriver.getElement("creattime").sendKeys(param.get("creattime")); //成立时间
//	        	  try {
//		  				Thread.sleep(1000);
//		  			} catch (InterruptedException e) {
//		  				// TODO Auto-generated catch block
//		  				e.printStackTrace();
//		  			}
//	        	  Select investinst = new Select(pdriver.getElement("investinst"));
//	        	  investinst.selectByIndex(1); //投资机构
//	        	  Select enterprisescale = new Select(pdriver.getElement("enterprisescale"));
//	        	  enterprisescale.selectByIndex(1); //企业规模
//	        	  Select teamsize = new Select(pdriver.getElement("teamsize"));
//	        	  teamsize.selectByIndex(1); //技术团队规模
//	        	  pdriver.getElement("hrcontacts").sendKeys(param.get("hrcontacts")); //HR联系人
//	        	  pdriver.getElement("continformation").sendKeys(param.get("continformation")); //联系方式
//	        	  pdriver.getElement("companyadress").sendKeys(param.get("companyadress")); //公司地址
//	        	  pdriver.getElement("landmarknearby").sendKeys(param.get("landmarknearby")); //附近地标
//	        	  pdriver.getElement("compintroduction").sendKeys(param.get("compintroduction")); //公司介绍
//	        	  pdriver.getElement("linkwebsite").sendKeys(param.get("linkwebsite")); //官网链接
//
//	        	  try {
//		  				Thread.sleep(1000);
//		  			} catch (InterruptedException e) {
//		  				// TODO Auto-generated catch block
//		  				e.printStackTrace();
//		  			}
//	        	  System.out.println("----------上传公司logo-------------");
//	        	  WebElement upcompanylogo = pdriver.getElement("upcompanylogo"); //打开上传公司logo窗口
//	        	  upcompanylogo.click();
//	        	  try {
//		  				Thread.sleep(5000);
//		  			} catch (InterruptedException e) {
//		  				// TODO Auto-generated catch block
//		  				e.printStackTrace();
//		  			}
//	        	  boolean one = pdriver.getElement("chooselogo").isDisplayed();
//	        	  boolean two = pdriver.getElement("chooselogo").isEnabled();
//	        	  System.out.println(one);
//	        	  System.out.println(two);
////	        	  WebElement choosebutton = pdriver.getElement("choosebutton");
////	        	  choosebutton.click();
//	        	  JavascriptExecutor j= (JavascriptExecutor)pdriver;
//
//	        	  j.executeScript("document.findElementById('123').style.display='block'; ");
//	              pdriver.getElement("chooselogo").sendKeys(param.get("chooselogo")); //写入logo文件地址
//	              String url = pdriver.getElement("chooselogo").getText();
//	              try {
//	  				Thread.sleep(1000);
//	  			} catch (InterruptedException e) {
//	  				// TODO Auto-generated catch block
//	  				e.printStackTrace();
//	  			}
//	              System.out.println(url);
//	              WebElement uploadok = pdriver.getElement("uploadok");
//	              uploadok.click();
//
//	        }
//	        Select selmonthsalary = new Select(pdriver.getElement("monthsalary"));
//	        selmonthsalary.selectByIndex(1); //月薪竞争力
//	        Select selprobationary = new Select(pdriver.getElement("probationary"));
//	        selprobationary.selectByIndex(1); //试用期薪资
//	        Select selperiod = new Select(pdriver.getElement("period"));
//	        selperiod.selectByIndex(1); //调薪周期
//	        Select selsocialsecurity = new Select(pdriver.getElement("socialsecurity"));
//	        selsocialsecurity.selectByIndex(1); //社保公积金
//	        Select selannualbonus = new Select(pdriver.getElement("annualbonus"));
//	        selannualbonus.selectByIndex(1); //年终奖
//	        Select selovertime = new Select(pdriver.getElement("overtime"));
//	        selovertime.selectByIndex(1); //加班处理
//	        pdriver.getElement("otherwelfare").sendKeys(param.get("otherwelfare"));  //其他福利
//	        try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	        pdriver.getElement("othermessage").sendKeys(param.get("othermessage"));  //其他信息
//
//	        WebElement projectok = pdriver.getElement("preserved");  //保存项目
//	        projectok.click();
//	        try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	}

	@Test (dataProvider="providerMethod")
	public void testNddPosition(Map<String, String> param){
		PositionPage posdriver = new PositionPage(driver);
		WebElement project = posdriver.getElement("position");
		project.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement add_position = posdriver.getElement("addposition");
		add_position.click();
		Select selovertime = new Select(posdriver.getElement("projectname"));
        selovertime.selectByIndex(1); //选择项目名称
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
