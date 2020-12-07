import eu.sajato.logw.Logw;

public class DemoW {

    static void call() {

        Logw.debug("Call 1 from class W");

        Logw.info("Call {} from class W!", 1 + 1);

        Logw.debug("Call 3 from class W with slow computation (result={})", () -> Main.slowComputation());
    }

}
