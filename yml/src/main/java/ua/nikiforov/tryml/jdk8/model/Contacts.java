package ua.nikiforov.tryml.jdk8.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author snikiforov
 */
public class Contacts {

    private final List<Contact> contacts;

    public Contacts(@JsonProperty("Contacts") List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
