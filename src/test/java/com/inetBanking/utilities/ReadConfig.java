package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig(){
        File src = new File("./Configuration/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }
        catch (Exception e){
            System.out.println("Exeption is " + e.getMessage());
        }
    }
    public String getApplicationUrl(){
        String url = pro.getProperty("baseUrl");
        return url;
    }
    public String getUserName(){
        String username = pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String password = pro.getProperty("password");
        return password;
    }
    public String getChromePath(){
        String chromePath = pro.getProperty("chromepath");
        return chromePath;
    }
    public String getIEPath(){
        String iepath = pro.getProperty("iepath");
        return iepath;
    }

    public String getFireFoxPath(){
        String fireFoxPath = pro.getProperty("firefoxpath");
        return fireFoxPath;
    }
}
