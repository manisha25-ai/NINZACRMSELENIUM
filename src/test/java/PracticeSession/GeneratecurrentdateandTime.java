package PracticeSession;

import java.util.Date;

public class GeneratecurrentdateandTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d=new Date();
		
		System.out.println(d);
		
		//: replace with _ and space with _ , method chaining used
		String date = d.toString().replace(":", "_").replace(" ","_");
		
		System.out.println(date);
		

	}

}
