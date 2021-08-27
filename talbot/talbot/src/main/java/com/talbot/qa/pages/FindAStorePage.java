/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.pages;

import com.talbot.qa.base.TestBase;
import static com.talbot.qa.base.TestBase.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kohli
 */
public class FindAStorePage extends TestBase{
    @FindBy(id= "distance")
    WebElement miles;
    
    @FindBy(id= "address")
    WebElement addressbox;
    
    @FindBy(xpath= "//form[@id='store-search-form']/fieldset/div[3]/button/span")
    WebElement option;
    
    @FindBy(xpath= "//span[contains(text(),'WHEATON')]")
    WebElement weaton;
    
       public FindAStorePage(){
        PageFactory.initElements(driver, this);
    }
    
    public FindAStorePage clickLocationFilters(String mile, String zip) throws InterruptedException{
         Select miles= new Select(driver.findElement(By.id("distance")));
         miles.selectByVisibleText(mile);
         addressbox.click();
         addressbox.clear();
         addressbox.sendKeys(zip);
         option.click();
         ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
         WebDriverWait wait = new WebDriverWait(driver, 20);  //20 sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//form[@id='store-search-form']/fieldset/div[3]/button/span")));
        Thread.sleep(2000);
         weaton.click();
         
          return new FindAStorePage();
    }

public String validateFindAStorePage(){
        return driver.getTitle();
    }

    
    
}
