package com.qa.june.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.june.Util.EltUtil;

public class LoginPage {
	private WebDriver d;
	EltUtil eu;
	// 1
	private By login = By.xpath("(//a[.='Login'])[3]");
	By register = By.xpath("(//a[.='Register'])[2]");
	By rtPanelLinks = By.xpath("//div[@class='list-group']/a");
	By forgot = By.xpath("(//a[.='Forgotten Password'])[2]");
	By email = By.name("email");
	By pass = By.name("password");
	By loginBut = By.xpath("//input[@value='Login']");
	By Register = By.xpath("//div[@class='list-group']/a[contains(.,'Register')]");
	//XPATH methos
	public By getXpathOFLinkFromRightSidePanel(String textVal)
	{
		return By.xpath("//div[@class='list-group']/a[contains(.,'"+textVal+"')]");
		
	}

	// 2
	public LoginPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	public String getLoginPageTilte() {
		return d.getTitle();

	}

	public String getLoginPageUrl() {
		return d.getCurrentUrl();

	}

	public boolean iForgtLinkExist(String linkName) {
		return eu.findElt(forgot).isDisplayed();
	}

	public AccountPage doLogin(String username, String password) {
		eu.doSendkeys(email, username);
		eu.doSendkeys(pass, password);
		eu.doClick(loginBut);
		return new AccountPage(d);
	}
	public RegisterPage clickRegister() {
		eu.doClick(getXpathOFLinkFromRightSidePanel("Register"));
		return new RegisterPage(d) ;
	}

}
