package ua.nikiforov.trymljson.yml.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author snikiforov
 */
public final class Language {
    private final String name;
    private final int alphabetSize;

    public Language(@JsonProperty("name") String name,
                    @JsonProperty("alphabet_size") int alphabetSize) {
        this.name = name;
        this.alphabetSize = alphabetSize;
    }

    public String getName() {
        return name;
    }

    public int getAlphabetSize() {
        return alphabetSize;
    }
}
