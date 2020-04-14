package pt.com.cetelem.configmapexample.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.com.cetelem.configmapexample.configuration.PropertiesConfiguration;

@RestController
@RequestMapping(value = "/configmap")
public class ConfigMapController {

    @Value("${default.configmap}")
    private String defaultConfigMapMsg;

    @Value("${TEMP_DIR}")
    private String tempDirectory;

    private final PropertiesConfiguration propertiesConfiguration;

    public ConfigMapController(PropertiesConfiguration propertiesConfiguration) {
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @GetMapping
    public ResponseEntity<String> getConfigMap(@RequestBody final String configMap) {
        if (configMap == null || configMap.isEmpty()) {
            return new ResponseEntity<>("Given configMap is blank", HttpStatus.BAD_REQUEST);
        }
        System.getenv().forEach((s, s2) -> System.out.println(s+" : "+s2));

        System.out.println("\n\n");
        System.out.println("\n Now reading the value assigned in my prop file: TEMP_DIR => "+tempDirectory);

        String foundConfigMap = System.getenv(configMap);
        if (foundConfigMap == null){
            return new ResponseEntity<>("ConfigMap not found. Please provide it using K8S configMap", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(String.format(defaultConfigMapMsg, foundConfigMap));
    }

    @GetMapping(value = "/properties/message")
    public String getMessageFormProperties(){
        return propertiesConfiguration.getMessage();
    }
}
