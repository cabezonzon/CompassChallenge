package challenge;

import challenge.dto.Contact;

import java.util.ArrayList;
import java.util.List;

import static challenge.processor.ContactProcessor.identifyPossibleDuplicates;


public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1001, "C", "F", "mollis.lectus.pede@outlook.net", "449-6990 Tellus. Rd.", "39746"));
        contacts.add(new Contact(1002, "C", "French", "mollis.lectus.pede@outlook.net", "449-6990 Tellus. Rd.", "39746"));
        contacts.add(new Contact(1003, "Ciara", "F", "non.lacinia.at@zoho.ca", "449-6990 Tellus. Rd.", "39746"));

        List<String> duplicates = identifyPossibleDuplicates(contacts);

        for (String result : duplicates) {
            System.out.println(result);
        }
    }
}