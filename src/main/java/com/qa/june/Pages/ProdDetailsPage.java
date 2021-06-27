package com.qa.june.Pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.june.Util.EltUtil;

public class ProdDetailsPage {
	// 1
	private By prodHeader = By.xpath("//h1[.='MacBook Pro']");
	private By priceHeader = By
			.xpath("((//h1[.='MacBook Pro']/../..//following-sibling::ul[@class='list-unstyled'])[2]//li)[1]");
	private By prodImages = By.xpath("//a[@class='thumbnail']");
	private By prodMetaData = By
			.xpath("(//h1[.='MacBook Pro']/../..//following-sibling::ul[@class='list-unstyled'])[1]//li");
	private By prodPriceData = By
			.xpath("(//h1[.='MacBook Pro']/../..//following-sibling::ul[@class='list-unstyled'])[2]//li");
	// 2
	private WebDriver d;
	EltUtil eu;

	public ProdDetailsPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// xpath methods
	private By getProdeaderXapth(String ProName) {
		return By.xpath("//h1[.='" + ProName + "']");
	}

	private By getProdMetaDataXapth(String ProName) {
		return By.xpath("(//h1[.='" + ProName + "']/../..//following-sibling::ul[@class='list-unstyled'])[1]//li");
	}

	private By getProdPriceDataXapth(String ProName) {
		return By.xpath("(//h1[.='" + ProName + "']/../..//following-sibling::ul[@class='list-unstyled'])[2]//li");
	}

	// 3
	public String getProdHeader(String ProName) {
		return eu.findElt(getProdeaderXapth(ProName)).getText();
	}

	public String getPriceHeader() {
		return eu.doGetText(priceHeader);
	}

	public int getProdImgCount(String ProName) {
		return eu.findElts(prodImages).size();
	}

	public Map<String, String> getProductInfoMap(String ProName) {
		Map<String, String> hm = new LinkedHashMap<String, String>();
		// Meta
		List<WebElement> li = eu.findElts(prodMetaData);
		Set<WebElement> metaSet=li.stream().collect(Collectors.toSet());
		
		for (WebElement e : li) {
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaVal = meta[1].trim();
			hm.put("Name", getProdHeader(ProName));
			hm.put(metaKey, metaVal);

		}
		// Price
		List<WebElement> pl = eu.findElts(prodPriceData);
		String price=pl.get(0).getText().trim();
		String Exprice=pl.get(1).getText().trim();
		String ExpriceVal=Exprice.split(":")[1];

		hm.put("Price", price);
		hm.put("Exprice", ExpriceVal);

		return hm;

	}

}
