package ua.nikiforov.tryml.jdk8;

import org.junit.Test;
import ua.nikiforov.tryml.jdk8.model.Contact;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author snikiforov
 */
public class Jdk8ModuleFeaturesTest {

    @Test
    public void shouldReadContactsWithOptionalFields() throws Exception {
        List<Contact> contacts = new Jdk8ModuleFeatures().readContactsLists().getContacts();
        Contact kate = contacts.stream().filter(c -> c.getName().equals("Kate")).findFirst().orElseThrow(RuntimeException::new);
        assertTrue(kate.getPhone().isPresent());
        assertFalse(kate.getEmail().isPresent());

        Contact mike = contacts.stream().filter(c -> c.getName().equals("Mike")).findFirst().orElseThrow(RuntimeException::new);
        assertFalse(mike.getPhone().isPresent());
        assertTrue(mike.getEmail().isPresent());
    }

}