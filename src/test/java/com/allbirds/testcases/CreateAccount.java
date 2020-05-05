package com.allbirds.testcases;

import com.allbirds.pages.BaseClass;
import com.allbirds.pages.LoginPage;
import com.allbirds.utility.BrowserHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount extends BaseClass {


    @Test
    public void createAccount() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.createAccount("Veronika", "Bak", "veranika.bakhur@gmail.com", "123qwe!Q", "123qwe!Q");
        driver.getTitle();

    }
}
