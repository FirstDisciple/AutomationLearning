package com.gmail.vi160691vmv;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.ukr.net/login?client_id=9GLooZH9KjbBlWnuLkVX");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("id-l"));
        loginField.sendKeys("myjustforfun");
        WebElement passwordField = driver.findElement(By.id("id-p"));
        passwordField.sendKeys("Am346115");
        WebElement loginButton = driver.findElement(By.cssSelector(".form__submit"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("myjustforfun@ukr.net", mailUser);
    }
    @AfterClass
    public static void tearDown() {
        WebElement moreButton = driver.findElement(By.cssSelector(".login-button"));
        moreButton.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();
        driver.quit();
    }
}