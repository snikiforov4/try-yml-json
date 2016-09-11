package ua.nikiforov.trymljson.yml.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author snikiforov
 */
public final class Languages {
    private final List<Language> languages;

    public Languages(@JsonProperty(value = "Languages") List<Language> languages) {
        this.languages = ImmutableList.copyOf(languages);
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
