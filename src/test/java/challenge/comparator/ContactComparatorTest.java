package challenge.comparator;

import challenge.dto.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactComparatorTest {

    @Test
    public void testCompareHighAccuracy() {
        Contact contact1 = new Contact(1, "Matias", "Gonzales", "mati.go@example.com", "12345", "123 pepe");
        Contact contact2 = new Contact(2, "Matias", "Gonzales", "mati.go@example.com", "12345", "123 pepe");

        String result = ContactComparator.compare(contact1, contact2);
        assertEquals("High", result, "Contacts should have high accuracy.");
    }

    @Test
    public void testCompareMediumAccuracy() {
        Contact contact1 = new Contact(1, "Matias", "Gonzales", "mati.go@example.com", "12345", "123 pepe");
        Contact contact2 = new Contact(2, "Matias", "Gonzales", "mati@example.com", "12345", "123 pepe");

        String result = ContactComparator.compare(contact1, contact2);
        assertEquals("Medium", result, "Contacts should have medium accuracy.");
    }

    @Test
    public void testCompareLowAccuracy() {
        Contact contact1 = new Contact(1, "Matias", "Gonzales", "mati.go@example.com", "12345", "123 pepe");
        Contact contact2 = new Contact(2, "Lucas", "Gonzales", "mati@example.com", "12345", "123 pepe");

        String result = ContactComparator.compare(contact1, contact2);
        assertEquals("Low", result, "Contacts should have low accuracy.");
    }

    @Test
    public void testCompareNoneAccuracy() {
        Contact contact1 = new Contact(1, "Matias", "Gonzales", "mati.go@example.com", "12345", "123 pepe");
        Contact contact2 = new Contact(2, "Lucas", "Rodo", "lu.ro@example.com", "67890", "456 test");

        String result = ContactComparator.compare(contact1, contact2);
        assertEquals("None", result, "Contacts should have no accuracy.");
    }
}

