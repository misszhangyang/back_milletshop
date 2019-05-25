package milletshop.millet.monitor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

public class MonitorServer implements ApplicationListener, ApplicationContextInitializer {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("the applicationContextEvent is start");
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

    }
}
