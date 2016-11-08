package com.test.testcases;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.PositionPage;
import com.test.util.Log;

public class TestPosition extends TestBase{

	@Test(dataProvider = "providerMethod")
	public void testAddPosition(Map<String, String> param) {
		this.simple_login(param.get("username"), param.get("password"));

		PositionPage posdriver = new PositionPage(driver); // 这是个page类的实例，不是driver
		Log.logInfo("--------------------选择职位导航菜单！----------------------");
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

		Log.logInfo("-----------------------职位城市与岗位详情！------------------------");
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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement promptok = posdriver.getElement("promptok");
		promptok.click(); // 关闭提示框
		Log.logInfo("------------------------职位新增成功！---------------------------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
