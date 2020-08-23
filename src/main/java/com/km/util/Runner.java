package com.km.util;

import net.openhft.compiler.CompilerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {
    public Runnable execute(String dir, String packageName, String className) {
        try {
            String packagePath = packageName + "." + className;
            String code = getSourceFile(dir, packageName, className);
            Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(packagePath, code);
            return (Runnable) aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getSourceFile(String dir, String packageName, String className) throws IOException {
        Path path = Paths.get(dir + "/" + packageName + "/" + className + ".java");
        return Files.readString(path);
    }
}
