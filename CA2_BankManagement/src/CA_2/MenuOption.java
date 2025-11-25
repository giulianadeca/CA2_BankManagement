/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public enum MenuOption {

    //ENUM Constants - These are the menu options
    SORT(1, "Sort"),
    SEARCH(2, "Search"),
    ADD_RECORDS(3, "Add Records"),
    CREATE_TREE(4, "Create a Binary Tree"),
    DISPLAY_TREE(5, "Display Tree Traversals"),
    EXIT(0, "Exit");

    private final int code; // The numeric code shown to user (1, 2, 3, ....)

    private final String description; //The text shown to user

    //ENUM Constructor - This is called automatically when ENUM constants are created. And they are always private (can´t be called from outside).
    MenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Note to myself: Every time you create an ENUM menu like the one above,
     * all the code will throw errors until you insert the ENUM Constructor!!!!
     */

    public int getCode() { // Get the numeric code or this menu option.
        return code;
    }

    public String getDescription() { //Get the description for this menu option. 
        return description;
    }

    public static MenuOption fromCode(int code) { //This utility method is used to convert user input (a number) into a MenuOption.
        /**
         * Loop though ALL enum constants. The MEnuOption.values() returns an
         * array of all constants A = [SORT, SEARCH, ADD_RECORDS, CREATE_TREE,
         * DISPLAY_TREE, EXIT]
         */
        for (MenuOption option : MenuOption.values()) {
            if (option.getCode() == code) { // Check if this option's code matches whats we are looking for.
                return option; //If found it! Return this option.
            }
        }
        return null; //If it din't find any option with this code. Return Null to indicade "invalid code".
    }

    public static void displayMenu() {
        
        System.out.println();
        System.out.println("═══════════════════════════════════════");
        System.out.println("  BANK MANAGEMENT SYSTEM - MENU");
        System.out.println("═══════════════════════════════════════");
        
        for (MenuOption option : MenuOption.values()) {
            if (option != EXIT) { // Loop though all menu options EXCEPT EXIT.
                System.out.println(option.getCode() + ". " + option.getDescription());
            }
        }
        System.out.println(EXIT.getCode() + ". " + EXIT.getDescription()); // Code 0 is special. It will be ALWAYS at bottom.
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter your choice: ");
    }
}
