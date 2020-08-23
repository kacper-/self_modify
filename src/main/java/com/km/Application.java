package com.km;

import com.km.util.Runner;

import java.io.FileInputStream;
import java.util.Properties;

public class Application {
    private static final String CONF_FILE = "editable/conf";
    private static final String DIR = "editable";
    private static final String VERSION = "version";
    private static final String CLASS_NAME = "Engine";

    public static void main(String... args) {
        Properties properties = loadConfig();
        System.out.printf("latest version is %s", properties.get(VERSION));
        new Runner().execute(DIR, properties.getProperty(VERSION), CLASS_NAME);
        System.out.println("engine finished");
    }

    private static Properties loadConfig() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(CONF_FILE));
        } catch (Exception e) {
            System.out.printf("Error reading config from [%s]%n", CONF_FILE);
            System.exit(0);
        }
        return properties;
    }
}
