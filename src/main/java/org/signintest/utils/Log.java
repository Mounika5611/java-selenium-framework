package org.signintest.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    //Read from XML config where we define the format of logs - Timestamp etc
    //Start Test and End Test logs
    //Custom wrapper logs

    static {
        String log4jpath = System.getProperty("user.dir") + "/src/main/resources/log4j.xml";
        System.setProperty("logoutputpath", System.getProperty("user.dir"));
        System.setProperty("log4j.configurationFile", log4jpath);
    }

    public static Logger log = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String testCaseName){
        log.info("Started Test " + testCaseName);
    }

    public static void endTestCase(String testCaseName){
        log.info("Ended Test " + testCaseName);
    }

    public static  void info(String message){
        log.info(message);
    }

    public static  void warn(String messsage){
        log.warn(messsage);
    }

    public static void error(String message, Exception e){
        log.error(message, e);
    }

    public static void fatal(String message){
        log.fatal(message);
    }
}
