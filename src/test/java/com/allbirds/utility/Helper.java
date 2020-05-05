package com.allbirds.utility;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.StreamHandler;


public class Helper {



    public static String captureScreenshot (WebDriver driver) throws IOException {

        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String screenshotPath = System.getProperty("/usr/dir", "./Screenshots/AllBirds" + getCurrentDateTime() +".png");
        ImageIO.write(src.getImage(), "jpg", new File(screenshotPath));

        return screenshotPath;


    }

    public static String getCurrentDateTime(){

        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH-mm-ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);


    }

    public void handleFrames(){


    }

    public void handleAlerts() {

    }

    public void handleMultipleWindows(){

    }

    public void handleSynIssues(){


    }


}
