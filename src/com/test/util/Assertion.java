package com.test.util;

import org.testng.Assert;

public class Assertion {

	public static boolean flag = true;

	public static void verifyEquals(Object actual, Object expected){
		try{
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag = false;
		}
	}

	public static void verifyEquals(Object actual, Object expected, String message){
		try{
			Log.logInfo(actual);
			Log.logInfo(expected);
			Log.logInfo(message);
			Assert.assertEquals(actual, expected, message);
		}catch(Error e){
			flag = false;
		}
	}
}