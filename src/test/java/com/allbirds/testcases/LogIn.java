package com.allbirds.testcases;

import com.allbirds.pages.BaseClass;
import com.allbirds.pages.LoginPage;
import com.allbirds.utility.BrowserHandling;
import com.allbirds.utility.DataProvider;
import com.allbirds.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;

public class LogIn extends BaseClass {

//small changes

    @Test
    public void loginApp() throws IOException {


        logger = report.createTest("loginToAccount");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn(excel.getStringData("Login",0,0), excel.getStringData("Login",0,1));
        driver.getTitle();
        //Helper.captureScreenshot(driver);

        //logger.pass("Login success");

    }


}
