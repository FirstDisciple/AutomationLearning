package com.gmail.vi160691vmv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MailBoxPage {

    public  WebDriver driver;

    public MailBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWriteButton() {
        driver.findElement(By.cssSelector(".compose")).click();

    }
}