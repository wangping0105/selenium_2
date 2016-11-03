package com.test.testcases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.LoginPage;
import com.test.page.PositionPage;
import com.test.page.ProjectPage;
import com.test.util.Assertion;
import com.test.util.Log;

public class Login extends TestBase {

	@Test(dataProvider = "providerMethod")
	public void testLogin(Map<String, String> param) {
		Assertion.flag = true;
		Log.logInfo(param.get("url"));
		this.goTo(param.get("url"));
		LoginPage lp = new LoginPage(driver);
		//
		Log.logInfo("登录密码为:" + param.get("password"));
		lp.getElement("username").sendKeys(param.get("username"));
		lp.getElement("password").sendKeys(param.get("password"));
		lp.getElement("login_button").click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String errorMsg = lp.getElement("loginpwd_error").getText();
		// Assertion.verifyEquals(errorMsg, "您输入的账户名和密码不匹配，请重新输入");

	}

	@Test(dataProvider = "providerMethod")
	public void testMddProject(Map<String, String> param) {
		ProjectPage project_page = new ProjectPage(driver);
		Log.logInfo("--------------------选择项目管理导航菜单！-------------------------");
		WebElement project = project_page.getElement("project");
		project.click();
		Log.logInfo("--------------------点击新增项目！-------------------------");
		WebElement add_project = project_page.getElement("addproject");
		add_project.click();
		Log.logInfo("--------------------导入合同信息！-------------------------");
		project_page.getElement("contractnumber").sendKeys("NBJZP201606241050"); // 输入合同编号
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ok = project_page.getElement("contractok"); // 导入合同信息
		ok.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------判断合同是否是第一次建项！-------------------------");
		WebElement contractcity = project_page.getElement("amountadvance");

		// 判断预付金额是否已经存在
		boolean has_contractcity = contractcity.getAttribute("disabled").equals("true");

		if (!has_contractcity){
            System.out.println("选择合同执行城市");
			WebElement opencontractcity = project_page.getElement("opencontractcity"); // 选择合同执行城市
			opencontractcity.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement chocontcity = project_page.getElement("chocontcity"); // 选择合同执行城市窗口选择城市
			chocontcity.click();
			WebElement chocontcityok = project_page.getElement("chocontcityok"); // 关闭合同执行城市窗口
			chocontcityok.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			project_page.getElement("amountadvance").sendKeys(param.get("amountadvance")); // 输入预付金额

		}

		Log.logInfo("--------------------填写项目信息！！-------------------------");
		WebElement city = project_page.getElement("executecity"); // 选择项目执行城市
		city.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement choose = project_page.getElement("choosecity"); // 选择项目执行城市窗口选择城市
		choose.click();
		WebElement shanghai = project_page.getElement("choosecityok"); // 关闭项目执行城市选择窗口
		shanghai.click();

		Select selposition = new Select(project_page.getElement("pospattern"));
		selposition.selectByIndex(1); // 选择岗位用工方式
		Select selproject = new Select(project_page.getElement("projectdesc"));
		selproject.selectByIndex(1); // 选择项目紧急程度

		project_page.getElement("projectname").sendKeys(param.get("projectname")); // 填写项目名称
		Select selmanager = new Select(project_page.getElement("accountmanager"));
		selmanager.selectByVisibleText("王玲"); // 选择客户经理
		WebElement prodescription = project_page.getElement("prodescription");
		project_page.getElement("prodescription").sendKeys(param.get("prodescription")); // 填写项目介绍
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------填写费用与质保期！-------------------------");
		Select selservicetype = new Select(project_page.getElement("servicetype"));
		selservicetype.selectByIndex(1); // 选择服务类型
		Select selexpstandards = new Select(project_page.getElement("expstandards"));
		selexpstandards.selectByIndex(2); // 选择费用标准
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project_page.getElement("expenses").sendKeys(param.get("expenses")); // 填写费用标准
		project_page.getElement("paymenttype").sendKeys("5"); // 填写付费类型
		project_page.getElement("Percentpay").sendKeys("100"); // 支付百分比
		Select selguaranteedtime = new Select(project_page.getElement("guaranteedtime"));
		selguaranteedtime.selectByIndex(1); // 选择质保期
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------第一次建项需要填写公司信息！-------------------------");
		WebElement companyshort = project_page.getElement("companyshort");
		boolean flag = companyshort.isEnabled();
		Log.logInfo(flag);
		if (flag == true) {
			Log.logInfo("添加公司信息");
			project_page.getElement("companyshort").sendKeys(param.get("companyshort")); // 输入公司简称
			Select naturecompany = new Select(project_page.getElement("naturecompany"));
			naturecompany.selectByIndex(1); // 选择公司性质
			WebElement ownedindustry = project_page.getElement("ownedindustry");
			ownedindustry.click(); // 选择所属行业
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement chooseindustry = project_page.getElement("chooseindustry");
			chooseindustry.click();
			WebElement industryok = project_page.getElement("industryok");
			industryok.click(); // 关闭所属行业

			project_page.getElement("creattime").sendKeys(param.get("creattime")); // 成立时间
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select investinst = new Select(project_page.getElement("investinst"));
			investinst.selectByIndex(1); // 投资机构
			Select enterprisescale = new Select(project_page.getElement("enterprisescale"));
			enterprisescale.selectByIndex(1); // 企业规模
			Select teamsize = new Select(project_page.getElement("teamsize"));
			teamsize.selectByIndex(1); // 技术团队规模
			project_page.getElement("hrcontacts").sendKeys(param.get("hrcontacts")); // HR联系人
			project_page.getElement("continformation").sendKeys(param.get("continformation")); // 联系方式
			project_page.getElement("companyadress").sendKeys(param.get("companyadress")); // 公司地址
			project_page.getElement("landmarknearby").sendKeys(param.get("landmarknearby")); // 附近地标
			project_page.getElement("compintroduction").sendKeys(param.get("compintroduction")); // 公司介绍
			project_page.getElement("linkwebsite").sendKeys(param.get("linkwebsite")); // 官网链接

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.logInfo("----------------------上传公司logo--------------------------");
			WebElement upcompanylogo = project_page.getElement("upcompanylogo"); // 打开上传公司logo窗口
			upcompanylogo.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean one = project_page.getElement("chooselogo").isDisplayed();
			boolean two = project_page.getElement("chooselogo").isEnabled();
			Log.logInfo(one);
			Log.logInfo(two);
			WebElement choosebutton = project_page.getElement("choosebutton");
			choosebutton.click();

			// 调用 autoit ，选择文件哦， 需要写脚本的 http://blog.csdn.net/lily_xl/article/details/51723407
			try {
				Runtime.getRuntime().exec("files/img_ico1.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.logInfo("文件上传完毕！");

			String url = project_page.getElement("chooselogo").getText();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.logInfo(url);
			WebElement uploadok = project_page.getElement("uploadok");
			uploadok.click();

		}

		Log.logInfo("--------------------填写薪资福利！-------------------------");
		Select selmonthsalary = new Select(project_page.getElement("monthsalary"));
		selmonthsalary.selectByIndex(1); // 月薪竞争力
		Select selprobationary = new Select(project_page.getElement("probationary"));
		selprobationary.selectByIndex(1); // 试用期薪资
		Select selperiod = new Select(project_page.getElement("period"));
		selperiod.selectByIndex(1); // 调薪周期
		Select selsocialsecurity = new Select(project_page.getElement("socialsecurity"));
		selsocialsecurity.selectByIndex(1); // 社保公积金
		Select selannualbonus = new Select(project_page.getElement("annualbonus"));
		selannualbonus.selectByIndex(1); // 年终奖
		Select selovertime = new Select(project_page.getElement("overtime"));
		selovertime.selectByIndex(1); // 加班处理
		project_page.getElement("otherwelfare").sendKeys(param.get("otherwelfare")); // 其他福利
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------填写执行流程！-------------------------");
		Select recomreport = new Select(project_page.getElement("recomreport"));
		recomreport.selectByIndex(1); // 推荐报告反馈周期
		Select interview = new Select(project_page.getElement("interview"));
		interview.selectByIndex(1); // 面试反馈周期
		Select written = new Select(project_page.getElement("written"));
		written.selectByIndex(1); // 是否笔试
		Select interviewtime = new Select(project_page.getElement("interviewtime"));
		interviewtime.selectByIndex(1); // 面试时间
		Select interviewprocess = new Select(project_page.getElement("interviewprocess"));
		interviewprocess.selectByIndex(1); // 面试流程
		Select offerweek = new Select(project_page.getElement("offerweek"));
		offerweek.selectByIndex(0); // offer发放周期
		project_page.getElement("othermessage").sendKeys(param.get("othermessage")); // 其他信息

		WebElement projectok = project_page.getElement("preserved"); // 保存项目
//		projectok.click();
		Log.logInfo("--------------------薪资项目成功！-------------------------");
		WebElement promptok = project_page.getElement("promptok");
		promptok.click(); // 关闭提示框
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "providerMethod")
	public void testNddPosition(Map<String, String> param) {
		PositionPage posdriver = new PositionPage(driver); // 这是个page类的实例，不是driver
		Log.logInfo("--------------------选择职位导航菜单！-------------------------");
		WebElement project = posdriver.getElement("position");
		project.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.logInfo("--------------------点击新增职位！-------------------------");
		WebElement add_position = posdriver.getElement("addposition");
		add_position.click();
		Log.logInfo("--------------------选择项目名称！-------------------------");
		Select selovertime = new Select(posdriver.getElement("projectname"));
		selovertime.selectByIndex(1); // 选择项目名称
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------填写职位信息！-------------------------");
		posdriver.getElement("positionname").sendKeys(param.get("positionname"));
		Select positionlevel = new Select(posdriver.getElement("positionlevel"));
		positionlevel.selectByIndex(2); // 岗位级别
		Select funcclass = new Select(posdriver.getElement("funcclass"));
		funcclass.selectByIndex(0); // 职能分类
		posdriver.getElement("minhandsbackg").sendKeys(param.get("minhandsbackg")); //工作经验
		posdriver.getElement("maxhandsbackg").sendKeys(param.get("maxhandsbackg")); //工作经验
		posdriver.getElement("minage").sendKeys(param.get("minage"));// 年龄
		posdriver.getElement("maxage").sendKeys(param.get("maxage"));// 年龄
		Select sex = new Select(posdriver.getElement("sex"));
		sex.selectByIndex(2); // 性别
		Select mineducation = new Select(posdriver.getElement("mineducation"));
		mineducation.selectByIndex(2); // 最低学历

		WebElement industbackground = posdriver.getElement("industbackground");
		industbackground.click(); // 选择所属行业背景
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement choosebackground = posdriver.getElement("choosebackground");
		choosebackground.click(); //选择所属行业背景
		WebElement closebackground = posdriver.getElement("closebackground");
		closebackground.click(); // 关闭所属行业背景窗口
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posdriver.getElement("jobresponsib").sendKeys(param.get("jobresponsib"));// 岗位职责
		posdriver.getElement("postqualific").sendKeys(param.get("postqualific"));// 任职资格
		posdriver.getElement("positionhigh").sendKeys(param.get("positionhigh"));//职位亮点
		WebElement positionbut = posdriver.getElement("positionbut");
		positionbut.click(); // 添加职位亮点
		posdriver.getElement("positionrequire").sendKeys(param.get("positionrequire"));//职位亮点
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("-----------------------职位城市与岗位详情！---------------------------------");
		posdriver.getElement("positionnum").sendKeys(param.get("positionnum"));//岗位人数
		Select standardcost = new Select(posdriver.getElement("standardcost"));
		standardcost.selectByIndex(1); // 费用标准
		posdriver.getElement("cost").sendKeys(param.get("cost"));//费用
		posdriver.getElement("positionmix").sendKeys(param.get("positionmix"));//职位月薪
		posdriver.getElement("positionmax").sendKeys(param.get("positionmax"));//职位月薪
		Select getmonth = new Select(posdriver.getElement("getmonth"));
		getmonth.selectByIndex(1); // 发放月数
		posdriver.getElement("reportobject").sendKeys(param.get("reportobject"));//汇报对象
		posdriver.getElement("subordinates").sendKeys(param.get("subordinates"));//下属人数
		Select workingcity = new Select(posdriver.getElement("workingcity"));
		workingcity.selectByIndex(1);// 工作城市
		posdriver.getElement("workingadrees").sendKeys(param.get("workingadrees"));//工作地点
		posdriver.getElement("consultantsnum").sendKeys(param.get("consultantsnum"));//顾问人数
		Select consultantslevel = new Select(posdriver.getElement("consultantslevel"));
		consultantslevel.selectByIndex(1); // 顾问最低级别
		Select publicjobseeker = new Select(posdriver.getElement("publicjobseeker"));
		publicjobseeker.selectByIndex(1); // 是否对求职者公开
		WebElement positionok = posdriver.getElement("positionok");
	    positionok.click(); // 保存职位

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement promptok = posdriver.getElement("promptok");
		promptok.click(); // 关闭提示框
		Log.logInfo("------------------------职位新增成功！---------------------------------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
