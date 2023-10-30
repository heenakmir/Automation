package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
@FindBy(xpath="//input[@name='lastname']")
private WebElement LastNameEdt;

@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
private WebElement OrgNameImgBtn;

@FindBy(xpath="//input[@accesskey='S']")
private WebElement SaveBtn;

@FindBy(xpath="//input[@id='search_txt']")
private WebElement OrgSearchEdt;

@FindBy(xpath="//input[@name='search']")
private WebElement OrgSearchBtn;

public CreateNewContactPage(WebDriver driver) 
{
PageFactory.initElements(driver, this);	
}


public WebElement getLastNameEdt() {
	return LastNameEdt;
}


public WebElement getOrgNameImgBtn() {
	return OrgNameImgBtn;
}


public WebElement getSaveBtn() {
	return SaveBtn;
}


public WebElement getOrgSearchEdt() {
	return OrgSearchEdt;
}


public WebElement getOrgSearchBtn() {
	return OrgSearchBtn;
}


// Business Lib
/**
 * This method will create new contact using mandatory filed 
 * @param LASTNAME
 */
public void createNewContact(String LASTNAME)
{
	LastNameEdt.sendKeys(LASTNAME);
	SaveBtn.click();
}
public void createNewContact(WebDriver driver,String LASTNAME, String ORGNAME)
{
	LastNameEdt.sendKeys(LASTNAME);
	OrgNameImgBtn.click();
	switchToWindow(driver, "Accounts");
	OrgSearchEdt.sendKeys(ORGNAME);
	OrgSearchBtn.click();
	driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
	switchToWindow(driver, "Contacts");
	SaveBtn.click();
}
		
}
