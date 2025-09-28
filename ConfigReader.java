package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties = new Properties();

    public ConfigReader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("com/automation/config/config.properties")) {
            if (input == null) {
                throw new RuntimeException("⚠️ config.properties not found at com/automation/config/");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
