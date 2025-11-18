/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class BranchManager extends Manager { //child class that inherits from Manager
    
    public BranchManager() { //Contructor that create a new BranchManager object
        super("Branch Manager"); //Call the parent class with "Branch Manager" as parameter
    }
    
    @Override //Tells Java that we are implementing the parent's abstract method
    public String getDescription(){
        return "Branch Manager - Responsible for day-to-day operations of a branch.";
    }
}
