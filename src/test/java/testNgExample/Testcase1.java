package testNgExample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Testcase1 {
	static String driverpath ="F:\\selenium\\Mars\\ProjectJarFile\\chromedriver_win32 (1)\\chromedriver.exe";
	 WebDriver driver; 
  @Test
  public void f() {
	  
	 driver.findElement(By.name("q")).sendKeys("webdriver");
	  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", driverpath);
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
      
      driver.get("https://www.google.com/?gws_rd=ssl");
      Thread.sleep(10000);
      
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
