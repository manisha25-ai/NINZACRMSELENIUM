package PracticeSession;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class workingwithassertion {
	@Test
	
	public void t1() {
		if("HDFC".equals("HFBC"))
		{
			System.out.println("Pass");
		}
		else {
		System.out.println("fail");
		}
		
	}
		@Test
		
		public void t2()
		{
		//	System.out.println("start");
	//	Assert.assertEquals("hdfc", "hfdc");
	//	Assert.assertNotEquals("hdfc", "hfdc");
	//	System.out.println("end");
		System.out.println("start");
			SoftAssert as=new SoftAssert();
		//	as.assertEquals("hdfc", "hfdc");
		//	as.assertNotEquals("hdfc", "hfdc");
		
		
		
	//	Assert.assertTrue("HDFC".equals("HFBC"));
	//	Assert.assertFalse("HDFC".equals("HFBC"));
	//	as.assertTrue("HDFC".equals("HFBC"));
//	as.assertFalse("HDFC".equals("HFBC"), "Both are not equal");
		
			String s="Manisha";
		//	Assert.assertNull(s);
		//	Assert.assertNotNull(s);
		//	as.assertNull(s);
			as.assertNotNull(s);
		System.out.println("end");	
	//	as.assertAll();
		
			
		}
	}
	
	


