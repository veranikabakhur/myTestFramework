package com.allbirds.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
    public Properties pro;

    public ConfigDataProvider() throws IOException {
        File src = new File("./Configuration/Config.properties");
        FileInputStream fis = new FileInputStream(src);
        pro = new Properties();
        pro.load(fis);

    }

    public String getDataFromConfig (String keyToSearch) {

        return pro.getProperty(keyToSearch);

    }

    public String getBrowser() {
       return pro.getProperty("Browser");

    }

    public String getStagingURL (){

        return pro.getProperty("qaUrl");

    }
}
