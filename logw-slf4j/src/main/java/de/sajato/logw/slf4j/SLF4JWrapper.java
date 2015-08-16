package de.sajato.logw.slf4j;

import de.sajato.logw.Level;
import de.sajato.logw.LoggingWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SLF4JWrapper implements LoggingWrapper {

    Logger getLogger(String loggerName){
        return LoggerFactory.getLogger(loggerName);
    }

    @Override
    public void log(String loggerName, Level level, String message) {

        Logger logger = getLogger(loggerName);

        switch (level) {
            case TRACE:
                logger.trace(message);
                return;
            case DEBUG:
                logger.debug(message);
                return;
            case INFO:
                logger.info(message);
                return;
            case WARN:
                logger.warn(message);
                return;
            case ERROR:
                logger.error(message);
                return;
        }

        throw new UnsupportedOperationException("Unsupported log level: " + level);
    }

    @Override
    public boolean isLoggable(String loggerName, Level level) {

        Logger logger = getLogger(loggerName);

        switch (level) {
            case TRACE:
                return logger.isTraceEnabled();
            case DEBUG:
                return logger.isDebugEnabled();
            case INFO:
                return logger.isInfoEnabled();
            case WARN:
                return logger.isWarnEnabled();
            case ERROR:
                return logger.isErrorEnabled();
        }

        throw new UnsupportedOperationException("Unsupported log level: " + level);
    }
}
