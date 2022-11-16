package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadproperties(String filepath)  {

        File file= new File(filepath);
        try {
            InputStream inputstream= new FileInputStream(file);
            Properties properties= new Properties();
            properties.load(inputstream);
            inputstream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file is not found");
        } catch (IOException e) {
            throw new RuntimeException("error while loading ");
        }

    }
}
