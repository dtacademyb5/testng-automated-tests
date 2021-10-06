package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;

    static {

        String pathToFile = "configuration.properties";
        try{
            FileInputStream fis = new FileInputStream(pathToFile);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
