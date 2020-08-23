package com.km.util;

public class Evolution {
    public void execute(String dir, String versionPrefix, String version, String className) {
        Runnable run = new Runner().execute(dir, versionPrefix + version, className);
        run.run();
    }
}
