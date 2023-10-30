package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This method will provide implementation to the IRetryAnalayser interface of testng
 * @author HP
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer
{
int count=0;
int retryCount=3;
public boolean retry(ITestResult result)
{
	//0<3 1<3 2<3 3<3NO
	while (count<retryCount)
	{
		count++;
		return true;
	}
	return false;//stop retrying
}
}
