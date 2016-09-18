package ua.nikiforov.tryml.config;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author snikiforov
 */
public class DefaultUserSettingsConfigTest {

    @Test
    public void shouldReadConfig() throws Exception {
        DefaultUserSettingsConfig config = new DefaultUserSettingsConfig();
        config.reload("src/test/resources/yml/defaultUserSettings.yml");
        assertEquals("Guest", config.getName());
    }
}