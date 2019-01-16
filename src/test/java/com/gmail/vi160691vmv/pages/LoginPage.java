package com.gmail.vi160691vmv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void editLoginField(String text) {
        driver.findElement(By.id("id-l")).sendKeys(text);
    }

    public void editPasswordField(String text) {
        driver.findElement(By.id("id-p")).sendKeys(text);
    }

    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector(".form__submit")).click();
    }

    public String getTitleText() {
        String title = driver.findElement(By.cssSelector(".login-button__user")).getText();
        return title;
    }
}