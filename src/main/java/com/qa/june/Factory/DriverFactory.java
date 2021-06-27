package com.qa.june.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver d;
	Properties prop;
	public static String highlight=null;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {
		highlight=prop.getProperty("highlight");
		OptionsManager op = new OptionsManager(prop);
		String brName=prop.getProperty("browser");
		System.out.println(prop.getProperty("browser") + "is launched");
		switch (brName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(op.getChromeOptions()));
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(op.getFireFoxOptions()));
			break;

		default:
			break;
			
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		// d.get("https://demo.opencart.com/index.php?route=account/login");
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {
		prop=new Properties();
		FileInputStream fp;
		try {
			fp = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
		
	}

}
