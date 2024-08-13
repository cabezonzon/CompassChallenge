package challenge.comparator;

import challenge.dto.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ContactComparator {

    public static String compare(Contact c1, Contact c2) {
        // Map of comparison functions and their respective magnitude
        // We use the Strategy Pattern here to dynamically select and apply different comparison criteria.
        // Each entry in the map represents a different strategy for comparing two Contact objects based on a specific attribute.
        // BiFunction: Represents a function that accepts two arguments and produces a result
        Map<BiFunction<Contact, Contact, Boolean>, Integer> criteria = new HashMap<>();
        criteria.put((a, b) -> a.getFirstName().equalsIgnoreCase(b.getFirstName()), 3);
        criteria.put((a, b) -> a.getLastName().equalsIgnoreCase(b.getLastName()), 3);
        criteria.put((a, b) -> a.getEmailAddress().equalsIgnoreCase(b.getEmailAddress()), 4);
        criteria.put((a, b) -> a.getAddress().equalsIgnoreCase(b.getAddress()), 2);
        criteria.put((a, b) -> a.getZipCode().equalsIgnoreCase(b.getZipCode()), 1);

        int score = 0;
        int maxScore = 0;

        for (Map.Entry<BiFunction<Contact, Contact, Boolean>, Integer> criterion : criteria.entrySet()) {
            maxScore += criterion.getValue();
            // If the comparison is true, we add the criterion magnitude
            if (criterion.getKey().apply(c1, c2)) {
                score += criterion.getValue();
            }
        }

        // Calculate accuracy based on the score
        double accuracy = (double) score / maxScore;

        if (accuracy == 1.0) {
            return "High";
        } else if (accuracy >= 0.6) {
            return "Medium";
        } else if (accuracy > 0) {
            return "Low";
        } else {
            return "None";
        }
    }
}
