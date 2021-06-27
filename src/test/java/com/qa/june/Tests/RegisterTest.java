package com.qa.june.Tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.june.Base.BaseTest;
import com.qa.june.Util.Const;
import com.qa.june.Util.ErrorUtil;
import com.qa.june.Util.ExcelUtil;

public class RegisterTest extends BaseTest {
	@BeforeClass
	public void accSetUp()
	{
		rp=lp.clickRegister();
	}
	@DataProvider(name="reg")
	public Object[][] getRegisterTestData() {
		Object[][] data=ExcelUtil.getTestData(Const.TESTDATA_EXCEL_PATH, Const.TESTDATA_EXCEL_SHEETNAME);
		return data;
	}
	public String getRandaomEmail()
	{
		Random r=new Random();
		String email="padma"+r.nextInt(1000)+"@gmail.com";
		return email;
	}

	@Test(dataProvider = "reg")
	public void regTest(String fname,String lname,String phone,String pwd,String sub) {
		Assert.assertTrue(rp.doRegister(fname, lname, getRandaomEmail(), phone, pwd, sub));
		
	}

	
}
