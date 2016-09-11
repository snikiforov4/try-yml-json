package ua.nikiforov.tryml.ignore;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ua.nikiforov.tryml.ignore.model.Languages;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author snikiforov
 */
public class IgnoreUnknownProperties {
    public Languages readLanguages() throws URISyntaxException, IOException {
        ObjectMapper mapper = getMapper();
        return mapper.readValue(this.getClass().getClassLoader().getResource("languages.yml"), Languages.class);
    }

    private YAMLMapper getMapper() {
        YAMLMapper mapper = new YAMLMapper(new YAMLFactory());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
