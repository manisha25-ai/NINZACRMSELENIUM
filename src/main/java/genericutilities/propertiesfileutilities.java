package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesfileutilities {
	
	public String togetdatafrompropertyfiles(String key) throws IOException{
		
FileInputStream fis=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\Common_data.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
String	value=prop.getProperty(key);
		
return value;
	}

}
