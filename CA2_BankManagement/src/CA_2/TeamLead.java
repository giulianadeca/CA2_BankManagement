/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class TeamLead extends Manager { //child class that inherits from Manager
    
    public TeamLead() { //Contructor that create a new TeamLead object
        super("Team Lead"); //Call the parent class with "Team Lead" as parameter
    }
    
    @Override //Tells Java that we are implementing the parent's abstract method
    public String getDescription(){
        return "Team Lead - Supervises a Team of employees in a specific area.";
    }
}
