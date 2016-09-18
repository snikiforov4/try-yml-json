package ua.nikiforov.tryml.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.util.UUID;

/**
 * @author snikiforov
 */
public abstract class ReloadableYmlConfig<T> implements ReloadableConfig {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected T h;

    private T parse(String uri) throws IOException {
        ObjectMapper mapper = new YAMLMapper(new YAMLFactory());
        configMapper(mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));

        @SuppressWarnings("unchecked")
        Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return uri.startsWith("http:") ?
                mapper.readValue(new URL(uri + "?" + UUID.randomUUID()), type) :
                mapper.readValue(new File(uri), type);
    }

    protected ObjectMapper configMapper(ObjectMapper mapper) {
        return mapper;
    }

    @Override
    public void reload(String uri) {
        try {
            h = parse(uri);
            logger.info("Config {} has been reloaded", getClass().getSimpleName());
        } catch (IOException e) {
            logger.error("Error reloading " + getClass().getSimpleName(), e);
            throw Throwables.propagate(e);
        }
    }
}
