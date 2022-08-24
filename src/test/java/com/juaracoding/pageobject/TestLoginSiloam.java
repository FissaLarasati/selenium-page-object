package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginSiloam;

public class TestLoginSiloam {

	public static WebDriver driver;
	private LoginSiloam loginSiloam;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://dev.ptdika.com/siloam/panel/login/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		loginSiloam = new LoginSiloam();
	}
	
	@Test
	public void testInvalidLogin() {
		loginSiloam.login("", "");
		System.out.println(loginSiloam.getAttributeRequired());
		assertEquals(loginSiloam.getAttributeRequired(), "true");
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
