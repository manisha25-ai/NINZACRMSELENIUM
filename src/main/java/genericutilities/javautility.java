package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	
	public String getdate(int days)
	{
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
		
		//we have to add  30 days
		
		cal.add(Calendar.DAY_OF_MONTH, days);
		
		//calculate date by using gettime method
		cal.getTime();
		
		System.out.println(cal.getTime());
		
		//Now we have to format date.
		
		String Expecteddate = sim.format(cal.getTime());
		
		return Expecteddate;
	}
	
	
	public int generateninedigitnumber() {
		
	//random is a class in java, which generate random number
		Random rand=new Random();
		//nextint(starting, end)
		int rancount=rand.nextInt(100000000, 999999999);
		
		return rancount;

}
	
	
	
	public int togetrandomNumber() {
		Random rand=new Random();
		int rancount=rand.nextInt(1000);
		
		return rancount;
		
	}
	
	
	public String generateCurrentDateandTime() {
		

		Date d=new Date();
		
		System.out.println(d);
		
		//: replace with _ and space with _ , method chaining used
		String date = d.toString().replace(":", "_").replace(" ","_");
		
		
		
		return date;
	}
}