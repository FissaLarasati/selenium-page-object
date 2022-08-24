package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Register {

	private WebDriver driver;

	public Register() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement email;

	@FindBy(xpath ="//input[@id='reg_password']")
	private WebElement password;

	@FindBy(xpath = "//form[@class='woocommerce-form woocommerce-form-login login']//span[@class='show-password-input']")
	private WebElement btnEye;

	@FindBy(xpath = "//form[@class='woocommerce-form woocommerce-form-register register']//span[@class='show-password-input']")
	private WebElement btnEye2;

	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnReg;

	public void register(String username, String email, String password) {
		this.username.sendKeys(username);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		btnEye.click();
		btnEye2.click();
		btnReg.click();
	}

}
