package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage //RULE 1
//RULE 2-->Decleration
{
@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreateOrgLookUpImg;

//RULE 3-->Initialization
public OrganisationPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
//RULE 4--->Utilization

public WebElement getCreateOrgLookUpImg() {
	return CreateOrgLookUpImg;
}
// Bussiness Lib
/**
 * This method will click on create Organization look up img
 */
public void clickOnOrgLookUpImg()
{
	CreateOrgLookUpImg.click();
}
}