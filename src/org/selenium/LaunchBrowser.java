package org.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchBrowser {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hi\\eclipse-workspace\\Kalaivani\\SeleniumProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kalaivani");
		driver.findElement(By.name("pass")).sendKeys("Kalai");
		WebElement d = driver.findElement(By.id("day"));
		Select s = new Select(d);
		s.selectByValue("3");
		WebElement m = driver.findElement(By.id("month"));
		Select s1 = new Select(m);
		s1.selectByVisibleText("Feb");
		WebElement y = driver.findElement(By.id("year"));
		Select s3 = new Select(y);
		s3.selectByValue("2010");
		driver.findElement(By.id("loginbutton")).click();
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dec = new File("G:\\ScreenShots\\fb.jpeg");
		FileUtils.copyFile(src, dec);
		driver.quit();
		driver.close();
	}
}
