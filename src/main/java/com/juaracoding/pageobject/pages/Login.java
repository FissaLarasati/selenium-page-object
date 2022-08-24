package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Login {

	private WebDriver driver;
	
	public Login() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='rememberme']")
	private WebElement btnRemember;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin;
	
	public void login (String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		btnRemember.click();
		btnLogin.click();
	}
	
}
