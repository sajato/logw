package eu.sajato.logw.javaLogging;

import eu.sajato.logw.LoggingWrapper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaLoggingWrapper implements LoggingWrapper {

    Logger getLogger(String name){
        return Logger.getLogger(name);
    }

    Level convertLevel(final eu.sajato.logw.Level level) {

        // TODO Check log level allocation.
        switch (level){
            case TRACE:
                return Level.FINEST;
            case DEBUG:
                return Level.FINE;
            case INFO:
                // CONFIG and
                return Level.INFO;
            case WARN:
                return Level.WARNING;
            case ERROR:
                return Level.SEVERE;
            default:
                throw new RuntimeException("Unknown Log Level '" + level.toString() + "'.");
        }
    }

    @Override
    public void log(String loggerName, eu.sajato.logw.Level level, String message) {
        getLogger(loggerName).logp(convertLevel(level), loggerName, null, message);
    }

    @Override
    public boolean isLoggable(String loggerName, eu.sajato.logw.Level level) {
        return getLogger(loggerName).isLoggable(convertLevel(level));
    }
}
