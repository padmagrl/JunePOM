package com.qa.june.Tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.june.Base.BaseTest;
import com.qa.june.Util.Const;
import com.qa.june.Util.ErrorUtil;

public class AccountTest extends BaseTest {
	@BeforeClass
	public void accSetUp()
	{
		ap=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void AccPageHeaderTest() {
		String act = ap.getAccPageHeader();
		System.out.println(act);
		
		String exp = Const.ACC_HEADER;
		Assert.assertEquals(act, exp);
	}

	@Test
	public void ccPageHeaderListTest() {
		List<String> li = ap.getAccPageHeaderList();
		System.out.println(li);
		List<String> exp = Const.ACCPAGE_HEADERSLIST;
		System.out.println(exp);
		Collections.sort(li);
		Collections.sort(exp);
		Assert.assertEquals(li, exp);
	}

	@Test
	public void forgotPdLinkTest() {
		Assert.assertTrue(lp.iForgtLinkExist("gotten"));
	}

	@Test
	public void loginPageLoginTest() {
		ap=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(ap.getAccPageTitle());
	}

}
