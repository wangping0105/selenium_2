package com.test.testcases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.CandidatePage;
import com.test.util.Log;

public class TestCandidate extends TestBase{

	@Test(dataProvider = "providerMethod")
	public void testAddCandidate(Map<String, String> param) {

		this.simple_login(param.get("username"), param.get("password"));

		CandidatePage candidate_page = new CandidatePage(driver);
		Log.logInfo("--------------------选择候选人管理导航菜单！-------------------------");
		WebElement candidate = candidate_page.getElement("candidate");
		candidate.click();
		Log.logInfo("--------------------点击新增候选人！-------------------------");
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

	}


}
