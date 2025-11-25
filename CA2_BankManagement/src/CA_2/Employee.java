/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public abstract class Employee { // Parent Class that serves as a base for different types of employees (Full-Time, Part-Time, Contract, etc...)
    
    private String employeeType; // This stores the name of Employee Type ("Full-Time", "Part-Time", "Contract".
    
    public Employee(String employeeType) { // This method runs when we create a new employee type object.
        this.employeeType = employeeType;
    }
    
    public String getEmployeeType() { //Getter method that returnd de employee type name. 
        return employeeType; // return the name of this employee type as a String.
    }
    
    @Override // Return a String representation of this object
    public String ToString() {
        return employeeType; // return the employee typee as a String
    }
}
