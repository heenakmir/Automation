package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGpractice 
{
@Test (priority=2)
public void createCustomer()
{
	Assert.fail();// used to purpersoly fail the script
	System.out.println("create");
}

@Test(priority=3)
public void modifyCustomer()
{
	System.out.println("modify");
}
@Test(priority=4)
public void deleteCustomer()
{
	System.out.println("delete");
}
//to run the same script multiple times****if we give invocation count as 0/"-ve" then script will be disabled/will not run, not skipped

@Test(invocationCount = 4)
public void createCustomer1()
{
	System.out.println("create1");
}
//priority is given first preference always
@Test(invocationCount = 5,priority=1)
public void deleteCustomer1()
{
	System.out.println("delete1");
}
//if we want to don't run any particular script then we can disable it 
@Test (enabled=false)
public void modifyCustomer1()
{
	System.out.println("modify1");
}

//if one script is depends on another script then we use depends on 

@Test(dependsOnMethods="createCustomer")
public void modifyCustomer2()
{
	System.out.println("modify2");
}
}
