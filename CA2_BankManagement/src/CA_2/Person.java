/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * @author Giuliana Cardoso d'Eça - 2025008
 * HDip in Computing - Algorithms & Constructs
 */
public class Person { //Following Taufique's .txt
    
    //Attributes (instance variables)
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private String department;
    private String position;
    private String jobTitle;
    private String branch;
    
    
    //Constructors to create a new person object.  
    public Person(String firstName, String lastName, String gender, String email, double salary, 
            String department, String position, String jobTitle, String branch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.branch = branch;        
    }
    
    // Getter nwthods for the attributes. 
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return  firstName + " " + lastName;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public boolean isManager() {
        return position == null || position.trim().isEmpty();
    }
    
    public String getManagerType() {
        if (isManager()) {
            return jobTitle;
        }
        return "N/A";
    }
    
    public String getEmployeeType() {
        if (isManager()) {
            return "Management";
        }
        return position;
    }
    
    @Override
    public String toString() { // display one line in a list. 
        return String.format("%-20s | %-20s | %-20s | €%8.2f | %-20s",
                getFullName(),
                department, 
                isManager() ? "Manager: " + jobTitle : position + " - " + jobTitle,  //This is a ternary operator: Condition ? valueIfTrue : valueIfFalse
                salary,
                branch);
    }
    
    public void printDetails() { // display all information
        System.out.println("═══════════════════════════════════════");
        System.out.println("Name:       " + getFullName());
        System.out.println("Gender:     " + gender);
        System.out.println("Email:      " + email);
        System.out.println("Salary:     €" + String.format("%.2f", salary));
        System.out.println("Department: " + department);
        System.out.println("Position:   " + getEmployeeType());
        System.out.println("Job Title:  " + jobTitle);
        System.out.println("Branch:    " + branch);
        if (isManager()) {
            System.out.println("Role:       Manager (" + getManagerType() + ")");
        }
        System.out.println("═══════════════════════════════════════");
    }
    
}
