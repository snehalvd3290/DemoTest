package com.JbkOffline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseClass {

	WebDriver driver;

	@BeforeClass
	public void configueSetting() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_new3.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/Selenium%20Software/Offline%20Website/index.html");
	}
	@Test
	public void loginToDashboard() {
		WebElement email_element= driver.findElement(By.xpath("//input[@id= 'email']"));
		email_element.sendKeys("kiran@gmail.com");

		WebElement pwd_element= driver.findElement(By.xpath("//input[@id= 'password']"));
		pwd_element.sendKeys("123456");

		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
	}
}
