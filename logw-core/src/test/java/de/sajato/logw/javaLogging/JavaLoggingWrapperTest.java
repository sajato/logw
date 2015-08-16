package de.sajato.logw.javaLogging;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JavaLoggingWrapperTest {

    @Test
    public void convertLevelTest(){
        JavaLoggingWrapper cut = new JavaLoggingWrapper();

        assertThat(cut.convertLevel(de.sajato.logw.Level.TRACE), is(java.util.logging.Level.FINEST));
        assertThat(cut.convertLevel(de.sajato.logw.Level.DEBUG), is(java.util.logging.Level.FINE));
        assertThat(cut.convertLevel(de.sajato.logw.Level.INFO), is(java.util.logging.Level.INFO));
        assertThat(cut.convertLevel(de.sajato.logw.Level.WARN), is(java.util.logging.Level.WARNING));
        assertThat(cut.convertLevel(de.sajato.logw.Level.ERROR), is(java.util.logging.Level.SEVERE));
    }

    @Test
    @Ignore
    public void getLoggerTest(){
        JavaLoggingWrapper cut = new JavaLoggingWrapper();

//        assertThat(cut.getLogger().getName(), is(JavaLoggingWrapperTest.class.getName()));
    }

}
