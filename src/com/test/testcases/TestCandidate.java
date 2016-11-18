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
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
		String name = candidate_page.getElement("candidatename").getText();
		String sex = candidate_page.getElement("candidatesex").getText();
		String mobile = candidate_page.getElement("candidatephone").getText();
		String maile = candidate_page.getElement("candidatemaile").getText();
		String age = candidate_page.getElement("candidateage").getText();
		String worktime = candidate_page.getElement("candidatetime").getText();
		String marry = candidate_page.getElement("candidatemarry").getText();
		String workcity = candidate_page.getElement("candidatecity").getText();
		String twolevelcity = candidate_page.getElement("candidatetwolevel").getText();
		System.out.println(name);
		System.out.println(sex);
		System.out.println(mobile);
		System.out.println(maile);
		System.out.println(age);
		System.out.println(worktime);
		System.out.println(marry);
		System.out.println(workcity);
		System.out.println(twolevelcity);
		if (name==""){
		candidate_page.getElement("candidatename").sendKeys(param.get("candidatename"));
		}
		if (sex==""){
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
		if (worktime==""){
			Select candidatetime = new Select(candidate_page.getElement("candidatetime"));
			candidatetime.selectByIndex(1); // 工作年限
			}
		if (marry==""){
			Select candidatemarry = new Select(candidate_page.getElement("candidatemarry"));
			candidatemarry.selectByIndex(1); // 婚姻状况
			}
		if (workcity==""){
			Select candidatecity = new Select(candidate_page.getElement("candidatecity"));
			candidatecity.selectByVisibleText("上海市"); //工作地区
			}
		if (twolevelcity==""){
			Select candidatetwolevel = new Select(candidate_page.getElement("candidatetwolevel"));
			candidatetwolevel.selectByVisibleText("上海市"); //工作地区二级地区
			}

		WebElement candidatesave = candidate_page.getElement("candidatesave");

		candidatesave.click();
	}


}
