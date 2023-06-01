package testScripts;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;



public class SendContactDetailsTest extends BaseClass {
	@Test 
	public void sendContactDetailsTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillrayDemoAppLink();
		web.switchToChildBrowser();
		
		soft.assertTrue(demo.getPageHeader().contains("ECommerce"));
		
		web.scrollTillElement(demo.getContactUsLink());
		demo.clickContactUs();
		
		
		soft.assertTrue(Contact.getLogo().isDisplayed());
		
		Map<String,String> map=excel.getDataFormExcel("Sheet1");
		Contact.sendDetails(map.get("FullName"), map.get("Email"), map.get("Subject"), map.get("Message"));
		
		soft.assertAll();
		
	}
	
	

}


