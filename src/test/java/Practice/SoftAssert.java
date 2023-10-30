package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class SoftAssert 
{
public void Practise()
{
System.out.println("Step 1");
System.out.println("Step 2");
Assert.assertEquals(true, false);
System.out.println("Step 3");
System.out.println("Step 4");
}

public void practise1()
{
	SoftAssert sa = new org.testng.asserts.SoftAssert()
	System.out.println("Step 1");
	System.out.println("Step 2");
	sa.assertEquals(false,true);
	
	
}


	
}

}
