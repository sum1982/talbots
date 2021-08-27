/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.testcases;

import com.talbot.qa.base.TestBase;
import com.talbot.qa.pages.HomePage;
import com.talbot.qa.pages.ResultPage;
import com.talbot.util.TestUtil;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kohli
 */
public class SearchPageTest extends TestBase{
    
    TestUtil testUtil;
    HomePage homePage;
    ResultPage resultPage;
    
    public SearchPageTest(){
        super();
    }
    
    @BeforeMethod
    public void setUp(){
        intialization();
        testUtil= new TestUtil();
        homePage = new HomePage();
        resultPage= new ResultPage();
    }
    
    @Test()
    public void homePageTest() throws InterruptedException{
        homePage.searchBox(prop.getProperty("search"));
          resultPage.clickProduct();
          String title = resultPage.validateSelectedProductPage();
           Assert.assertEquals(title , "Organic True Cotton Tonal Striped Sleep Shirt | Haven Well Within");
    }
    
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
