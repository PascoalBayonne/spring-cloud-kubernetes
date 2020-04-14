package pt.com.cetelem.configmapexample.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.com.cetelem.configmapexample.configuration.PropertiesConfiguration;

@Component
public class SimpleScheduler {


    private final PropertiesConfiguration propertiesConfiguration;

    public SimpleScheduler(PropertiesConfiguration propertiesConfiguration) {
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @Scheduled(fixedDelay = 3000)
    public void printMyConfigMap() {
        System.out.println("");
        System.out.println(propertiesConfiguration.getMessage());
    }
}
