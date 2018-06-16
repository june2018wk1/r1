package yahoo;


import java.io.FileInputStream;

import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SanityTest extends MainClass
{
	@Test
	@Parameters({"browser"})
	public void sanityTesting(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			System.setProperty("wedriver.gecko.driver", "d:\\sel_prac\\myproj\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		if(br.matches("chrome"))
		{
			System.setProperty("wedriver.chrome.driver", "d:\\sel_prac\\myproj\\chromedriver.exe");
			 driver=new ChromeDriver();		
		 }
		  FileInputStream fin=new FileInputStream("d:\\sel_prac\\testdata.xlsx");  //file
		  XSSFWorkbook wb=new XSSFWorkbook(fin);  //workbook in the file
		  XSSFSheet ws=wb.getSheet("sanitytest");  //sheet in the workbook
			
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
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();*/
	}
}
