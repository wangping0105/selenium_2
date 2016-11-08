package com.test.testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.ProjectPage;
import com.test.util.Log;

public class TestProject extends TestBase{

	//@Test(dataProvider = "providerMethod")
	public void testAddProject(Map<String, String> param) {
		this.simple_login(param.get("username"), param.get("password"));

		ProjectPage project_page = new ProjectPage(driver);
		Log.logInfo("--------------------选择项目管理导航菜单！-------------------------");
		WebElement project = project_page.getElement("project");
		project.click();
		Log.logInfo("--------------------点击新增项目！-------------------------");
		WebElement add_project = project_page.getElement("addproject");
		add_project.click();
		Log.logInfo("--------------------导入合同信息！-------------------------");
		project_page.getElement("contractnumber").sendKeys(param.get("contractnumber")); // 输入合同编号
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
		boolean has_contractcity = false;
        try {
        	has_contractcity = contractcity.getAttribute("disabled").equals("true");
        	System.out.println(has_contractcity);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select selposition = new Select(project_page.getElement("pospattern"));
		selposition.selectByIndex(1); // 选择岗位用工方式
		Select selproject = new Select(project_page.getElement("projectdesc"));
		selproject.selectByIndex(1); // 选择项目紧急程度
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project_page.getElement("projectname").sendKeys(param.get("projectname")); // 填写项目名称
		Select selmanager = new Select(project_page.getElement("accountmanager"));
		selmanager.selectByVisibleText("王玲"); // 选择客户经理
		WebElement prodescription = project_page.getElement("prodescription");
		project_page.getElement("prodescription").sendKeys(param.get("prodescription")); // 填写项目介绍
		try {
			Thread.sleep(2000);
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
			Thread.sleep(2000);
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
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------第一次建项需要填写公司信息！-----------------------");
		WebElement companyshort = project_page.getElement("companyshort"); 	// 判断公司简称是否可写
		boolean has_companyshort = false;
        try {
        	has_companyshort = companyshort.getAttribute("disabled").equals("true");
        	System.out.println(has_companyshort);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!has_companyshort){
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
			Log.logInfo("----------------------上传公司logo----------------------");
			WebElement upcompanylogo = project_page.getElement("upcompanylogo"); // 打开上传公司logo窗口
			upcompanylogo.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.logInfo("文件上传完毕！");

			WebElement uploadok = project_page.getElement("uploadok");
			uploadok.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		projectok.click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.logInfo("--------------------薪资项目成功！-------------------------");
		WebElement promp = project_page.getElement("promptext");
		String promptext = promp.getText();
		System.out.println(promptext);
		Assert.assertEquals(promptext, param.get("promptext"));
		WebElement promptok = project_page.getElement("promptok");
		promptok.click(); // 关闭提示框
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "providerMethod")
	public void testexecuteTab(Map<String, String> param){
		this.simple_login(param.get("username"), param.get("password"));
		ProjectPage project_page = new ProjectPage(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.logInfo("--------------------选择项目管理导航菜单！-------------------------");
		WebElement project = project_page.getElement("project");
		project.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.logInfo("--------------------获取执行中列表数据！-------------------------");
          int row = 1;
          int column = 1;
          String tab = ".//div[1]/table/tbody/tr";
          String path=".//div[1]/table/tbody/tr[1]/td";
//		  String xpath=".//div[1]/table/tbody/tr["+row+"]/td["+column+"]";
		  //得到table表中所有行对象，并得到所要查询的行对象。
	      List<WebElement> trs = driver.findElements(By.xpath(tab));
	      int trNumber = trs.size();
	      List<WebElement> tds = driver.findElements(By.xpath(path));
	      int tdNumber = tds.size();
	      WebElement trtext = trs.get(1);
	      System.out.println(trNumber);
          System.out.println(tdNumber);
          String[] titleArr = new String[]{"项目名称","所属KA","职位数量","顾问人数","岗位需求","推荐量","参面量","offer量","已入职","待入职","启动时间","已执行天数","岗位余量"};
          Hashtable<String,String> ht = new Hashtable<String,String>();
         int k = 0;
//          for (int i = 1; i <= trNumber; i++) {
            for (int j = 1; j <= tdNumber; j++) {
            String targ = path+"[" + j + "]";
            WebElement shuzhi = driver.findElement(By.xpath(targ));
            String data = shuzhi.getText();
            String title = titleArr[k];
            System.out.println(data);
            ht.put(title, data);
            k++;
//            }
           }
		   System.out.println(ht);

	}

	 /** 从一个table的单元格中得到文本值. 参数tableCellAddress的格式为
    row.column, 行列从0开始.
    @param by  用于得到table对象
    @param tableCellAddress 一个单元格地址, 如. "1.4"
    @return 从一个table的单元格中得到文本值
    */
//    public String getCellText(By by,String tableCellAddress) {
//        //得到table元素对象
//        WebElement table = driver.findElement(by);
//        //对所要查找的单元格位置字符串进行分解，得到其对应行、列。
//        int index = tableCellAddress.trim().indexOf('.');
//        int row =  Integer.parseInt(tableCellAddress.substring(0, index));
//        int cell = Integer.parseInt(tableCellAddress.substring(index+1));
//        //得到table表中所有行对象，并得到所要查询的行对象。
//         List<WebElement> rows = table.findElements(By.tagName("tr"));
//         WebElement theRow = rows.get(row);
//         //调用getCell方法得到对应的列对象，然后得到要查询的文本。
//         String text = getCell(theRow, cell).getText();
//         return text;
//    }
//    private WebElement getCell(WebElement Row,int cell){
//         List<WebElement> cells;
//         WebElement target = null;
//         //列里面有"<th>"、"<td>"两种标签，所以分开处理。
//         if(Row.findElements(By.tagName("th")).size()>0){
//            cells = Row.findElements(By.tagName("th"));
//            target = cells.get(cell);
//         }
//         if(Row.findElements(By.tagName("td")).size()>0){
//            cells = Row.findElements(By.tagName("td"));
//            target = cells.get(cell);
//         }
//        return target;
//
//    }

}
