package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic Configuration Annotations of testNG
 * 
 * @author Heena mir
 *
 */
public class BaseClass 
{
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	 public JavaFileUtility jUtil=new JavaFileUtility();
	 public ExcelSheetUtility eUtil=new ExcelSheetUtility();
	 public WebDriverUtility wUtil=new WebDriverUtility();
	 public WebDriver driver=null;
	 
	 //used for listeners
	 public static WebDriver sdriver;
	@BeforeSuite
	public void bsConfig() {
		System.out.println("---- DB Connection Successful ----");
	}
//@Parameters("browser")
//@BeforeTest
	@BeforeClass
	public void bcConfig(/*String BROWSER*/) throws IOException {
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximiseWindow(driver);
		wUtil.WaitForPageLoad(driver);
		sdriver=driver;

		driver.get(URL);
	}

	@BeforeMethod
	public void bmConfig() throws IOException {
		
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("-----Login successful-----");
		
	}

	@AfterMethod
	public void amConfig() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		  hp.logOutOfApp(driver);
		  System.out.println("----Logout successful------");
		

	}
//@AfterTest
	@AfterClass
	public void acConfig() {
		
		driver.quit();
		System.out.println("---- Browser Closed ----");

	}

	@AfterSuite
	public void asConfig() {
		System.out.println("---- DB Connection Closed ----");
	}
}


