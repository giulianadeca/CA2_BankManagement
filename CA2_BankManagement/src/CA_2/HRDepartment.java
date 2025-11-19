/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class HRDepartment extends Department { // Child class that inherits from Department
    
    public HRDepartment() { // Contructor that creates a new HRDepartment object.
        super("HR"); //Call the parent class constructor with "HR" as parameter
    }
    
    @Override
    public String getDescription() { //Provides specific description for HR Department.
        return "HR Department - Handles recruitment, training, and employee relations.";
    }
}
