/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class BankSystem { // This is the Main class for the Bank Mangement System.

    //Attributes
    private static ArrayList<Person> employeeList = new ArrayList<>(); //employeeList is a ArrayList that store all employees loaded from the file + the one that we added manually.  

    private static ArrayList<Person> newRecords = new ArrayList<>(); //newRecords is a ArrayList that stores all added employees. 
    
    private static TreeNode root = null; // 

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
                    System.out.println("Sort Employees in Alphabetical Order");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    if (employeeList.isEmpty()) { // If the list has only one element, return the list and terminate. (Base case)
                        System.out.println("❌ No employees to sort! Please load data first.");
                        System.out.println();
                        break;
                    }

                    //Display list before sorting. Just the first 5 for context. 
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println("BEFORE SORTING:");
                    System.out.println("─────────────────────────────────────────────");
                    showEmployees(5);
                    System.out.println();

                    //Do the sort
                    System.out.println("Sorting...");
                    mergeSort(employeeList, 0, employeeList.size() - 1);
                    System.out.println();

                    //Show after
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println("AFTER SORTING: ");
                    System.out.println("─────────────────────────────────────────────");
                    showEmployees(20);
                    System.out.println();
                    System.out.println("Sorted " + employeeList.size() + " employees alphabetically");
                    System.out.println();
                }

                case SEARCH -> {

                    /**
                     * Searches for an employee by name. ****** IMPORTANT: List
                     * must be sorted first for Binary Search work!
                     */
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Search for Employee");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    //Check if there are employees to be searched. 
                    if (employeeList.isEmpty()) {
                        System.out.println("");
                        System.out.println();
                        break; //If the list is empty, we exit this case and return to the menu. 
                    }

                    //If the list is !empty, we ask the name from user. 
                    System.out.println("Tip: Make sure the list is sorted first (Option 1)");
                    System.out.println("Enter employee name to search: ");
                    String searchName = myKb.nextLine().trim();
                    System.out.println();

                    //Validation to handle in case the user dont input a name.
                    if (searchName.isEmpty()) {
                        System.out.println("❌ Name cannot be empty!");
                        System.out.println();
                        break; // Exit this case and return to menu. 
                    }

                    //Search using Binary Search algorithm
                    System.out.println("Searching for: " + searchName);
                    //Call binarySearch: start=0, end=list.size()-1
                    // This method returns the index if found, or -1 if not found. 
                    int result = binarySearch(employeeList, searchName, 0, employeeList.size() - 1);

                    //Check the result and display appropriate message
                    if (result == -1) {
                        //Employee was not found, this means that the binarySearch returned -1. 
                        System.out.println("❌ Employee not found: " + searchName);
                        System.out.println();
                    } else {
                        //Employee was found, which means that the binarySearch returned a valid index. 
                        System.out.println("Employee Found!");
                        System.out.println();
                        //Them it will display the employee full details. Using printDetails() method that I created in Person class. 
                        employeeList.get(result).printDetails();
                    }
                    System.out.println();
                }

                case ADD_RECORDS -> {

                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Add New Employee Record");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    //Input 1: First Name
                    System.out.print("Enter First Name: ");
                    String firstName = myKb.nextLine().trim();

                    //Input 2: Last Name
                    System.out.print("Enter Last Name: ");
                    String lastName = myKb.nextLine().trim();

                    //validation: Name cannot be empty
                    if (firstName.isEmpty() || lastName.isEmpty()) {
                        System.out.println();
                        System.out.println("❌ ERROR: Name cannot be empty!");
                        System.out.println();
                        break;
                    }

                    //Input  3:Manager Type
                    System.out.println("Select Manager Type:");
                    System.out.println("    1. Branch Manager");
                    System.out.println("    2. Senior Manager");
                    System.out.println("    3. Team Lead");
                    System.out.print("Your choice (1-3): ");

                    //Manager validation
                    String managerChoice = myKb.nextLine().trim();
                    String managerType = validateManagerType(managerChoice);

                    //If validation fails, managerType will be null
                    if (managerType == null) {
                        System.out.println();
                        System.out.println("❌ ERROR: Invalid Manager Type! Must select 1, 2 or 3.");
                        break;
                    }

                    System.out.println();

                    //Input 4: Department Type
                    System.out.println("Select Department Type:");
                    System.out.println("    1. IT Department");
                    System.out.println("    2. Finance Department");
                    System.out.println("    3. HR Department");
                    System.out.println("    4. Loans Department");
                    System.out.print("Your choice (1-4): ");

                    //Department validation
                    String departmentChoice = myKb.nextLine().trim();
                    String department = validateDepartment(departmentChoice);

                    //If validation fails, department will be null
                    if (department == null) {
                        System.out.println();
                        System.out.println("❌ ERROR: Invalid Department! Must select 1, 2, 3 or 4.");
                        break;
                    }

                    //Default values for non-required fields
                    String gender = "Not Specified";
                    String email = firstName.toLowerCase() + lastName.toLowerCase() + "@cctbank.ie";
                    double salary = 50000.0;
                    String position = "Full-Time";
                    String jobTitle = managerType;
                    String branch = "Head Office";

                    //Create a new Person object
                    Person newEmployee = new Person(firstName, lastName, gender, email, salary, department, position, jobTitle, branch);
                    employeeList.add(newEmployee); //Add to main employee list
                    newRecords.add(newEmployee); //Add to newRecords
                    
                    System.out.println();
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("New employee added successfully!");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();
                    //Display the key information
                    System.out.println("Name:       " + newEmployee.getFullName());
                    System.out.println("Manager:    " + managerType);
                    System.out.println("Department: " + department);
                    System.out.println("Email:      " + email);
                    System.out.println("═════════════════════════════════════════════");
                }

                case CREATE_TREE -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Create Employee Binary Tree");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    //Check if we have 20 employees
                    if (employeeList.size() < 20) {
                        System.out.println("❌ Error: Need at least 20 employees to create tree!");
                        System.out.println("Current employees: " + employeeList.size());
                        System.out.println("Please load more data or add more employees.");
                    }
                    
                    root = null; //We need to clean any existing tree.
                    
                    System.out.println("Building binary tree with " + employeeList.size() + " employees.");
                    System.out.println("Using level-order (breadth-first insertion...");
                    System.out.println();
                    
                    //Insert all employees into the tree
                    for (Person person : employeeList) {
                        String name = person.getFullName();
                        String managerType = person.getManagerType();
                        String department = person.getDepartment();
                        
                        root = insertLevelOrder(root, name, managerType, department);
                    }
                    
                    //calculate tree statistics
                    int height = getHeight(root);
                    int totalNodes = countNodes(root);
                    
                    //Display results
                    System.out.println("Binary tree created successfully!");
                    System.out.println();
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println("Tree Statistics");
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println("Total Nodes:  " + totalNodes);
                    System.out.println("Tree Height:  " + height);
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println();
                    System.out.println("Use option 5 (Display Tree) to view the hierarchy.");
                }

                case DISPLAY_TREE -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("  Display Tree Traversals");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();

                    // Check if tree exists
                    if (root == null) {
                        System.out.println("❌ Error: Tree has not been created yet!");
                        System.out.println("Please use option 4 (Create Tree) first.");
                        System.out.println();
                        break;
                    }
                    
                    // Display tree using level-order traversal
                    System.out.println("Employee Hierarchy (Level-Order):");
                    System.out.println("═════════════════════════════════════════════");
                    System.out.printf("%-25s | %-20s | %-20s%n", "NAME", "MANAGER TYPE", "DEPARTMENT");
                    System.out.println("─────────────────────────────────────────────");
                    displayLevelOrder(root);
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println();
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
    private static void mergeSort(ArrayList<Person> list, int start, int end) {
        /**
         * mergeSort is the main method, where we will sort alphabetically by
         * name. It recursively divides the list (right and left side) and
         * merges back in order.
         */

        //Base Case: If the list has only one element, return the list and terminate. Because de list is already sorted.
        if (start >= end) {
            return;
        }

        //Start the Recursive case!
        //Divide Case: Split the list into two halves that are as equal in length as possible.
        int middle = (start + end) / 2; // start = 0 ; end = 19.

        // Conquer Case: Using recursion, sort both lists using mergesort.
        //Sort left half
        mergeSort(list, start, middle); // start = 0 , middle = 9.5 --> From Giuliana Cardoso to Julia Quinn.

        //Sort right half
        mergeSort(list, middle + 1, end); // middle + 1 = 9.5 + 1 = 10.5, end = 19 --> From Laurann Dohner to Angela Cardoso. 

        //Combine Case: Merge the two sorted lists and return the result.
        //Merge both halves
        merge(list, start, middle, end);
    }
    private static void merge(ArrayList<Person> list, int start, int middle, int end) {
        // merge method, combines the two sorted halves into one sorted section.

        //Create temporary lists for left and right halves.
        ArrayList<Person> left = new ArrayList<>();
        ArrayList<Person> right = new ArrayList<>();

        //Copy data to left temporary list
        for (int i = start; i <= middle; i++) {
            left.add(list.get(i));
        }

        //Copy data to ight temporary list
        for (int i = middle + 1; i <= end; i++) {
            right.add(list.get(i));
        }

        //Merge the two lists back into the original list (Only 1 arrayList).
        int i = 0; //index for left list;
        int j = 0; //index for right list
        int k = start; // index for original list.

        //Here we start to compare and merge the lists.
        while (i < left.size() && j < right.size()) {
            String name1 = left.get(i).getFullName();
            String name2 = right.get(j).getFullName();

            //Start to compare names alphabetically
            if (name1.compareToIgnoreCase(name2) <= 0) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }

        //Copy remaining elements from left. 
        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }

        //Copy remaining elements from right.
        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
    
    private static void showEmployees(int howMany) {
        // Helper method to display the employees. 

        int count = Math.min(howMany, employeeList.size());

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + employeeList.get(i).toString());
        }
        if (employeeList.size() > howMany) {
            System.out.println("... and " + (employeeList.size() - howMany) + " more.");
        }
    }
    private static int binarySearch(ArrayList<Person> list, String name, int start, int end) {

        //Base Case: if the start index in greater than end index, this means that we've search the entire range and didnt find de name. 
        if (start > end) {
            return -1; //Return -1 to indicate
        }

        //Recursive case: hen we still have elements to search
        //Step 1: Need to find the middle position of de current search range. 
        int middle = (start + end) / 2; //in our case: start=0 and end =19, so the middle=9

        //Step 2: Need to get the full name of the person at the middle position.
        String middleName = list.get(middle).getFullName();

        //Step 3: Need to compare the searchName with the middleName.
        int comparison = name.compareToIgnoreCase(middleName);
        /**
         * In this case .compareToIgnoreCase() returns: -1: if 'name' comes
         * before 'middleName' 0: if they are igual. It means that we found it!
         * +1: if 'name' comes after 'middleName'
         */

        //Step 4: Based on comparison result, decide what to do
        if (comparison == 0) {
            return middle;
        } else if (comparison < 0) {
            return binarySearch(list, name, start, middle - 1);
        } else {
            return binarySearch(list, name, middle + 1, end);
        }
    }
    
    private static String validateManagerType(String choice) {
        return switch (choice) {
            case "1" -> "Branch Manager";
            case "2" -> "Senior Manager";
            case "3" -> "Team Lead";
            default -> null;
        };
    }
    private static String validateDepartment(String choice) {
        return switch (choice) {
            case "1" -> "IT";
            case "2" -> "Finance";
            case "3" -> "HR";
            case "4" -> "Loans";
            default -> null;
        };
    }
    
    private static TreeNode insertLevelOrder(TreeNode root, String name, String managerType, String department) {
        // Create the new node to insert
        TreeNode newNode = new TreeNode(name, managerType, department);
        
        // CASE 1: Tree is empty - new node becomes root
        if (root == null) {
            return newNode;
        }
        
        // CASE 2: Tree exists - use Queue for level-order insertion
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with root
        
        // Keep searching until we find a spot to insert
        while (!queue.isEmpty()) {
            // Get the front node from queue
            TreeNode current = queue.poll();
            
            // Check left child
            if (current.left == null) {
                // Found empty left spot - insert here!
                current.left = newNode;
                return root;  // Done! Return original root
            } else {
                // Left exists - add it to queue to check its children later
                queue.offer(current.left);
            }
            
            // Check right child
            if (current.right == null) {
                // Found empty right spot - insert here!
                current.right = newNode;
                return root;  // Done! Return original root
            } else {
                // Right exists - add it to queue to check its children later
                queue.offer(current.right);
            }
            
            // If we reach here, current node has both children
            // Continue to next node in queue (next level)
        }
        
        return root;
    }
    private static int getHeight(TreeNode node) {
        // Base case: empty tree has height 0
        if (node == null) {
            return 0;
        }
        
        // Recursive case: get height of left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        // Height is 1 (current level) + maximum of left/right heights
        return 1 + Math.max(leftHeight, rightHeight);
    }
    private static int countNodes(TreeNode node) {
        // Base case: null node contributes 0 to count
        if (node == null) {
            return 0;
        }
        
        // Recursive case: 1 (current) + count of left subtree + count of right subtree
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    private static void displayLevelOrder(TreeNode root) {
        // Check if tree exists
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        
        // Use Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with root
        
        int nodeCount = 0;  // Counter for displaying node numbers
        
        // Process queue until empty
        while (!queue.isEmpty()) {
            // Get and remove front node
            TreeNode current = queue.poll();
            
            // Display this node
            nodeCount++;
            System.out.print(String.format("%-4d. ", nodeCount));
            current.displayNode();
            
            // Add left child to queue (if exists)
            if (current.left != null) {
                queue.offer(current.left);
            }
            
            // Add right child to queue (if exists)
            if (current.right != null) {
                queue.offer(current.right);
            }
            
            // Continue to next node in queue
        }
    }
    
}
