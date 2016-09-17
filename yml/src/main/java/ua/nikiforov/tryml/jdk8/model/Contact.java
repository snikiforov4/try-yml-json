package ua.nikiforov.tryml.jdk8.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

/**
 * @author snikiforov
 */
public class Contact {

    private final String name;
    private final Optional<String> phone;
    private final Optional<String> email;

    public Contact(@JsonProperty("name") String name,
                   @JsonProperty("phone") Optional<String> phone,
                   @JsonProperty("email") Optional<String> email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getPhone() {
        return phone;
    }

    public Optional<String> getEmail() {
        return email;
    }
}
