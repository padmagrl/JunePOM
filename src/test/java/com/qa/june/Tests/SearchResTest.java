package com.qa.june.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.june.Base.BaseTest;
import com.qa.june.Util.Const;

public class SearchResTest extends BaseTest {
	@BeforeClass 
	public void searchResSetUp()
	{
		ap=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		srp=ap.doSearch("MacBook");
		
	}
	@Test
	public void clickOnrodFromearchResultsTest ()
	{
		pdp=srp.clickOnrodFromearchResults("MacBook Pro");
		String h=pdp.getProdHeader("MacBook Pro");
		Assert.assertEquals(h, Const.PRO_HEADER);
		
	}
	
	

}
