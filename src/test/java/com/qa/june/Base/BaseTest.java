package com.qa.june.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.june.Factory.DriverFactory;
import com.qa.june.Pages.AccountPage;
import com.qa.june.Pages.LoginPage;
import com.qa.june.Pages.ProdDetailsPage;
import com.qa.june.Pages.RegisterPage;
import com.qa.june.Pages.SearchResultsPage;

public class BaseTest {
	DriverFactory df;
	
	
	public Properties prop;
	public WebDriver d;
	public LoginPage lp;
	public AccountPage ap;
	public SearchResultsPage srp;
	public ProdDetailsPage pdp;
	public RegisterPage rp;
	
	
	@BeforeTest
	//@Parameters({"browser"})
	public void setUp()
	{
		df=new DriverFactory();
	
		prop=df.init_prop();
		d=df.init_driver(prop);
		
		lp=new LoginPage(d);
		
	}
	@AfterTest
	public void tearDown()
	{
		d.quit();
	}

}
