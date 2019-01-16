package com.gmail.vi160691vmv.tests;

import com.gmail.vi160691vmv.pages.LoginPage;
import com.gmail.vi160691vmv.pages.MailBoxPage;
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
    public void userLogin1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.editLoginField("myjustforfun");
        loginPage.editPasswordField("Am346115");
        loginPage.clickOnLoginButton();
        Assert.assertEquals("myjustforfun@ukr.net", loginPage.getTitleText());
    }

    @Test
    public void userLogin2() {
        MailBoxPage mailBoxPage = new MailBoxPage(driver);
        mailBoxPage.clickWriteButton();
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