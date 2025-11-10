package PracticeSession;

import org.testng.Assert;
import org.testng.annotations.Test;

public class workingwithretry {
	
	@Test(retryAnalyzer = genericutilities.IRetryImplementation.class)
	
	public void Hello()
	{
		Assert.assertEquals("hdfc", "hfcd");
	}

}
