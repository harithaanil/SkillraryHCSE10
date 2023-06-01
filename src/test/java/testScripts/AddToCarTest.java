package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class AddToCarTest extends BaseClass {
	
	@Test
	public   void addToCartTest() {
		
	SoftAssert soft = new SoftAssert();
	
	home.clickGearsTab();
	home.clickSkillrayDemoAppLink();
	web.switchToChildBrowser();
	
	soft.assertTrue(demo.getPageHeader().contains("ECommerce"));
		
	demo.mouseHoverToCourse(web);
	demo.clickSeleniumTraining();
	
	soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
	
	int initialQyuantity = Integer.parseInt(selenium.getQuantity());
	selenium.doubleClickPlusButton(web);
	int finalQuantity = Integer.parseInt(selenium.getQuantity());
	
	soft.assertEquals(finalQuantity, initialQyuantity+1);
	
	
	selenium.clickAddToCart();
	web.handleAlert("ok");
	soft.assertEquals(selenium.getItemAddedMessage(),"Item added to cart");
	
	
	soft.assertAll();
	}
	}


