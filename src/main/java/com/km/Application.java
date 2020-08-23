package com.km;

import com.km.util.Evolution;

import java.io.FileInputStream;
import java.util.Properties;

public class Application {
    private static final String CONF_FILE = "editable/conf";
    private static final String DIR = "editable";
    private static final String VERSION = "version";
    private static final String CLASS_NAME = "Engine";
    private static final String VERSION_PREFIX = "ver";

    public static void main(String... args) {
        Properties properties = loadConfig();
        new Evolution().execute(DIR, VERSION_PREFIX, properties.getProperty(VERSION), CLASS_NAME);
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
