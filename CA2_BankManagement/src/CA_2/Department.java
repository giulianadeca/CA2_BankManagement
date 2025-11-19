/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public abstract class Department { // Parent Class that serves as a base for different types of departments (IT, HR, Finance, Loans, etc...)
    
    private String departmentName; // This stores the name of department ("IT", "HR", "Finance" and "Loans".
    
    public Department(String departmentName) { // This method runs when we create a new department object. 
        this.departmentName = departmentName;
    }
    
    public String getDepartmentName() { //Getter method that returnd de department name. 
        return departmentName; // return the name of this department as a String.
    }
    
    public abstract String getDescription();
    
    @Override // Return a String representation of this object
    public String toString() {
        return departmentName; // return the department name as a string
    }
    
}
