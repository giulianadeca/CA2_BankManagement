/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public abstract class Manager { //Abstract parent class that stores different tyoes of managers (SeniorManager; BranchManager and TeamLead
    
    private String managerType; 
    
    public Manager(String managerType) { //Method that runs when we create a new manager object. 
        this.managerType = managerType;
    }
    
    public String getManagerType() { //Getter method that returns the manager type. 
        return managerType; // return the type of this manager as a string.
    }
    
    public abstract String getDescription(); // method that must be implemented by child classes
    
    @override //Returns a string representation of this object
    public String toString() {
        return managerType;
    }
    
}
