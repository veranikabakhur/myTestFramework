package com.allbirds.pages;

import com.allbirds.utility.BrowserHandling;
import com.allbirds.utility.ConfigDataProvider;
import com.allbirds.utility.DataProvider;
import com.allbirds.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import static com.allbirds.utility.Helper.getCurrentDateTime;
import static java.lang.System.getProperty;

public class BaseClass {

    public WebDriver driver;
    public DataProvider excel;
    public ConfigDataProvider config;
    public  ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite

    public void setUpSuite () throws IOException {
        Reporter.log("Setting up reports and Test started", true);
        excel = new DataProvider();
        config = new ConfigDataProvider();

        ExtentHtmlReporter extent = new ExtentHtmlReporter ("./Reports/report" + getCurrentDateTime() +".html");
        report = new ExtentReports();
        report.attachReporter(extent);
        Reporter.log("setting done -test can be started", true);
    }


    @BeforeClass
    public void setUp (){
        Reporter.log("Trying to start browser", true);
        driver = BrowserHandling.startApplication(driver, config.getBrowser(), config.getStagingURL());
        Reporter.log("Browser is up, App is running", true);

    }

    @AfterClass
    public void tearDown(){
        BrowserHandling.quitBrowser(driver);

    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        Reporter.log("Test is about to end", true);

        if (result.getStatus()==ITestResult.FAILURE){
            logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

        }
        else if ( result.getStatus()==ITestResult.SUCCESS) {
            logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        else if (result.getStatus()==ITestResult.SKIP) {
            logger.skip("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }

        report.flush();
        Reporter.log("Test completed", true);

    }
}
