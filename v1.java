import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class v1 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create ArrayLists to store visitor data
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> purpose = new ArrayList<>();
        ArrayList<String> contact = new ArrayList<>();
        ArrayList<String> visitDate = new ArrayList<>();
        ArrayList<String> work = new ArrayList<>();

        // Reading data from the Visitors.txt file
        File file = new File("visitors.txt");
        Scanner fileScanner = new Scanner(file);

        // Loop through the file and read 10 lines (or less, if there are fewer)
        int count = 0;
        while (fileScanner.hasNextLine() && count < 10) {
            String line = fileScanner.nextLine();  // Read the next line
            String[] data = line.split(",");  // Split the line by commas

            if (data.length == 5) {  // Check if there are exactly 5 fields
                // Add each piece of data to the appropriate ArrayList
                names.add(data[0].trim());      // Name
                purpose.add(data[1].trim());    // Purpose
                contact.add(data[2].trim());    // Contact
                visitDate.add(data[3].trim());  // Visit Date
                work.add(data[4].trim());       // Work
                count++;  // Increment count after reading each visitor's data
            } else {
                System.out.println("Skipping malformed line: " + line);
            }
        }

        // Close the scanner after processing the file
        fileScanner.close();

        // Display the visitor information
        System.out.println("Visitor information:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Visitor " + (i + 1) + ": ");
            System.out.println("Name: " + names.get(i));
            System.out.println("Purpose: " + purpose.get(i));
            System.out.println("Contact: " + contact.get(i));
            System.out.println("Visit Date: " + visitDate.get(i));
            System.out.println("Work: " + work.get(i));
            System.out.println();  // Print a blank line between visitors
        }

        // Ask the user for multiple search queries
        Scanner inputScanner = new Scanner(System.in);
        String searchName;
        boolean found;

        // Repeat search until the user decides to exit
        while (true) {
            System.out.print("Enter the name of the visitor you want to search for (or type 'exit' to stop): ");
            searchName = inputScanner.nextLine().trim();

            // If user wants to exit
            if (searchName.equalsIgnoreCase("exit")) {
                System.out.println("Exiting search.");
                break;
            }

            // Perform the search in the names list
            found = false;
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equalsIgnoreCase(searchName)) {
                    // If a match is found, print the details
                    System.out.println("\nVisitor found: ");
                    System.out.println("Visitor " + (i + 1) + ": ");
                    System.out.println("Name: " + names.get(i));
                    System.out.println("Purpose: " + purpose.get(i));
                    System.out.println("Contact: " + contact.get(i));
                    System.out.println("Visit Date: " + visitDate.get(i));
                    System.out.println("Work: " + work.get(i));
                    found = true;
                    break;  // Exit the loop once the visitor is found
                }
            }

            if (!found) {
                System.out.println("Visitor not found.");
            }
        }

        inputScanner.close();  // Close the input scanner
    }
}
