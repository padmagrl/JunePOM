package com.qa.june.Tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.june.Base.BaseTest;

public class ProdDetailsTest extends BaseTest {
	SoftAssert so=new SoftAssert();
	@BeforeClass
	public void searchResSetUp() {
		ap = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		srp = ap.doSearch("MacBook");
		pdp = srp.clickOnrodFromearchResults("MacBook Pro");

	}
	@Test
	public void ProdHeaderTest() {
		System.out.println(pdp.getProdHeader("MacBook Pro"));
	}

	@Test
	public void ProdImgCountTest() {
		System.out.println(pdp.getProdImgCount("MacBook Pro"));
	}
	@Test
	public void ProductInfoMapTest()
	{
		Map<String, String> map=pdp.getProductInfoMap("MacBook Pro");
		map.forEach((K,V)->System.out.println(K+"---->"+V));
		so.assertEquals(map.get("Name"), "MacBook Pro");
		so.assertEquals(map.get("Brand"), "Apple");
		so.assertEquals(map.get("Product Code"), "Product 19");
		so.assertEquals(map.get("Price"), "$2,000.00");
		so.assertAll();
	}

}
