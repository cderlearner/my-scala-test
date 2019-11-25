package com.example.myscalatest.logger;

import java.util.logging.Logger;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggerTest.class.getName());

        logger.finest("this is finest");
        logger.finer("this is finer");
        logger.fine("this is fine");
        logger.config("this is config");
        logger.info("this is info");
        logger.warning("this is a warning");
        logger.severe("this is severe");
    }
}
