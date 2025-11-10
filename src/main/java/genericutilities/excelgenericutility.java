package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelgenericutility {
	
	public String togetdatafromexcelfiles(String sheet,int row,int cell) throws IOException{
		
FileInputStream fis=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
		

Workbook wb = WorkbookFactory.create(fis);
String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
	wb.close();	
			
return value;
	}

	public int getrowcount(String Sheetname) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
		

		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return count;
		
		
	}
	
	
	public String togetdatafromexcelfiles_Products(String sheet,int row,int cell) throws IOException{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\Products_List.xlsx");
				

		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
				
			wb.close();	
			
			return value;

}
}