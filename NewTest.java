package DataDrivanExample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class NewTest {
	
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	
  @Test
  public void f() {
	  driver.get("https://eroomrent.in/ownerlogin.php");
  }
  @Test
  public void f1() {
	  try {
	  File src = new File("e://Excel file//testdata.xlsx");
	  FileInputStream finput = new FileInputStream(src);
	  workbook = new XSSFWorkbook(finput);
	  sheet = workbook.getSheetAt(0);
	  for(int i=1; i<=sheet.getLastRowNum(); i++) {
		  cell = sheet.getRow(i).getCell(1);
		  driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());
		  cell= sheet.getRow(0).getCell(1);
		  cell.setCellType(CellType.STRING);
		  
		  driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
		//  cell.setCellType(CellType.STRING);
		  WebElement we = driver.findElement(By.name("btnsubmit"));
		  we.click();
		  finput.close();
		  FileOutputStream fout = new FileOutputStream(src);
		  workbook.write(fout);
		  fout.close();
	  }
	  }catch (Exception EX){
		  System.out.println(EX.getMessage().toString());
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.manage().window().maximize();
	  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("Webdriver.chrome.driver", "c://chromedriver.exe");
		 driver = new ChromeDriver();
	}	 
		 
//=======================================================================================
  
  /*
	WebDriver driver;
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	
@Test
public void f() {
	  driver.get("https://eroomrent.in/ownerlogin.php");
}
@Test
public void f1() {
	  try {
	  File src = new File("e://Excel file//testdata.xlsx");
	  FileInputStream finput = new FileInputStream(src);
	  workbook = new XSSFWorkbook(finput);
	  sheet = workbook.getSheetAt(0);
	  for(int i=1; i<=sheet.getLastRowNum(); i++) {
		  cell = sheet.getRow(i).getCell(1);
		  driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());
		  cell= sheet.getRow(0).getCell(1);
		  cell.setCellType(CellType.STRING);
		  
		  driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
		//  cell.setCellType(CellType.STRING);
		  WebElement we = driver.findElement(By.name("btnsubmit"));
		  we.click();
		 
		  String s1="";
		  s1="pass";
		  XSSFRow row = sheet.getRow(1);
		  XSSFCell cell = row.createCell(2);
		  cell.setCellValue(s1);
		  
		  finput.close();
		  FileOutputStream fout = new FileOutputStream(src);
		  workbook.write(fout);
		  fout.close();
	  }
	  }catch (Exception EX){
		  System.out.println(EX.getMessage().toString());
	  }
}
@BeforeMethod
public void beforeMethod() {
	  driver.manage().window().maximize();
	  }

@BeforeTest
public void beforeTest() {
	  System.setProperty("Webdriver.chrome.driver", "c://chromedriver.exe");
		 driver = new ChromeDriver();
	}
	*/
}


