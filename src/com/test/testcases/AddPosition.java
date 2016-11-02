package com.test.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.PositionPage;

public class AddPosition extends TestBase{

	@Test (dataProvider="providerMethod")
	public void testAddPosition(Map<String, String> param){
		PositionPage posdriver = new PositionPage(driver);



	}



}
