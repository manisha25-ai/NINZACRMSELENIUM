package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcelinonegotest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
	excelgenericutility eu=new excelgenericutility();
	int rowcount = eu.getrowcount("Products");
	 
	 for(int row=1;row<=rowcount;row++)
	 {
		String data = eu.togetdatafromexcelfiles("Products", row, 0);
		
		 
		 System.out.println(data);
	 }

	}

}
