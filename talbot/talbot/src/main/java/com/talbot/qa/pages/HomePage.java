/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.pages;

import com.talbot.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author kohli
 */
public class HomePage extends TestBase{
    
    @FindBy(id="q")
    WebElement SearchBox;
    
    @FindBy(name= "simpleSearch")
    WebElement enter;
    
    @FindBy(linkText="Store Locator")
    WebElement storeLocation;
    
    @FindBy(xpath="//a[contains(text(),'Gift Cards')]")
    WebElement giftCard;
    
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    
    public ResultPage searchBox(String search){
        SearchBox.clear();
        SearchBox.click();
        SearchBox.sendKeys(search);
        enter.submit();
        return new ResultPage();
    }
    
    public FindAStorePage storeLocat(){
        storeLocation.click();
        return new FindAStorePage();
        
    }
    
    public GiftCardPage giftCardLink(){
        giftCard.click();
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        return new GiftCardPage();
        
    }
    
        
}
