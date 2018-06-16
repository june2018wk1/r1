package yahoo;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ReTest extends MainClass
{	
  DesiredCapabilities ds;
  
  @Test
  @Parameters({"browser"})
  public void retesting(String br) throws Exception
  {
	  if(br.matches("firefox"))
	  {		
		System.setProperty("webdriver.gecko.driver", "d:\\sel_prac\\myproj\\geckodriver.exe");
		 driver=new FirefoxDriver();	
		  //ds=DesiredCapabilities.firefox();
		  //ds.setPlatform(Platform.WINDOWS);
		  
	  }
	  if(br.matches("chrome"))
	  {
		System.setProperty("webdriver.chrome.driver", "d:\\sel_prac\\myproj\\chromedriver.exe");
	    driver=new ChromeDriver();	
		 // ds=DesiredCapabilities.chrome();
		 // ds.setPlatform(Platform.WINDOWS);
	  }	   
	                            // url of hub, desiredcap obj
	 // driver=new RemoteWebDriver(new URL("http://192.168.0.2:4444/wd/hub"), ds);
	  FileInputStream fin=new FileInputStream("d:\\sel_prac\\testdata.xlsx");  //file
	  XSSFWorkbook wb=new XSSFWorkbook(fin);  //workbook in the file
	  XSSFSheet ws=wb.getSheet("retest");  //sheet in the workbook
		
	  Row row;
	  String classname,methodname;	
	  for(int r=1;r<=ws.getLastRowNum();r++)  //for all the rows in sheet
	  {
		row=ws.getRow(r);
		if(row.getCell(5).getStringCellValue().matches("yes"))
		{
			classname=row.getCell(3).getStringCellValue();
			methodname=row.getCell(4).getStringCellValue();
			Class c=Class.forName(classname);  
			Method m=c.getMethod(methodname,null);  
			Object obj=c.newInstance();  
			m.invoke(obj,null); 			
		}
	  }
	  fin.close();
	  /*Home h=new Home(driver);
	  h.createacc();
	  h.login();
	  
	  Inbox i=new Inbox(driver);
	  i.deletemail();
	  
	  Compose c=new Compose(driver);
	  c.signout();*/
   }
  }


	 











