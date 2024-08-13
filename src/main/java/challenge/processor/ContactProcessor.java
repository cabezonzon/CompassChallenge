package challenge.processor;

import challenge.dto.Contact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static challenge.comparator.ContactComparator.compare;

public class ContactProcessor {

    public static List<String> identifyPossibleDuplicates(List<Contact> contacts) {
        List<String> results = new ArrayList<>();
        Set<String> processedPairs = new HashSet<>();

        for (int i = 0; i < contacts.size(); i++) {
            Contact sourceContact = contacts.get(i);
            for (int j = i + 1; j < contacts.size(); j++) {
                Contact targetContact = contacts.get(j);
                String pairKey = generatePairKey(sourceContact.getContactID(), targetContact.getContactID());
                if (!processedPairs.contains(pairKey)) {
                    String accuracy = compare(sourceContact, targetContact);
                    if (!accuracy.equals("None")) {
                        String result = "Contact ID: " + sourceContact.getContactID() +
                                " matches Contact ID: " + targetContact.getContactID() +
                                " with Accuracy: " + accuracy;
                        results.add(result);
                    }
                    processedPairs.add(pairKey);
                }
            }
        }

        return results;
    }

    private static String generatePairKey(int id1, int id2) {
        return Math.min(id1, id2) + "-" + Math.max(id1, id2);
    }
}

