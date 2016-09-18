package ua.nikiforov.tryml.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author snikiforov
 */
public final class DefaultUserSettingsConfig extends ReloadableYmlConfig<DefaultUserSettingsConfig.Holder> {

    static class Holder {

        private final String name;
        private final String country;

        Holder(@JsonProperty("name") String name,
               @JsonProperty("country") String country) {
            this.name = name;
            this.country = country;
        }
    }

    public String getName() {
        return h.name;
    }

    public String getCountry() {
        return h.country;
    }
}
