package com.test;

import org.testng.annotations.Test;

import utilityfile.Log;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTestLogin {
	static String driverpath ="F:\\selenium\\Mars\\ProjectJarFile\\chromedriver_win32 (1)\\chromedriver.exe";
	 WebDriver driver; 
  @Test
  public void f() throws InterruptedException {
	  
	  Thread.sleep(10000);
      WebElement e= driver.findElement(By.id("okta-signin-username"));
      e.sendKeys("Mk06534");
      
      
   
  }
  @BeforeMethod
  public void beforeMethod() {

	  System.setProperty("webdriver.chrome.driver", driverpath);
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
      
      
      driver.get("https://dfaqual.tal.deere.com/DFA/");
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(10000);
      driver.quit();
  }

}
