package challenge.processor;

import challenge.dto.Contact;

import java.util.ArrayList;
import java.util.List;

import static challenge.comparator.ContactComparator.compare;

public class ContactProcessor {

    public static List<String> identifyPossibleDuplicates(List<Contact> contacts) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {
            for (int j = i + 1; j < contacts.size(); j++) {
                String accuracy = compare(contacts.get(i), contacts.get(j));
                if (!accuracy.equals("None")) {
                    results.add("Contact ID: " + contacts.get(i).getContactID() + " matches Contact ID: " + contacts.get(j).getContactID() + " with Accuracy: " + accuracy);
                }
            }
        }
        return results;
    }
}

