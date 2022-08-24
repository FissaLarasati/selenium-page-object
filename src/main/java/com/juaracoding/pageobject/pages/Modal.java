package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Modal {

	private WebDriver driver;
	
	public Modal() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='showSmallModal']")
	private WebElement btnSmallModal;
	
	@FindBy(xpath = "//div[@id='example-modal-sizes-title-sm']")
	private WebElement txtTitleModal;
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement txtBodyModal;
	
	public void clickSmallModal() {
		btnSmallModal.click();
	}
	
	public String getTitleModal() {
		return txtTitleModal.getText();
	}
	
	public String getBodyModal() {
		return txtBodyModal.getText();
	}
	
}
