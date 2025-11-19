/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class FullTimeEmployee extends Employee { // Child class that inherits from Employee.
    
    public FullTimeEmployee() { // Contructor that creates a new FullTimeEmployee object.
        super("Full-Time"); //Call the parent class constructor with "Full-Time" as parameter.
    }
    
    @Override
    public String getDescription() { //Provides specific description for Full-Time.
        return "Full-Time Employee - Permanent staff with full benefits.";
    }
}
