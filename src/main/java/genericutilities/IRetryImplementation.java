package genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryImplementation implements IRetryAnalyzer{
	int count=1;
	int limit=5;
	@Override
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<=limit) {
			count++;
		return true;
	}
return false;
}
}