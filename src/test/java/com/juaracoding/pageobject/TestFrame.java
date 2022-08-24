package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleFrame;

public class TestFrame {

	public static WebDriver driver;
	private SampleFrame sampleFrame;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/frames";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		sampleFrame = new SampleFrame();
	}
	
	@Test
	public void testFrame() {
		System.out.println(sampleFrame.getTxtOutFrame());
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println(sampleFrame.getTxtFrame());
		String txtFrame = sampleFrame.getTxtFrame();
		assertTrue(txtFrame.contains("sample page"));
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
