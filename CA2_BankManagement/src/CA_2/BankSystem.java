/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Giu
 */
public class BankSystem { // This is the Main class for the Bank Mangement System.

    //Attributes
    private static ArrayList<Person> employeeList = new ArrayList < > (); //employeeList is a ArrayList that store all employees loaded from the file + the one that we added manually.  

    public static void main(String[] args) {

        Scanner myKb = new Scanner(System.in);

        System.out.println();//I´m printing the blank line for a better readability only. 
        System.out.println("═══════════════════════════════════════════════");
        System.out.println(" Welcome to CCT Bank Management System");
        System.out.println(" Employee Data Management & Analysis");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println();

        //Ask user for file name.
        System.out.println("Please enter the filename to read: ");
        String filename = myKb.nextLine();
        System.out.println();

        boolean fileLoaded = loadDataFromFile(filename);

        if (!fileLoaded) {
            System.out.println("❌ Program cannot continue without data. Exiting...");
            myKb.close();
            return; //ends program.
        }

        System.out.println("File read successfully!");
        System.out.println();

        boolean running = true;

        while (running) { //Menu loop starts. 
            MenuOption.displayMenu();
            int choice = myKb.nextInt();
            myKb.nextLine();

            MenuOption option = MenuOption.fromCode(choice);

            //Validating the choice.
            if (option == null) {
                System.out.println();
                System.out.println("❌ Invalid option! Please choose a number from the menu.");
                continue; //Shows the menu again. 
            }

            System.out.println();

            switch (option) {
                case SORT -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Sort Employees");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    System.out.println("Sorting feature will be implemented soon.");
                    System.out.println("Will use: Recursive sorting (MergeSort or QuickSort)");
                    System.out.println("Current employees loaded: " + employeeList.size());
                }

                case SEARCH -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Search for Employee");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    System.out.println("Search feature will be implemented soon.");
                    System.out.println("Will use: Binary Search or Linear Search");
                    System.out.println("Current employees loaded: " + employeeList.size());
                }

                case ADD_RECORDS -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Add New Employee Record");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    System.out.println("Add Records feature will be implemented coon.");
                    System.out.println("Will allow: Manual input with validation");
                    System.out.println("Will validate: Manager Type and Department exist");
                }

                case CREATE_TREE -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Create Employee Binary Tree");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    System.out.println("Binary tree feature will be implemented soon.");
                    System.out.println("Will use: Level-order insertion (breadth-first)");
                    System.out.println("Current employees loaded: " + employeeList.size());
                }

                case DISPLAY_TREE -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Display Tree Traversals");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    System.out.println("Tree must be created first (Option 4).");
                    System.out.println("Will show: Preorder, Inorder, Postorder traversals");
                    System.out.println("Plus: Tree height and node count");
                }

                case EXIT -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("Exiting CCT Bank Management System");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();
                    System.out.println("Thank you for using the system!");
                    System.out.println("Goodbye!");
                    System.out.println();

                    running = false;
                }
            }
        }
    }    
        

    private static boolean loadDataFromFile(String filename) {

        try {
            try (Scanner fileScanner = new Scanner(new FileReader(filename))) {
                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }   //Basically skip the header line.
                
                employeeList.clear(); //Clean the existing data.
                
                int recordCount = 0; //The record count will always start on 0.
                
                while (fileScanner.hasNextLine()) { //Read each line
                    String line = fileScanner.nextLine();
                    
                    if (line.trim().isEmpty()) {
                        continue;
                    } // Skip the empty lines.
                    
                    String[] fields = line.split(","); //inform that they are split by a comma.
                    
                    if (fields.length != 9) {
                        continue;
                    } // check if we have 9 fields.
                    
                    //Extract fields
                    String firstName = fields[0].trim();
                    String lastName = fields[1].trim();
                    String gender = fields[2].trim();
                    String email = fields[3].trim();
                    String department = fields[5].trim();
                    String position = fields[6].trim();
                    String jobTitle = fields[7].trim();
                    String branch = fields[8].trim();
                    
                    double salary = 0.0;
                    try {
                        salary = Double.parseDouble(fields[4].trim());
                    } catch (NumberFormatException e) {
                        //Invalid salary, will use default.
                    }
                    
                    // Create Person
                    Person person = new Person(firstName, lastName, gender, email,
                            salary, department, position, jobTitle, branch);
                    
                    // Add to list
                    employeeList.add(person);
                    recordCount++;
                }
            }
            
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: File '" + filename + "' not found!");
            System.out.println("Please check the filename and try again.");
        } catch (Exception e) {
            // Other error
            System.out.println("❌ Error reading file: " + e.getMessage());
            return false;
        }
        return false;
    }
}
