import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoB {

    private static final Logger logger = LogManager.getLogger(DemoA.class);

    static void call() {

        if (logger.isDebugEnabled())
            logger.debug("Call 1 from class B");

        if (logger.isInfoEnabled())
            logger.info("Call {} from class B!", 1 + 1);

        if (logger.isDebugEnabled())
            logger.debug("Call 3 from class B with slow computation (result={})", Main.slowComputation());

    }

}
