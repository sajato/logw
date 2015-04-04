package de.sajato.logw;

import java.lang.reflect.Method;

public class NameDiscoverer {

    private static Method stackTraceMethod;
    private static boolean hasSunReflection;

    static {
        try {
            stackTraceMethod = Throwable.class.getDeclaredMethod("getStackTraceElement", int.class);
            stackTraceMethod.setAccessible(true);
            StackTraceElement stackTraceElement = (StackTraceElement) stackTraceMethod.invoke(new Throwable(), 0);
            if (!NameDiscoverer.class.getName().equals(stackTraceElement.getClassName())) {
                stackTraceMethod = null;
            }
        } catch (Throwable ex) {
            stackTraceMethod = null;
        }

        try {
            @SuppressWarnings({"restriction", "deprecation"})
            Class<?> caller = sun.reflect.Reflection.getCallerClass(1);
            hasSunReflection = NameDiscoverer.class.equals(caller);
        } catch (Throwable ex) {
            hasSunReflection = false;
        }
    }

    public static String discoverer(){
        return discoverer(5);
    }

    public static String discoverer(int deep){
        StackTraceElement stackTraceElement = getStackTraceElement(deep, false);

        return stackTraceElement.getClassName();
    }

    // From tinylog (https://github.com/pmwmedia/tinylog/blob/master/tinylog/src/main/java/org/pmw/tinylog/Logger.java)
    @SuppressWarnings({"deprecation", "restriction"})
    private static StackTraceElement getStackTraceElement(final int deep, final boolean onlyClassName) {
        if (onlyClassName && hasSunReflection) {
            try {
                return new StackTraceElement(sun.reflect.Reflection.getCallerClass(deep + 1).getName(), "<unknown>", "<unknown>", -1);
            } catch (Exception ex) {
//                InternalLogger.warn(ex, "Failed to get caller class from sun.reflect.Reflection");
            }
        }

        if (stackTraceMethod != null) {
            try {
                return (StackTraceElement) stackTraceMethod.invoke(new Throwable(), deep);
            } catch (Exception ex) {
//                InternalLogger.warn(ex, "Failed to get single stack trace element from throwable");
            }
        }

        return new Throwable().getStackTrace()[deep];
    }

}
