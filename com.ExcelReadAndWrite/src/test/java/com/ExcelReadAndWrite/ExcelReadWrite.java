package com.ExcelReadAndWrite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.ReadExcel;
import com.utilities.WriteExcel;

public class ExcelReadWrite {
	WebDriver driver=null;
	int i=1;
	@Test
	public void test01() throws Exception {
		int rows = ReadExcel.getRows();
		while(rows>i) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_new3.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("file:///E:/Selenium%20Software/Offline%20Website/index.html");
			driver.manage().window().maximize();

			String username= ReadExcel.getCellData(i, 0);
			String password= ReadExcel.getCellData(i, 1);

			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//button")).click();

			if (driver.getTitle().contains("Dashboard")) {
				WriteExcel.writeData(i, 2, "PASS");
				i++;
			} else {
				WriteExcel.writeData(i, 2, "FAIL");
				i++;
			}

		}
	}
}