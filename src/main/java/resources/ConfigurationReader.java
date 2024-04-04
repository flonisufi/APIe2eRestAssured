package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("globalData.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public String getProperty(String key)
    {
        return properties.getProperty(key);
    }



}
