//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import de.sajato.logw.Logw;

public class Temp {

    public static void main(String[] args) {
//        System.out.println("wdewfrtz");
//        Logger log = LoggerFactory.getLogger("qwfegd");
//        log.debug("Hello {}", "World");

        Logw.warn("TEST {}", () -> "Mein Test");
    }
}
