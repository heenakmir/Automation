package contactTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class ContactUsingBaseClassTest extends BaseClass
{
@Test(groups= {"smokeSuite","ReggressionSuite"})
public void ContactUsingBaseClassTest() throws IOException, InterruptedException
{
	
	
	/*String USERNAME =  pUtil.readDataFromPropertyFile("username");
	String PASSWORD =  pUtil.readDataFromPropertyFile("password");*/
	String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
	
	HomePage hp = new HomePage(driver);
	Thread.sleep(6000);
	hp.clickOnContactLink();
	Thread.sleep(2000);
	//to generate report which will give the particular step is failed which makes debugging easy
	Reporter.log("clicked on contact link");
	
	ContactPage cp = new ContactPage(driver);
	Thread.sleep(4000);
	cp.createNewContact();
	Reporter.log("clicked on contact lookup img");
	
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	Thread.sleep(6000);
	cncp.createNewContact(LASTNAME);
	Reporter.log("contact is created");
	ContactInfoPage cip = new ContactInfoPage(driver);
	//Assert.fail();//used for listeners
	String contactheader = cip.getContactHeaderText();
	Assert.assertTrue(contactheader.contains(LASTNAME));
	Reporter.log("validation for contact");
	System.out.println(contactheader);
}
@Test
public void demo()
{
	System.out.println("hello world");
}
}

