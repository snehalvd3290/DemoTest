package com.JbkOffline;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {

	WebDriver driver;

	@BeforeClass
	public void configueSetting() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_new3.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/Selenium%20Software/Offline%20Website/index.html");
	}
	@Test
	public void loginWithEmpty_emailId() {
		WebElement email_element= driver.findElement(By.xpath("//input[@id= 'email']"));
		email_element.sendKeys(" ");
		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
		Assert.assertFalse(email_element.isDisplayed());
		Assert.assertFalse(false);
	}
	@Test
	public void loginWithWrong_emailId() {
		WebElement email_element= driver.findElement(By.xpath("//input[@id= 'email']"));
		email_element.sendKeys("abc@gmail.com");
		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
		Assert.assertTrue(email_element.isDisplayed(), "Email field is not displayed.");
		Assert.assertEquals(email_element.getAttribute("kiran@gmail.com"), "abc@gmail.com", "Invalid email is not populated in the email field.");
	}
	@Test
	public void loginWithCorrect_emailId() {
		WebElement email_element= driver.findElement(By.xpath("//input[@id= 'email']"));
		email_element.sendKeys("kiran@gmail.com");
		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
		Assert.assertTrue(email_element.isDisplayed(), "Email id is not displayed");
	}
	@Test
	public void loginWithEmpty_Password() {
		WebElement pwd_element= driver.findElement(By.xpath("//input[@id= 'password']"));
		pwd_element.sendKeys(" ");
		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
		Assert.assertTrue(pwd_element.isDisplayed(), "Password field is not displayed.");
		assertTrue(pwd_element.getAttribute("123456").isEmpty(), "Password field is not empty");
	}

	@Test
	public void loginWithWrong_Password() {
		WebElement pwd_element= driver.findElement(By.xpath("//input[@id= 'password']"));
		pwd_element.sendKeys("654321");
		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
		Assert.assertTrue(pwd_element.isDisplayed(), "Password field is not displayed");
		Assert.assertEquals(pwd_element.getAttribute("123456"), "654321", "Invalid password is not populated in the password field.");
	}
	@Test
	public void loginWithCorrect_Password() {
		WebElement pwd_element= driver.findElement(By.xpath("//input[@id= 'password']"));
		pwd_element.sendKeys("123456");
		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();	

		//		driver.navigate().to("file:///E:/Selenium%20Software/Offline%20Website/index.html");
		//		driver.navigate().forward();
	}
	@Test
	public void registerNewMember() throws Exception {
		WebElement newMem = driver.findElement(By.xpath("//a[@class= 'text-center']"));
		newMem.click();
		Thread.sleep(3000);
	} 
	@Test
	public void existingMembership() throws Exception {
		WebElement oldMem = driver.findElement(By.xpath("//a[@class='text-center']"));
		oldMem.click();
		Thread.sleep(3000);
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

