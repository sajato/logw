package de.sajato.logw;

public interface LoggingWrapper {

    void log(String loggerName, de.sajato.logw.Level level, String message);

    boolean isLoggable(String loggerName, de.sajato.logw.Level level);

}
