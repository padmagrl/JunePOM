package com.qa.june.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.june.Util.Const;
import com.qa.june.Util.EltUtil;

public class RegisterPage {
	private WebDriver d;
	EltUtil eu;
	// 1
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);

	}

	public boolean doRegister(String firstName, String lastName, String email, String telephone, String password,
			String sub) {
		eu.doSendkeys(this.firstName, firstName);
		eu.doSendkeys(this.lastName, lastName);
		eu.doSendkeys(this.email, email);
		eu.doSendkeys(this.telephone, telephone);
		eu.doSendkeys(this.password, password);
		eu.doSendkeys(this.confirmpassword, password);
		if (sub.equalsIgnoreCase("yes")) {
			eu.doClick(subscribeYes);
		} else {
			eu.doClick(subscribeNo);
		}
		eu.doClick(agreeCheckBox);
		eu.doClick(continueButton);
		
		String mesg = eu.waitForELtPresent(sucessMessg, 5).getText();
		System.out.println("account creation : " + mesg);
		if(mesg.contains(Const.REGISTER_SUCCESS_MSG)) {
			eu.doClick(logoutLink);
			eu.doClick(registerLink);
			return true;
			
		}
		return false;

	}

}
