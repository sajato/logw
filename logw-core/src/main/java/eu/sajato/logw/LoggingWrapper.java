package eu.sajato.logw;

/**
 * The interface for the precise wrapper of a individual logging framework.
 * TODO Add details.
 */
public interface LoggingWrapper {

    void log(String loggerName, Level level, String message);

    boolean isLoggable(String loggerName, Level level);

}
