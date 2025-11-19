/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class ITDepartment extends Department { // Child class that inherits from Department
    
    public ITDepartment() { // Contructor that creates a new ITDepartment object.
        super("IT"); //Call the parent class constructor with "IT" as parameter
    }
    
    @Override
    public String getDescription() { //Provides specific description for IT Department.
        return "IT Department - Manages technology infrastructure and systems.";
    }
}
