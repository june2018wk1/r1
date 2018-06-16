package yahoo;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class Home extends MainClass
{
  public void open()
  {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://login.yahoo.com/?.src=ym&.intl=us&authMechanism=primary&yid=&done=https%3A%2F%2Fmail.yahoo.com%2F&eid=100&add=1"); 
  }
  public void createacc() throws Exception
  {
	open();
	driver.findElement(By.id("createacc")).click();
	
	Thread.sleep(5000);
	if(driver.findElement(By.name("firstName")).isDisplayed())
	{
		//Reporter.log("<font color='green'><b>reg page is displayed</b></font>");
		
		log=ext.createTest("passTest");
		log.log(Status.PASS, "Reg page is displayed");
		takescreenshot(imagepath+"home.png");
		log.addScreenCaptureFromPath(imagepath+"home.png");
		
	}	 
	else
	{
		//Reporter.log("<font color='red'><b>reg page not displayed</b></font>");
		log=ext.createTest("failTest");
		log.log(Status.FAIL, "Reg page NOT displayed");
		
	}
	 
	
	//driver.findElement(By.name("firstName")).sendKeys("abcd");
	//enter lastname, yahooid, select month,day, year....etc
	
  }
  public void login() throws Exception
  {
	open();	
	driver.findElement(By.name("username")).sendKeys("venkat123456a");
	driver.findElement(By.name("signin")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("password")).sendKeys("mqq987654");	
	driver.findElement(By.name("verifyPassword")).click();
  }
}
