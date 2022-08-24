package com.juaracoding.pageobject.main;

import javax.imageio.spi.RegisterableService;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Register;

public class MainApp {

	public static void main(String[] args) {

		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = "https://shop.demoqa.com/my-account/";
		driver.get(url);

		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		js.executeScript("arguments[0].scrollIntoView()", username);

		Login login = new Login();
		login.login("Admin", "fissa1234");
		System.out.println("Login Gagal. Kamu Belum Bikin Akun");

		Register Reg = new Register();
		Reg.register("Fissa", "fissalarasati@gmail.com", "fissa123");
		System.out.println("Kamu berhasil Registrasi");

		delay(3);
		driver.quit();

	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
