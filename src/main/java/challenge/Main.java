package challenge;

import challenge.dto.Contact;
import challenge.exception.CSVParseException;

import java.util.List;

import static challenge.processor.ContactProcessor.identifyPossibleDuplicates;
import static challenge.util.ExcelUtil.loadContactsFromCSV;

public class Main {
    public static void main(String[] args) throws CSVParseException {
        List<Contact> contacts = loadContactsFromCSV("src/main/resources/contactFile.csv");
        List<String> duplicates = identifyPossibleDuplicates(contacts);

        for (String result : duplicates) {
            System.out.println(result);
        }
    }
}