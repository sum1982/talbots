/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.testcases;

import static com.google.common.collect.Streams.zip;
import com.talbot.qa.base.TestBase;
import static com.talbot.qa.base.TestBase.intialization;
import com.talbot.qa.pages.FindAStorePage;
import com.talbot.qa.pages.HomePage;
import com.talbot.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kohli
 */
public class LocationPageTest extends TestBase{
   TestUtil testUtil;
    HomePage homePage;
    FindAStorePage findAStorePage;
    
    public LocationPageTest(){
        super();
    }
    
     @BeforeMethod
    public void setUp(){
        intialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        findAStorePage= new FindAStorePage();
    }
    
    @Test()
    public void LocationPageTest() throws InterruptedException{
        homePage.storeLocat();
        findAStorePage.clickLocationFilters(prop.getProperty("mile"),prop.getProperty("zip"));
         String title = findAStorePage.validateFindAStorePage();
           Assert.assertEquals(title , "Store Location Details | Talbots");
    }
    
      @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
