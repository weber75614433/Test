package com.chenyo.permission;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogEvent {
    static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("D:/Project/log/test.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Logger logger = Logger.getLogger("test");

    public LogEvent() throws IOException {
    }


    public static void setLogger(String command){
        fileHandler.setLevel(Level.INFO);
        logger.addHandler(fileHandler);
        logger.info(command);
    }
}
