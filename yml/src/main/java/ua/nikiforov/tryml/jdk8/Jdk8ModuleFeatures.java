package ua.nikiforov.tryml.jdk8;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import ua.nikiforov.tryml.jdk8.model.Contacts;

import java.io.IOException;

/**
 * @author snikiforov
 */
public class Jdk8ModuleFeatures {

    public Contacts readContactsLists() throws IOException {
        ObjectMapper mapper = getMapper();
        return mapper.readValue(this.getClass().getClassLoader().getResource("contacts.yml"), Contacts.class);
    }

    private YAMLMapper getMapper() {
        YAMLMapper mapper = new YAMLMapper(new YAMLFactory());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).registerModule(new Jdk8Module());
        return mapper;
    }

}
