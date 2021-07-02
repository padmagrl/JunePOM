package com.qa.june.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.june.Util.EltUtil;

public class PadmaPage {
	private WebDriver d;
	EltUtil eu;
	// 1
	private By accHeader = By.xpath("//h2[.='My Account']");
	private By headersList = By.xpath("//div[@id='content']/h2");
	private By searchInput = By.xpath("//input[@name='search']");
	private By searchBut = By.xpath("//input[@name='search']/..//button");

	PadmaPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	
}
