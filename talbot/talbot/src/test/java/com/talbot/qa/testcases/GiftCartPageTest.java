/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.talbot.qa.base.TestBase;
import com.talbot.qa.pages.GiftCardPage;
import com.talbot.qa.pages.HomePage;
import com.talbot.util.TestUtil;

/**
 *
 * @author kohli
 */
public class GiftCartPageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePage;
	GiftCardPage giftCardPage;

	public GiftCartPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		giftCardPage = new GiftCardPage();
//        shoppingCartPage= new ShoppingCartPage();
	}

	@Test
	public void LocationPageTest() {
		homePage.giftCardLink();
		giftCardPage.giftCard(prop.getProperty("note"));
		String title = giftCardPage.validategiftCardPage();
		Assert.assertEquals(title, "Gift Card | Talbots");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
