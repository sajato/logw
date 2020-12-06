import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoA {

    static Logger logger = LoggerFactory.getLogger(DemoA.class);

    static void call(){

        if(logger.isDebugEnabled())
            logger.debug("Call 1 from class A");

        if(logger.isInfoEnabled())
            logger.info("This is output no {} from class A!", "2");

    }
}
