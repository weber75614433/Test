package com.chenyo.permission;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogRecord {
    public static Logger logger;


    public LogRecord() {
        logger = Logger.getLogger("LogRecord");
        logger.setLevel(Level.INFO);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.OFF);

        logger.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler("D:\\Project\\log\\logRecord.txt", true);
            fileHandler.setFormatter(new LogFormat());
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);

        } catch (SecurityException | IOException e) {

            e.printStackTrace();
        }
    }

    public static void setINFO(String info){
        logger.info(info);
    }

    public static void setWarning(String warning){
        logger.warning(warning);
    }

}
