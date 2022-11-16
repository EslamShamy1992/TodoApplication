package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private Properties properties;
    private static ConfigUtils configutils;

    public ConfigUtils() {
       String env= System.getProperty("env","PRODUCTION");
       switch(env){
           case"PRODUCTION":
               properties = PropertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/Production.properties");
               break;
           case"lOCAL":
               properties = PropertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/Local.properties");
               break;
           default:
               throw new RuntimeException("enviroment is not supported");
       }

    }
    public static ConfigUtils getinstance() {
        if (configutils == null) {
            configutils = new ConfigUtils();
        }
        return configutils;
    }

    public  String getbaseurl() {
        String prop = properties.getProperty("baseurl");
        if(prop != null) return prop;
            throw new RuntimeException("could not find the base url in the property");
        }
    public String getemail() {
        String prop = properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("could not find the email  in the property");
    }
    public String getpassword() {
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("could not find the password  in the property");
    }
    }

