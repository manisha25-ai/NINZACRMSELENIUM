package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Howtowritedatabacktoexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
FileInputStream fis1=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
	 Sheet sh = wb.getSheet("Products");
	 Row row = sh.getRow(1);
	 //celltype==which type of data we are entering
	Cell cell = row.createCell(2,CellType.STRING);
	
	cell.setCellValue("Mobile");
	
	FileOutputStream fop=new FileOutputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
	
	//upon the workbook object, we need to call write method and pass the fop--so it will save the data.
	
	wb.write(fop);
	
	wb.close();
	 
	
	 
	

	}

	}


