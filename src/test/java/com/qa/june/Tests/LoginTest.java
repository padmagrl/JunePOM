package com.qa.june.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.june.Base.BaseTest;
import com.qa.june.Util.Const;
import com.qa.june.Util.ErrorUtil;

public class LoginTest extends BaseTest {
	@Test
	public void loginPageTilteTest() {
		String act = lp.getLoginPageTilte();
		String exp = Const.LOGIN_TITLE;
		Assert.assertEquals(act, exp, ErrorUtil.LOGIN_PAGE_TITLE_ERROR);
	}

	@Test
	public void loginPageUrlTest() {
		String act = lp.getLoginPageUrl();
		String exp = Const.LOGIN_URL;
		Assert.assertEquals(act, exp, ErrorUtil.LOGIN_PAGE_URL_ERROR);
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
