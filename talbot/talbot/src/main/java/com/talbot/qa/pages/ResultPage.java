/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.pages;

import com.talbot.qa.base.TestBase;
import static com.talbot.qa.base.TestBase.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author kohli
 */
public class ResultPage extends TestBase{
    
    @FindBy(xpath="//img[@alt='Organic True Cotton Tonal Striped Sleep Shirt']")
    WebElement selectedProduct;
    
    public ResultPage(){
        PageFactory.initElements(driver, this);
    }
    
    public ResultPage clickProduct() throws InterruptedException{
        selectedProduct.click();
        Thread.sleep(5000);
        return new ResultPage();
    }
    
    public String validateSelectedProductPage(){
        return driver.getTitle();
    }
}
