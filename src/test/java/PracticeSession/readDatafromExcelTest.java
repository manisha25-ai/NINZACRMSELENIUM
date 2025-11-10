package PracticeSession;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDatafromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
	Sheet sheet = wb.getSheet("sheet1");
	Row row = sheet.getRow(1);
	Cell cell = row.getCell(2);
	String Campaign = cell.getStringCellValue();
	String Targetsize = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
	wb.close();
	
	System.out.println(Campaign);
	System.out.println(Targetsize);

	}

}
