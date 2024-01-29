package DataDrivanExample;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class dataPassorFail {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	
	@Test
	public void f1() {
		try {
			File src = new File("e://Excel file//testdata1.xlsx");
			FileInputStream finput = new FileInputStream(src);
			workbook = new XSSFWorkbook(finput);
			sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				driver = new ChromeDriver();
				driver.get("https://eroomrent.in/ownerlogin.php");
				cell = sheet.getRow(i).getCell(1);
				driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());
				cell = sheet.getRow(0).getCell(1);
				cell.setCellType(CellType.STRING);

				driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
				// cell.setCellType(CellType.STRING);
				WebElement we = driver.findElement(By.name("btnsubmit"));
				we.click();
				String result = "";
				if (driver.getCurrentUrl().toString().equals("https://eroomrent.in/ownerlogin.php")) {
					result = "fail";
				} else {
					result = "pass";
				}
				FileOutputStream fout = new FileOutputStream("e://Excel file//testdata1.xlsx");
				cell = sheet.getRow(i).createCell(2);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(result);
				
				workbook.write(fout);
				fout.close();
			}
		} catch (Exception EX) {
			System.out.println(EX.getMessage().toString());
		}
	}


	@BeforeTest
	public void beforeTest() {
		System.setProperty("Webdriver.chrome.driver", "c://chromedriver.exe");
		
	}

}


