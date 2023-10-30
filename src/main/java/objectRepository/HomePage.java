package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
//Rule 2--->Decleration
{
@FindBy(xpath="//a[text()='Contacts']")
private WebElement ContactLnk;

@FindBy(xpath="(//a[text()='Organizations'])[1]")
private WebElement OrganisationLnk;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement AddmistratorImg;

@FindBy(xpath="//a[text()='Sign Out']")
private WebElement SingOutLnk;

//Rule 3:Initialization
public HomePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}


//Rule 4:Utilization

public WebElement getContactLnk()
{
	return ContactLnk;
}

public WebElement getOrganisationLnk()
{
	return OrganisationLnk;
}

public WebElement getAddmistratorImg()
{
	return AddmistratorImg;
}

public WebElement getSingOutLnk()
{
	return SingOutLnk;
}
 //Business Library
/**
 * This method will click on Organisation link
 */
public void clickOnOrgLink()
{
	OrganisationLnk.click();
}
/**
 * This Method will click on Contact Link
 */

 public void clickOnContactLink()
 {
	 ContactLnk.click();	 
 }
/**
 * This method will logout from application
 * @param driver
 * @throws Throwable
 */
 public void logOutOfApp(WebDriver driver) throws Throwable
 {
	 mouseHoverAction(driver, AddmistratorImg);
	 Thread.sleep(2000);
	 SingOutLnk.click();
 }
}
