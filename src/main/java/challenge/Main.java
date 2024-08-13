package challenge;

import challenge.dto.Contact;
import challenge.exception.CSVParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static challenge.processor.ContactProcessor.identifyPossibleDuplicates;

public class Main {
    public static void main(String[] args) throws CSVParseException {
        List<Contact> contacts = loadContactsFromCSV("src/main/resources/contactFile.csv");
        List<String> duplicates = identifyPossibleDuplicates(contacts);

        for (String result : duplicates) {
            System.out.println(result);
        }
    }


    public static List<Contact> loadContactsFromCSV(String filePath) throws CSVParseException {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Split the line by commas, including empty values
                String[] values = line.split(",", -1);

                // Handle missing values as null or empty strings
                Integer contactID = values.length > 0 && !values[0].isEmpty() ? Integer.parseInt(values[0]) : null;
                String name = values.length > 1 && !values[1].isEmpty() ? values[1] : "";
                String name1 = values.length > 2 && !values[2].isEmpty() ? values[2] : "";
                String email = values.length > 3 && !values[3].isEmpty() ? values[3] : "";
                String postalZip = values.length > 4 && !values[4].isEmpty() ? values[4] : "";
                String address = values.length > 5 && !values[5].isEmpty() ? values[5] : "";

                contacts.add(new Contact(contactID, name, name1, email, postalZip, address));
            }
        } catch (IOException e) {
            throw new CSVParseException("Error reading or parsing the CSV file.", e);
        }

        return contacts;
    }
}