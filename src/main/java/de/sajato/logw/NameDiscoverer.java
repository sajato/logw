package de.sajato.logw;

import java.lang.reflect.Method;

public class NameDiscoverer {

    private static Method stackTraceMethod;

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
    }

    public static String discoverer() {
        return discoverer(5);
    }

    public static String discoverer(int deep) {
        StackTraceElement stackTraceElement = getStackTraceElement(deep, false);

        return stackTraceElement.getClassName();
    }

    // From tinylog (https://github.com/pmwmedia/tinylog/blob/master/tinylog/src/main/java/org/pmw/tinylog/Logger.java)
    @SuppressWarnings("all")
    private static StackTraceElement getStackTraceElement(final int deep) {
        if (stackTraceMethod != null) {
            try {
                return (StackTraceElement) stackTraceMethod.invoke(new Throwable(), deep);
            } catch (Exception ex) {
                // Failed to get single stack trace element from throwable.
            }
        }

        return new Throwable().getStackTrace()[deep];
    }

}
