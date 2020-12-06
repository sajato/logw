package eu.sajato.logw;

import eu.sajato.logw.javaLogging.JavaLoggingWrapper;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Supplier;

/**
 * This is the main class of the logging wrapper.
 * You can use the static logging methods to directly log messages
 * to the wrapped logging framework without creating a logger.
 * <p>
 * Which logging framework is used is determined by the binding contained
 * in the classpath (for details see the {@link LoggingWrapper} interface).
 * When no binding is found the java util logging api from the JDK is used.
 * <p>
 * You can use the general log methods named {@code log} or the methods named
 * by the associated log level. All methods have three variations, one with only the
 * simple message string ({@link #log(Level, String)}), one with a message pattern
 * and arguments for the placeholders ({@link #log(Level, String, Object...)})
 * and one with a massage pattern and lambda expressions for the placeholders
 * ({@link #log(Level, String, Supplier...)}).
 * <p>
 * When the evaluation of arguments is expensive pay special attention to
 * the methods with lambda expressions. You can use it to evaluate expressions
 * only when they are really needed.
 *
 * @author Sascha Rinne
 * @version 0.2.0
 */
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

    // Constructor not needed.
    private Logw(){}

    /**
     * <p>Logs a simple log message with {@link Level#TRACE}.</p>
     * Same as: {@link #log(Level, String) Logw.log(Level.TRACE, message)}
     */
    public static void trace(String message) {
        Logw.log(Level.TRACE, message);
    }

    /**
     * <p>Logs a message, compiled from message pattern and the arguments, with {@link Level#TRACE}.</p>
     * Same as: {@link #log(Level, String, Object...)} Logw.log(Level.TRACE, messagePattern, arguments)}
     */
    public static void trace(String messagePattern, Object... arguments) {
        Logw.log(Level.TRACE, messagePattern, arguments);
    }

    /**
     * <p>Logs a message, compiled from message pattern and values from the evaluated argument suppliers, with {@link Level#TRACE}.</p>
     * Same as: {@link #log(Level, String, Supplier...) Logw.log(Level.TRACE, messagePattern, argumentSuppliers)}
     */
    public static void trace(String messagePattern, Supplier<Object>... argumentSuppliers) {
        Logw.log(Level.TRACE, messagePattern, argumentSuppliers);
    }

    /**
     * <p>Logs a simple log message with {@link Level#DEBUG}.</p>
     * Same as: {@link #log(Level, String) Logw.log(Level.DEBUG, message)}
     */
    public static void debug(String message) {
        Logw.log(Level.DEBUG, message);
    }

    /**
     * <p>Logs a message, compiled from message pattern and the arguments, with {@link Level#DEBUG}.</p>
     * Same as: {@link #log(Level, String, Object...) Logw.log(Level.DEBUG, messagePattern, arguments)}
     */
    public static void debug(String messagePattern, Object... arguments) {
        Logw.log(Level.DEBUG, messagePattern, arguments);
    }

    /**
     * <p>Logs a message, compiled from message pattern and values from the evaluated argument suppliers, with {@link Level#DEBUG}.</p>
     * Same as: {@link #log(Level, String, Supplier...) Logw.log(Level.DEBUG, messagePattern, argumentSuppliers)}
     */
    public static void debug(String messagePattern, Supplier<Object>... argumentSuppliers) {
        Logw.log(Level.DEBUG, messagePattern, argumentSuppliers);
    }

    /**
     * <p>Logs a simple log message with {@link Level#INFO}.</p>
     * Same as: {@link #log(Level, String) Logw.log(Level.INFO, message)}
     */
    public static void info(String message) {
        Logw.log(Level.INFO, message);
    }

    /**
     * <p>Logs a message, compiled from message pattern and the arguments, with {@link Level#INFO}.</p>
     * Same as: {@link #log(Level, String, Object...) Logw.log(Level.INFO, messagePattern, arguments)}
     */
    public static void info(String messagePattern, Object... arguments) {
        Logw.log(Level.INFO, messagePattern, arguments);
    }

    /**
     * <p>Logs a message, compiled from message pattern and values from the evaluated argument suppliers, with {@link Level#INFO}.</p>
     * Same as: {@link #log(Level, String, Supplier...) Logw.log(Level.INFO, messagePattern, argumentSuppliers)}
     */
    public static void info(String messagePattern, Supplier<Object>... argumentSuppliers) {
        Logw.log(Level.INFO, messagePattern, argumentSuppliers);
    }

    /**
     * <p>Logs a simple log message with {@link Level#WARN}.</p>
     * Same as: {@link #log(Level, String) Logw.log(Level.WARN, message)}
     */
    public static void warn(String message) {
        Logw.log(Level.WARN, message);
    }

    /**
     * <p>Logs a message, compiled from message pattern and the arguments, with {@link Level#WARN}.</p>
     * Same as: {@link #log(Level, String, Object...) Logw.log(Level.WARN, messagePattern, arguments)}
     */
    public static void warn(String messagePattern, Object... arguments) {
        Logw.log(Level.WARN, messagePattern, arguments);
    }

    /**
     * <p>Logs a message, compiled from message pattern and values from the evaluated argument suppliers, with {@link Level#WARN}.</p>
     * Same as: {@link #log(Level, String, Supplier...) Logw.log(Level.WARN, messagePattern, argumentSuppliers)}
     */
    public static void warn(String messagePattern, Supplier<Object>... argumentSuppliers) {
        Logw.log(Level.WARN, messagePattern, argumentSuppliers);
    }

    /**
     * <p>Logs a simple log message with {@link Level#ERROR}.</p>
     * Same as: {@link #log(Level, String) Logw.log(Level.ERROR, message)}
     */
    public static void error(String message) {
        Logw.log(Level.ERROR, message);
    }
    /**
     * <p>Logs a message, compiled from message pattern and the arguments, with {@link Level#ERROR}.</p>
     * Same as: {@link #log(Level, String, Object...) Logw.log(Level.ERROR, messagePattern, arguments)}
     */
    public static void error(String messagePattern, Object... arguments) {
        Logw.log(Level.ERROR, messagePattern, arguments);
    }

    /**
     * <p>Logs a message, compiled from message pattern and values from the evaluated argument suppliers, with {@link Level#ERROR}.</p>
     * Same as: {@link #log(Level, String, Supplier...) Logw.log(Level.ERROR, messagePattern, argumentSuppliers)}
     */
    public static void error(String messagePattern, Supplier<Object>... argumentSuppliers) {
        Logw.log(Level.ERROR, messagePattern, argumentSuppliers);
    }

    /**
     * <p>Logs a simple log message with the given log level to a logger named with the class of the caller of this method.</p>
     */
    public static void log(Level level, String message) {

        String loggerName = NameDiscoverer.discoverer();

        if(!logger.isLoggable(loggerName, level))
            return;

        logger.log(loggerName, level, message);
    }

    /**
     * <p>Logs a message, compiled from message pattern and the arguments, with the given log level to a logger named with the class of the caller of this method.</p>
     */
    public static void log(Level level, String messagePattern, Object... arguments) {

        String loggerName = NameDiscoverer.discoverer();

        if(!logger.isLoggable(loggerName, level))
            return;

        logger.log(loggerName, level, MessageFormatter.format(messagePattern, arguments));
    }

    /**
     * <p>Logs a message, compiled from message pattern and values from the evaluated argument suppliers, with the given log level to a logger named with the class of the caller of this method.</p>
     */
    public static void log(Level level, String messagePattern, Supplier<Object>... argumentSuppliers) {

        String loggerName = NameDiscoverer.discoverer();

        if(!logger.isLoggable(loggerName, level))
            return;

        Object[] arguments = new Object[argumentSuppliers.length];

        for(int i = 0; i < argumentSuppliers.length; i++){
            arguments[i] = argumentSuppliers[i].get();
        }

        logger.log(loggerName, level, MessageFormatter.format(messagePattern, arguments));
    }

}
