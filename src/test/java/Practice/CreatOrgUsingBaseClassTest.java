package Practice;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganisationPage;

public class CreatOrgUsingBaseClassTest extends BaseClass 

{
@Test
public void CreateOrgUsingBaseClassTest() throws IOException, InterruptedException
{
	String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
	String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();
	HomePage hp = new HomePage(driver);
	Thread.sleep(2000);
	hp.clickOnOrgLink();
	//step7:click on organisation look up image
	
	OrganisationPage op = new OrganisationPage(driver);
	Thread.sleep(4000);
	op.clickOnOrgLookUpImg();
	//Step8:create new organisation with mandetory fileds
	CreateNewOrgPage cnp = new CreateNewOrgPage(driver);
	Thread.sleep(4000);
	cnp.createNewOrganisation(ORGNAME);
	//Step9:validation for organisation
	OrgInfoPage oip = new OrgInfoPage(driver);
	Thread.sleep(5000);
	String orgheader = oip.getHeaderText();
	if (orgheader.contains(ORGNAME)) 
	{
		System.out.println(orgheader);
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
		
	//Step10:click on conatct link in home page
	hp.clickOnContactLink();
	
	//Step11:click on contact look up icon
	
	ContactPage cp = new ContactPage(driver);
	Thread.sleep(4000);
	cp.createNewContact();
	
	//Step12:create contact with organisation
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	cncp.createNewContact(driver, LASTNAME, ORGNAME);
	 //Step13: Validation
	ContactInfoPage cip = new ContactInfoPage(driver);
	String conHeader = cip.getContactHeaderText();
	if (conHeader.contains(LASTNAME)) 
	{
		System.out.println("PASS");
	} 
	else
	{
System.out.println("FAIL");
	}
}
}
