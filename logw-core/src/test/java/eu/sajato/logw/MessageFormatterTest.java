package eu.sajato.logw;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessageFormatterTest {

    @Test
    public void testFormat() throws Exception {
        String formattedMessage = MessageFormatter.format("Test {}", new Object[] {"String"});
        assertThat(formattedMessage, is("Test String"));
    }
}
