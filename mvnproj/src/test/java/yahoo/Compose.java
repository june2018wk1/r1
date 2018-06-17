package yahoo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;



public class Compose extends MainClass
{
  
  public void sendmail() throws Exception
  {
	  driver.findElement(By.xpath("//input[@class='composeicon']")).click();
     // Commons c=new Commons();
      //c.
	  Thread.sleep(3000);
	  try
	  {
		  if(driver.findElement(By.id("to")).isDisplayed())
		  {
			  log=ext.createTest("passTest");
			  log.log(Status.PASS, "Compose page is displayed");
			  takescreenshot(imagepath+"compose.png");
			  log.addScreenCaptureFromPath(imagepath+"compose.png");
		  }
	  }
	  catch(Exception e)
	  {
		  log=ext.createTest("failTest");
		  log.log(Status.FAIL, "Compose page NOT displayed");
	  }
	  
	  driver.findElement(By.id("to")).sendKeys("abcd@gmail.com");
	  driver.findElement(By.id("Subj")).sendKeys("hello");
	  driver.findElement(By.name("Content")).sendKeys("this is sample mail");
	  driver.findElement(By.id("send_top")).click();
	  
  }
  public void signout()
  {
	  driver.findElement(By.linkText("Sign Out")).click();
	  driver.close();
  }
}
