package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractise 
{
@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
public void analyserPractise()
{
	Assert.fail();
	System.out.println("hi");
}

}
