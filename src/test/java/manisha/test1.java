package manisha;

import java.io.IOException;

import genericutilities.propertiesfileutilities;

public class test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		propertiesfileutilities prop=new propertiesfileutilities();
		String url = prop.togetdatafrompropertyfiles("url");
		
		System.out.println(url);

	}

}
