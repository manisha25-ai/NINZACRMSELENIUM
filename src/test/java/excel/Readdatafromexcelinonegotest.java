package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcelinonegotest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
	 Sheet sh = wb.getSheet("Products");
	 int rowcount = sh.getLastRowNum();
	 System.out.println(rowcount);
	 
	 for(int row=1;row<=rowcount;row++)
	 {
		 String data = sh.getRow(row).getCell(0).getStringCellValue();
		 
		 System.out.println(data);
	 }

	}

}
