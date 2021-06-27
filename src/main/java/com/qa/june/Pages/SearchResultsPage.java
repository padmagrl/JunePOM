package com.qa.june.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.june.Util.EltUtil;

public class SearchResultsPage {
	// 1
	private By searchRes = By.xpath("//div[@class='caption']//a");
	private By addToCart = By.xpath("//a[.='MacBook']/../..//following-sibling::div//span[.='Add to Cart']");
	private By shoppingCart = By.xpath("//a[.='shopping cart']");

	public By getaddToCartXpath(String proName) {
		By xpath = By.xpath("//a[.='" + proName + "']/../..//following-sibling::div//span[.='Add to Cart']");
		return xpath;
	}

	private WebDriver d;
	EltUtil eu;

	public SearchResultsPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);

	}

	public int getProdResCount() {
		return eu.findElts(searchRes).size();
	}

	public ProdDetailsPage clickOnrodFromearchResults(String reqProd) {
		List<WebElement> li = eu.findElts(searchRes);
		for (WebElement e : li) {
			if (e.getText().contains(reqProd)) {
				e.click();
				break;
			}

		}
		return new ProdDetailsPage(d);
	}

	public void clickOnAddToCart(String reqProd) {

		eu.doClickItemFromList(getaddToCartXpath(reqProd), reqProd);
	}

}
