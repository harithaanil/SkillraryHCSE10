package GenericLibraries;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import PomClasses.SkillraryHomePage;
import PomClasses.TestingPageInSkillraryApp;
import PomClasses.SeleniumTrainingPage;
import PomClasses.SkillraryDemoApppage;

import  PomClasses.ContactUs;


public class BaseClass {

protected PropertiesUtility property;
protected ExcelUtility excel;
protected JavaUtility junit;
protected WebDriverUtility web;
protected WebDriver driver;

protected SkillraryHomePage home;
protected SkillraryDemoApppage demo;
protected SeleniumTrainingPage selenium;
protected TestingPageInSkillraryApp testing;
protected ContactUs Contact;



//@BeforeSuite
//@BeforeTest

@BeforeClass
public void ClassConfig() {
	property= new PropertiesUtility();
	excel = new ExcelUtility();
	junit = new JavaUtility();
	web = new WebDriverUtility();

	property.propertiesInit(IConstantPath.PROPERTIES_PATH);
	excel.excelInit(IConstantPath.EXCEL_PATH);
	
}
@BeforeMethod
public void methodConfig()
{
	driver=web.launchBroswer(property.readDataFromProperties("browser"));
	web.maximizeBrowser();
	web.navigateToApp(property.readDataFromProperties("url"));
	web.waitUntilElementFound(Long.parseLong(property.readDataFromProperties("time")));
	
	home = new SkillraryHomePage(driver);
	demo = new SkillraryDemoApppage(driver);
	selenium = new SeleniumTrainingPage(driver);
	testing= new TestingPageInSkillraryApp(driver);
	Contact	= new ContactUs(driver);
}
@AfterMethod
public void methoTearDown() {
	web.quitAllWindows();
}
@AfterClass
public void classTearDown() {
	excel.closeExcel();
}
//@Aftertest
//@AfterSuite
}
