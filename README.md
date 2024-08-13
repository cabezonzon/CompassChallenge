# CompassChallenge

## Contact Duplicate Identification

This project is designed to identify potential duplicate contacts from a CSV file, using various comparison criteria and
scoring methods. The project includes functionalities to read contact data from a CSV file, compare contacts for
potential duplicates, and handle missing or null values.

## Project Structure

1. Contact Class: Represents a contact with fields such as contactID, firstName, lastName, email, postalZip, and
   address.

2. ContactComparator Class: Contains a method to compare two Contact objects based on various criteria and return a
   similarity score.

3. ContactProcessor Class: Reads contact data from a CSV file, processes the data, and identifies potential duplicates.