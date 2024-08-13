package challenge.processor;

import challenge.dto.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class ContactProcessorTest {

    @Test
    public void testIdentifyPossibleDuplicates() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Matias", "Gonzales", "matias.gonzales@example.com", "12345", "123 Elm St"));
        contacts.add(new Contact(2, "Matias", "Gonzales", "matias.gonzales@example.com", "12345", "123 Elm St"));

        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("Contact ID: 1 matches Contact ID: 2 with Accuracy: High");

        List<String> results = ContactProcessor.identifyPossibleDuplicates(contacts);

        assertEquals(expectedResults, results, "The identified duplicates did not match the expected results.");
    }
}


