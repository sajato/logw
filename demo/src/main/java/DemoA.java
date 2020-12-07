import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoA {

    private static final Logger logger = LogManager.getLogger(DemoA.class);

    static void call() {

        logger.debug("Call 1 from class A");

        logger.info("Call {} from class A!", 1 + 1);

        logger.debug("Call 3 from class A with slow computation (result={})", Main.slowComputation());
    }

}
