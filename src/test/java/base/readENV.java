package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readENV {
    private static Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/env/env.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load env.properties file!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
