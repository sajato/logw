package de.sajato.logw;

import de.sajato.logw.javaLogging.JavaLoggingWrapper;

import java.util.function.Supplier;

public class Logw {

    static LoggingWrapper logger;

    static {
        // TODO Set default inner logger.
        setInnerLogger(new JavaLoggingWrapper());
    }

    static void setInnerLogger(LoggingWrapper logger) {
        Logw.logger  = logger;
    }

    public static void trace(String message) {
        Logw.log(Level.TRACE, message);
    }

    public static void trace(String messagePattern, Object... parameter) {
        Logw.log(Level.TRACE, messagePattern, parameter);
    }

    public static void trace(String format, Supplier<Object>... arguments) {
        Logw.log(Level.TRACE, format, arguments);
    }

    public static void debug(String message) {
        Logw.log(Level.DEBUG, message);
    }

    public static void debug(String messagePattern, Object... parameter) {
        Logw.log(Level.DEBUG, messagePattern, parameter);
    }

    public static void debug(String format, Supplier<Object>... arguments) {
        Logw.log(Level.DEBUG, format, arguments);
    }

    public static void info(String message) {
        Logw.log(Level.INFO, message);
    }

    public static void info(String messagePattern, Object... parameter) {
        Logw.log(Level.INFO, messagePattern, parameter);
    }

    public static void info(String format, Supplier<Object>... arguments) {
        Logw.log(Level.INFO, format, arguments);
    }

    public static void warn(String message) {
        Logw.log(Level.WARN, message);
    }

    public static void warn(String messagePattern, Object... parameter) {
        Logw.log(Level.WARN, messagePattern, parameter);
    }

    public static void warn(String format, Supplier<Object>... arguments) {
        Logw.log(Level.WARN, format, arguments);
    }

    public static void error(String message) {
        Logw.log(Level.ERROR, message);
    }

    public static void error(String messagePattern, Object... parameter) {
        Logw.log(Level.ERROR, messagePattern, parameter);
    }

    public static void error(String format, Supplier<Object>... arguments) {
        Logw.log(Level.ERROR, format, arguments);
    }

    public static void log(Level level, String message) {

        String loggerName = NameDiscoverer.discoverer();

        log(loggerName, level, message);
    }

    public static void log(String loggerName, Level level, String message) {

        if(!logger.isLoggable(loggerName, level))
            return;

        logger.log(loggerName, level, message);
    }

    public static void log(Level level, String messagePattern, Object... parameter) {

        String loggerName = NameDiscoverer.discoverer();

        log(loggerName, level, messagePattern, parameter);
    }

    public static void log(String loggerName, Level level, String messagePattern, Object... parameter){

        if(!logger.isLoggable(loggerName, level))
            return;

        logger.log(loggerName, level, MessageFormatter.format(messagePattern, parameter));
    }

    public static void log(Level level, String messagePattern, Supplier<Object>... arguments) {

        String loggerName = NameDiscoverer.discoverer();

        log(loggerName, level, messagePattern, arguments);
    }

    public static void log(String loggerName, Level level, String messagePattern, Supplier<Object>... arguments){

        if(!logger.isLoggable(loggerName, level))
            return;

        Object[] args = new Object[arguments.length];

        for(int i = 0; i < arguments.length; i++){
            args[i] = arguments[i].get();
        }

        logger.log(loggerName, level, MessageFormatter.format(messagePattern, args));
    }

}