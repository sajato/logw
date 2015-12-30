package eu.sajato.logw;

import eu.sajato.logw.javaLogging.JavaLoggingWrapper;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public class Logw {

    static LoggingWrapper logger;

    static {

        ServiceLoader<LoggingWrapper> serviceLoader = ServiceLoader.load(LoggingWrapper.class);

        Iterator<LoggingWrapper> ite = serviceLoader.iterator();
        if(ite.hasNext()) {
            setInnerLogger(ite.next());
            if(ite.hasNext())
                Logw.warn("More then one LoggingWrapper loaded with ServiceLoader. Check if multiple logw bindings are in classpath. Anyway, we use the first one for now.");
        } else {
            setInnerLogger(new JavaLoggingWrapper());
        }

        Logw.info("Logw use log wrapper " + logger.getClass().getName());
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

    public static void trace(String messagePattern, Supplier<Object>... arguments) {
        Logw.log(Level.TRACE, messagePattern, arguments);
    }

    public static void trace(String loggerName, String message) {
        Logw.log(loggerName, Level.TRACE, message);
    }

    public static void trace(String loggerName, String messagePattern, Object... parameter) {
        Logw.log(loggerName, Level.TRACE, messagePattern, parameter);
    }

    public static void trace(String loggerName, String messagePattern, Supplier<Object>... arguments) {
        Logw.log(loggerName, Level.TRACE, messagePattern, arguments);
    }

    public static void debug(String message) {
        Logw.log(Level.DEBUG, message);
    }

    public static void debug(String messagePattern, Object... parameter) {
        Logw.log(Level.DEBUG, messagePattern, parameter);
    }

    public static void debug(String messagePattern, Supplier<Object>... arguments) {
        Logw.log(Level.DEBUG, messagePattern, arguments);
    }

    public static void debug(String loggerName, String message) {
        Logw.log(loggerName, Level.DEBUG, message);
    }

    public static void debug(String loggerName, String messagePattern, Object... parameter) {
        Logw.log(loggerName, Level.DEBUG, messagePattern, parameter);
    }

    public static void debug(String loggerName, String messagePattern, Supplier<Object>... arguments) {
        Logw.log(loggerName, Level.DEBUG, messagePattern, arguments);
    }

    public static void info(String message) {
        Logw.log(Level.INFO, message);
    }

    public static void info(String messagePattern, Object... parameter) {
        Logw.log(Level.INFO, messagePattern, parameter);
    }

    public static void info(String messagePattern, Supplier<Object>... arguments) {
        Logw.log(Level.INFO, messagePattern, arguments);
    }

    public static void info(String loggerName, String message) {
        Logw.log(loggerName, Level.INFO, message);
    }

    public static void info(String loggerName, String messagePattern, Object... parameter) {
        Logw.log(loggerName, Level.INFO, messagePattern, parameter);
    }

    public static void info(String loggerName, String messagePattern, Supplier<Object>... arguments) {
        Logw.log(loggerName, Level.INFO, messagePattern, arguments);
    }

    public static void warn(String message) {
        Logw.log(Level.WARN, message);
    }

    public static void warn(String messagePattern, Object... parameter) {
        Logw.log(Level.WARN, messagePattern, parameter);
    }

    public static void warn(String messagePattern, Supplier<Object>... arguments) {
        Logw.log(Level.WARN, messagePattern, arguments);
    }

    public static void warn(String loggerName, String message) {
        Logw.log(loggerName, Level.WARN, message);
    }

    public static void warn(String loggerName, String messagePattern, Object... parameter) {
        Logw.log(loggerName, Level.WARN, messagePattern, parameter);
    }

    public static void warn(String loggerName, String messagePattern, Supplier<Object>... arguments) {
        Logw.log(loggerName, Level.WARN, messagePattern, arguments);
    }

    public static void error(String message) {
        Logw.log(Level.ERROR, message);
    }

    public static void error(String messagePattern, Object... parameter) {
        Logw.log(Level.ERROR, messagePattern, parameter);
    }

    public static void error(String messagePattern, Supplier<Object>... arguments) {
        Logw.log(Level.ERROR, messagePattern, arguments);
    }

    public static void error(String loggerName, String message) {
        Logw.log(loggerName, Level.ERROR, message);
    }

    public static void error(String loggerName, String messagePattern, Object... parameter) {
        Logw.log(loggerName, Level.ERROR, messagePattern, parameter);
    }

    public static void error(String loggerName, String messagePattern, Supplier<Object>... arguments) {
        Logw.log(loggerName, Level.ERROR, messagePattern, arguments);
    }

    public static void log(Level level, String message) {

        String loggerName = NameDiscoverer.discoverer();

        Logw.log(loggerName, level, message);
    }

    public static void log(Level level, String messagePattern, Object... parameter) {

        String loggerName = NameDiscoverer.discoverer();

        Logw.log(loggerName, level, messagePattern, parameter);
    }

    public static void log(Level level, String messagePattern, Supplier<Object>... arguments) {

        String loggerName = NameDiscoverer.discoverer();

        Logw.log(loggerName, level, messagePattern, arguments);
    }

    public static void log(String loggerName, Level level, String message) {

        if(!logger.isLoggable(loggerName, level))
            return;

        logger.log(loggerName, level, message);
    }

    public static void log(String loggerName, Level level, String messagePattern, Object... parameter){

        if(!logger.isLoggable(loggerName, level))
            return;

        logger.log(loggerName, level, MessageFormatter.format(messagePattern, parameter));
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
