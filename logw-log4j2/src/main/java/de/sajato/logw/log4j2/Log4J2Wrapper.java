package de.sajato.logw.log4j2;

import de.sajato.logw.Level;
import de.sajato.logw.LoggingWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J2Wrapper implements LoggingWrapper {

    Logger getLogger(String loggerName){
        return LogManager.getLogger(loggerName);
    }

    org.apache.logging.log4j.Level convertLevel(final de.sajato.logw.Level level) {

        // TODO Check log level allocation.
        switch (level){
            case TRACE:
                return org.apache.logging.log4j.Level.TRACE;
            case DEBUG:
                return org.apache.logging.log4j.Level.DEBUG;
            case INFO:
                return org.apache.logging.log4j.Level.INFO;
            case WARN:
                return org.apache.logging.log4j.Level.WARN;
            case ERROR:
                // ERROR and
                return org.apache.logging.log4j.Level.FATAL;
            default:
                throw new RuntimeException("Unknown Log Level '" + level.toString() + "'.");
        }
    }

    @Override
    public void log(String loggerName, Level level, String message) {

        getLogger(loggerName).log(convertLevel(level), message);
    }

    @Override
    public boolean isLoggable(String loggerName, Level level) {

        return getLogger(loggerName).isEnabled(convertLevel(level));
    }

}
