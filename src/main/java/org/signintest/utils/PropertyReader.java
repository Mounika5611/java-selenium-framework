package org.signintest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//To use PropertyReader, create an instance for PropertyReader and call readItem with String
public class PropertyReader {
    //Read the properties file in resource
    //readItem("browser") => chrome

   static Properties properties;

   public PropertyReader(){
       loadAllProperties();
   }

   //Load file from resource
   public void loadAllProperties(){
       properties = new Properties();
       //read the file dev_config.properties
       try {
          String fileName = System.getProperty("user.dir")+"/src/main/resources/dev_config.properties";
          properties.load(new FileInputStream(fileName));

       }catch (IOException e){
           throw new RuntimeException("No file found");

       }

   }

   public static String readItem(String propertyName){
       return properties.getProperty(propertyName);
   }

}
