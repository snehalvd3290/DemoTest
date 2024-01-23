package com.JbkOffline;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UsersPage extends BaseClass {

	@Test (priority=1)
	public void openUserPage() throws Exception {
		WebElement open_page = driver.findElement(By.xpath("//a[@href='users.html']"));
		open_page.click();
		Thread.sleep(3000);

		WebElement button = driver.findElement(By.xpath("//section[2]/div/div/div/div[1]/a/button"));
		button.click();
		Thread.sleep(3000);

		driver.navigate().to("file:///E:/Selenium%20Software/Offline%20Website/pages/examples/users.html");
		driver.navigate().back();

	}

	@Test (priority=2)
	public void clickaddUser() {
		WebElement button = driver.findElement(By.xpath("//section[2]/div/div/div/div[1]/a/button"));
		button.click();
	}
	@Test (priority=3)
	public void addUser() throws Exception {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Sumit");
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("snehal@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//*[@id=\"Female\"]")).click();

		Select dropselect=new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
		dropselect.selectByVisibleText("Delhi");

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Selenium");
		driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[3]/div/input")).sendKeys("9922446996");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

		Thread.sleep(3000);
	}
	@Test (priority=4)
	public void alertHandle() {
		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
		alert.accept();
		driver.switchTo().defaultContent();

//		driver.navigate().to("file:///E:/Selenium%20Software/Offline%20Website/pages/examples/users.html");
//		driver.navigate().forward();
	}










}
