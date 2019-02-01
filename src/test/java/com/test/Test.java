package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	static String driverpath ="F:\\selenium\\Mars\\ProjectJarFile\\chromedriver_win32 (1)\\chromedriver.exe";
	 WebDriver driver; 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", driverpath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        
        
        driver.get("https://dfaqual.tal.deere.com/DFA/");
        
        Thread.sleep(10000);
        WebElement e= driver.findElement(By.id("okta-signin-username"));
        e.sendKeys("Mk06534");
        
        Thread.sleep(10000);
        driver.quit();
        
	}

}
