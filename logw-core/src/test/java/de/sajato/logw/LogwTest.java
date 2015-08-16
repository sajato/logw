package de.sajato.logw;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
@SuppressWarnings("unchecked")
public class LogwTest {

    @Mocked
    LoggingWrapper loggingWrapper;

    @Test
    public void warnStringTest(){

        new NonStrictExpectations(){{
            loggingWrapper.log(anyString, Level.WARN, "Test");
            times = 1;

            loggingWrapper.isLoggable(anyString, Level.WARN);
            result = true;
        }};

        Logw.setInnerLogger(loggingWrapper);
        Logw.warn("Test");
    }

    @Test
    public void warnParameterTest(){

        new NonStrictExpectations(){{
            loggingWrapper.log(anyString, Level.WARN, "Hello Test");
            times = 1;

            loggingWrapper.isLoggable(anyString, Level.WARN);
            result = true;
        }};

        Logw.setInnerLogger(loggingWrapper);
        Logw.warn("Hello {}", "Test");
    }

    @Test
    public void warnSupplierTest(){

        new NonStrictExpectations(){{
            loggingWrapper.log(anyString, Level.WARN, "Hello Test");
            times = 1;

            loggingWrapper.isLoggable(anyString, Level.WARN);
            result = true;
        }};

        Logw.setInnerLogger(loggingWrapper);
        Logw.warn("Hello {}", () -> "Test");
    }

}
