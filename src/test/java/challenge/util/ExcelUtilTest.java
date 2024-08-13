package challenge.util;

import challenge.dto.Contact;
import challenge.exception.CSVParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

import static challenge.util.ExcelUtil.loadContactsFromCSV;
import static org.junit.jupiter.api.Assertions.*;

public class ExcelUtilTest {
    @Test
    public void testLoadContactsFromCSV_ValidFile(@TempDir Path tempDir) throws Exception {
        File tempFile = tempDir.resolve("contacts.csv").toFile();
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("contactID,name,name1,email,postalZip,address\n");
            writer.write("1,Matias,Gonzales,matias.gonzales@example.com,12345,123 Elm St\n");
            writer.write("2,Juan,Simiand,juan.simiand@example.com,67890,456 Oak St\n");
            writer.write("3,Lucas,Ballesteros,lucas.ballesteros@example.com,11111,789 Pine St\n");
        }

        List<Contact> contacts = loadContactsFromCSV(tempFile.getAbsolutePath());

        assertEquals(3, contacts.size());
        assertEquals(1, contacts.get(0).getContactID());
        assertEquals("Matias", contacts.get(0).getFirstName());
    }

    @Test
    public void testLoadContactsFromCSV_FileWithMissingValues(@TempDir Path tempDir) throws Exception {
        File tempFile = tempDir.resolve("contacts_with_missing_values.csv").toFile();
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("contactID,name,name1,email,postalZip,address\n");
            writer.write("1,Matias,,matias.gonzales@example.com,,\n");
            writer.write("2,,Simiand,,67890,456 Oak St\n");
        }

        List<Contact> contacts = loadContactsFromCSV(tempFile.getAbsolutePath());

        assertEquals(2, contacts.size());
        assertEquals("Matias", contacts.get(0).getFirstName());
        assertEquals("", contacts.get(0).getZipCode());
    }

    @Test
    public void testLoadContactsFromCSV_FileNotFound() {
        Exception exception = assertThrows(CSVParseException.class, () -> {
            loadContactsFromCSV("non_existing_file.csv");
        });
        assertEquals("Error reading or parsing the CSV file.", exception.getMessage());
    }
}

