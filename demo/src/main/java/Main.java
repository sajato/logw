import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class Main {

    public static void main(String[] args) {

        configLog4J();

        DemoA.call();

        DemoB.call();

        DemoW.call();

    }

    public static String slowComputation() {

        System.out.println("slow computation in progress ...");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "output";
    }

    static void configLog4J() {
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        builder.setStatusLevel(Level.INFO);
        builder.setConfigurationName("Log4JDemo");

        // set pattern layout
        AppenderComponentBuilder appenderBuilder = builder.newAppender("Errout", "CONSOLE").addAttribute("target", ConsoleAppender.Target.SYSTEM_ERR);
        appenderBuilder.add(builder.newLayout("PatternLayout").addAttribute("pattern", "%d %-5level [%c:%L]: %m%n"));
        builder.add(appenderBuilder);

        // set log level
        builder.add(builder.newRootLogger(Level.INFO).add(builder.newAppenderRef("Errout")));

        Configurator.initialize(builder.build());
    }

}
