package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readENV {
    private static Properties properties;

    public static void loadProperties(String environment) {
        try {
            String filePath = "src/main/resources/env_" + environment + "_config.properties";
            System.out.println(filePath);
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load "+ environment +" file!");
        }
    }

    public static String get(String key) {
        if (properties == null) {
            throw new RuntimeException("Fail to load properties");
        }
        return properties.getProperty(key);
    }
}
