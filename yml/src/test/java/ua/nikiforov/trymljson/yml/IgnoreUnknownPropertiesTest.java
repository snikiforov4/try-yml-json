package ua.nikiforov.trymljson.yml;

import org.junit.Test;
import ua.nikiforov.trymljson.yml.model.Language;
import ua.nikiforov.trymljson.yml.model.Languages;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author snikiforov
 */
public class IgnoreUnknownPropertiesTest {
    @Test
    public void shouldCorrectReadValues() throws Exception {
        Languages languages = new IgnoreUnknownProperties().readLanguages();

        Optional<Language> french = languages.getLanguages().stream().filter(e -> e.getName().equals("French")).findFirst();
        assertTrue("French language is not present", french.isPresent());
        assertEquals("wrong french alphabet size", 26, french.get().getAlphabetSize());
    }
}