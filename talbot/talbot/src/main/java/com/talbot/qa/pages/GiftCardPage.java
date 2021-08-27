/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talbot.qa.pages;

import com.talbot.qa.base.TestBase;
import static com.talbot.qa.base.TestBase.driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kohli
 */
public class GiftCardPage extends TestBase {

    public GiftCardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'$100.00')]")
    WebElement oneHundred;

    @FindBy(xpath = "//form[@id='GiftCertificateForm']/fieldset/div/div")
    WebElement form;

    @FindBy(id = "dwfrm_giftcert_purchase_message")
    WebElement message;

    @FindBy(id = "AddToBasketButton")
    WebElement cart;

    @FindBy(xpath = "//body/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/img[1]")
    WebElement logo;

    @FindBy(xpath = "//*[@id=\"ui-id-1\"]/div[1]/div[2]/div[2]/a")
    WebElement shopppingcart;

    public GiftCardPage giftCard(String note) {
        oneHundred.click();
        form.click();
        message.click();
        message.clear();
        message.sendKeys(note);
        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        cart.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);  //20 sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddToBasketButton")));
        cart.click();


        return new GiftCardPage();
    }

    public String validategiftCardPage(){
        return driver.getTitle();
    }
}
