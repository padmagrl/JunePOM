package com.qa.june.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.june.Util.EltUtil;

public class AccountPage {
	private WebDriver d;
	EltUtil eu;
	// 1
	private By accHeader = By.xpath("//h2[.='My Account']");
	private By headersList = By.xpath("//div[@id='content']/h2");
	private By searchInput = By.xpath("//input[@name='search']");
	private By searchBut = By.xpath("//input[@name='search']/..//button");

	AccountPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	public String getAccPageTitle() {
		return d.getTitle();
	}

	public String getAccPageHeader() {
		return eu.findElt1(accHeader).getText();
	}

	public List<String> getAccPageHeaderList() {
		List<WebElement> li = eu.findElts(headersList);
		List<String> al = new ArrayList<String>();
		for (WebElement e : li) {
			al.add(e.getText());

		}
		return al;
	}
	public SearchResultsPage doSearch(String prodName)
	{
		eu.doSendkeys(searchInput, prodName);
		eu.doClick(searchBut);
		return new SearchResultsPage(d);
	}

}
