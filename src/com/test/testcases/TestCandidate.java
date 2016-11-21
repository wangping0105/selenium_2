package com.test.testcases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.CandidatePage;
import com.test.util.Log;

public class TestCandidate extends TestBase{

	@Test(dataProvider = "providerMethod")
	public void testAddCandidate(Map<String, String> param) {

		this.simple_login(param.get("username"), param.get("password"));

		CandidatePage candidate_page = new CandidatePage(driver);
		Log.logInfo("-------------------选择候选人管理导航菜单！----------------------");
		WebElement candidate = candidate_page.getElement("candidate");
		candidate.click();
		Log.logInfo("---------------------点击新增候选人！-------------------------");
		WebElement add_candidate = candidate_page.getElement("addcandidate");
		add_candidate.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.logInfo("----------------------上传候选人的简历----------------------");
		WebElement upresume = candidate_page.getElement("upresume"); // 打开上传简历的窗口
		upresume.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement choosecandidate = candidate_page.getElement("choosecandidate");
		choosecandidate.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 调用 autoit ，选择文件哦， 需要写脚本的 http://blog.csdn.net/lily_xl/article/details/51723407
		try {
			Runtime.getRuntime().exec("files/candidate_ico1.exe");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.logInfo("--------------------简历正在上传！---------------------");

		WebElement upcandidateok = candidate_page.getElement("upcandidateok");
		upcandidateok.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");

		String name = candidate_page.getElement("candidatename").getAttribute("value");
		String sex = new Select(candidate_page.getElement("candidatesex")).getFirstSelectedOption().getText();
		String mobile = candidate_page.getElement("candidatephone").getAttribute("value");
		String maile = candidate_page.getElement("candidatemaile").getAttribute("value");
		String age = candidate_page.getElement("candidateage").getAttribute("value");
		String worktime = new Select(candidate_page.getElement("candidatetime")).getFirstSelectedOption().getText();
		String marry = new Select(candidate_page.getElement("candidatemarry")).getFirstSelectedOption().getText();
		String workcity = new Select(candidate_page.getElement("candidatecity")).getFirstSelectedOption().getText();
		String twolevelcity = new Select(candidate_page.getElement("candidatetwolevel")).getFirstSelectedOption().getText();;

		if (name==""){
		candidate_page.getElement("candidatename").sendKeys(param.get("candidatename"));
		}
		if (sex.equals("请选择")){
			Select candidatesex = new Select(candidate_page.getElement("candidatesex"));
			candidatesex.selectByIndex(1); // 性别
			}
		if (mobile==""){
			candidate_page.getElement("candidatephone").sendKeys(param.get("candidatephone"));
			}
		if (maile==""){
			candidate_page.getElement("candidatemaile").sendKeys(param.get("candidatemaile"));
			}
		if (age==""){
			candidate_page.getElement("candidateage").sendKeys(param.get("candidateage"));
			}
		if (worktime.equals("请选择")){
			Select candidatetime = new Select(candidate_page.getElement("candidatetime"));
			candidatetime.selectByIndex(1); // 工作年限
			}
		if (marry.equals("请选择")){
			Select candidatemarry = new Select(candidate_page.getElement("candidatemarry"));
			candidatemarry.selectByIndex(1); // 婚姻状况
			}
		if (workcity.equals("请选择")){
			Select candidatecity = new Select(candidate_page.getElement("candidatecity"));
			candidatecity.selectByVisibleText("上海市"); //工作地区
			}
		if (twolevelcity.equals("请选择")){
			Select candidatetwolevel = new Select(candidate_page.getElement("candidatetwolevel"));
			candidatetwolevel.selectByVisibleText("上海市"); //工作地区二级地区
			}

		WebElement candidatesave = candidate_page.getElement("candidatesave");
		candidatesave.click(); //保存个人信息

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String direction = candidate_page.getElement("technicaltext").getText();
        System.out.println(direction);
        if (direction.equals("")){
		WebElement technicaldirection = candidate_page.getElement("technicaldirection");
		technicaldirection.click();  //打开技术方向窗口
		WebElement choosedirection = candidate_page.getElement("choosedirection");
		choosedirection.click();  //技术方向窗口选择一个技术方向
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        String direction2 = candidate_page.getElement("technicaltext").getAttribute("value");
        System.out.println(direction2);

		WebElement directionok = candidate_page.getElement("directionok");
		directionok.click();  //关闭技术方向窗口

//		WebElement expectedindustry = candidate_page.getElement("expectedindustry");
//		expectedindustry.click();  //打开期望行业窗口
//		WebElement chooseindustry = candidate_page.getElement("chooseindustry");
//		chooseindustry.click();  //期望行业窗口选择一个期望行业
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		WebElement industryok = candidate_page.getElement("industryok");
//		industryok.click();  //关闭期望行业窗口
//
//		WebElement expectedcity = candidate_page.getElement("expectedcity");
//		expectedcity.click();  //打开期望城市窗口
//		WebElement choosecity = candidate_page.getElement("choosecity");
//		choosecity.click();  //期望城市窗口选择一个期望城市
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		WebElement expectedcityok = candidate_page.getElement("expectedcityok");
//		expectedcityok.click();  //关闭期望城市窗口

		WebElement careerintention = candidate_page.getElement("careerintention");
		careerintention.click();  //提交职业意向

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
