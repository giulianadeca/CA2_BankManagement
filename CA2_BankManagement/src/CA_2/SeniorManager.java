/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class SeniorManager extends Manager{ //child class that inherits from Manager
    
    public SeniorManager() { //Contructor that create a new SeniorManager object
        super("Senior Manager"); //Call the parent class with "Senior Manager" as parameter
    }
    
    @Override //Tells Java that we are implementing the parent's abstract method
    public String getDescription() {
        return "Senior Manager - Oversees multiple departments and strategic decisions.";
    }
}
