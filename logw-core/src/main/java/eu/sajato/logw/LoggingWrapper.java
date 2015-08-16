package eu.sajato.logw;

public interface LoggingWrapper {

    void log(String loggerName, Level level, String message);

    boolean isLoggable(String loggerName, Level level);

}
