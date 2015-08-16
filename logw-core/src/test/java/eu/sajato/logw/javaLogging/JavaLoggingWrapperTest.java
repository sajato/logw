package eu.sajato.logw.javaLogging;

import eu.sajato.logw.Level;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JavaLoggingWrapperTest {

    @Test
    public void convertLevelTest(){
        JavaLoggingWrapper cut = new JavaLoggingWrapper();

        assertThat(cut.convertLevel(Level.TRACE), is(java.util.logging.Level.FINEST));
        assertThat(cut.convertLevel(Level.DEBUG), is(java.util.logging.Level.FINE));
        assertThat(cut.convertLevel(Level.INFO), is(java.util.logging.Level.INFO));
        assertThat(cut.convertLevel(Level.WARN), is(java.util.logging.Level.WARNING));
        assertThat(cut.convertLevel(Level.ERROR), is(java.util.logging.Level.SEVERE));
    }

    @Test
    @Ignore
    public void getLoggerTest(){
        JavaLoggingWrapper cut = new JavaLoggingWrapper();

//        assertThat(cut.getLogger().getName(), is(JavaLoggingWrapperTest.class.getName()));
    }

}
