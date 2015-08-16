package eu.sajato.logw;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NameDiscovererTest {

    @Test
    public void testDiscoverer() throws Exception {
        assertThat(NameDiscoverer.discoverer(2), is(NameDiscovererTest.class.getName()));
    }
}
