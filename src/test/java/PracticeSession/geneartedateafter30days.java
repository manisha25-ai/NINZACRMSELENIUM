package PracticeSession;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class geneartedateafter30days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Current date
		Date d=new Date();
		
		System.out.println(d);
		
		//to generate in dd-MM-yyy, but month always in uppercase only
		
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		//to pass the object of date in the simpledatedateformat.
		sim.format(d);
		
		System.out.println(sim.format(d));
		
		//Now calculate date.
		
		Calendar cal = sim.getCalendar();
		System.out.println(cal);
		
		//we have to add  30 days
		
		cal.add(Calendar.DAY_OF_MONTH, 30);
		
		//calculate date by using gettime method
		cal.getTime();
		
		System.out.println(cal.getTime());
		
		//Now we have to format date.\
		
		sim.format(cal.getTime());
		
		System.out.println(sim.format(cal.getTime()));
		
		
		
		
		
		

	}



}
