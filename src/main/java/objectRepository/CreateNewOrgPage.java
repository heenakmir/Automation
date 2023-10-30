package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility
{
@FindBy(xpath="//input[@name='accountname']")
private WebElement OrgNameEdt;

@FindBy(xpath="//select[@name='industry']")
private WebElement IndustryDropDown;

@FindBy(xpath="//select[@name='accounttype']")
private WebElement TypeDropDown;

@FindBy(xpath="//input[@accesskey='S']")
private WebElement SaveBtn;

public  CreateNewOrgPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public WebElement getOrgNameEdt() {
	return OrgNameEdt;
}

public WebElement getIndustryDropDown() {
	return IndustryDropDown;
}

public WebElement getTypeDropDown() {
	return TypeDropDown;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

//Bussiness Lib
/**
 * This method will create new organization with mandatory fields
 * @param ORGNAME
 */
public void createNewOrganisation(String ORGNAME)
{
	OrgNameEdt.sendKeys(ORGNAME);
	SaveBtn.click();
}
/**
 * This method will create organization with mandatory fields and industry
 * @param ORGNAME
 * @param INDUSTRY
 */
public void createNewOrganisation(String ORGNAME,String INDUSTRY)
{
	OrgNameEdt.sendKeys(ORGNAME);
	handleDropDown(IndustryDropDown, INDUSTRY);
	SaveBtn.click();
}
/**
 * This method will create organization with mandatory fields and industry and Type
 * @param ORGNAME
 * @param INDUSTRY
 * @param TYPE
 */
public void createNewOrganisation(String ORGNAME,String INDUSTRY,String TYPE)
{
	OrgNameEdt.sendKeys(ORGNAME);
	handleDropDown(IndustryDropDown, INDUSTRY);
	handleDropDown(TypeDropDown, TYPE);
	SaveBtn.click();
}

}
