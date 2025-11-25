/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Giu
 */
public class TreeNode { //Class for Binary Tree implementation
    
    //Stores employee information
    String name;           // Employee full name
    String managerType;    // Type of manager (Branch Manager, Senior Manager, Team Lead)
    String department;     // Department (IT, Finance, HR, Loans)
    
    //Tree structure that point to child nodes
    TreeNode left;         // Left child node
    TreeNode right;        // Right child node
    
    //constructor to create a new tree node
    public TreeNode(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
        this.left = null; //start with no left child.
        this.right = null; //start with no right child. 
    }
    
    public void displayNode(){
        System.out.printf("%-25s | %-20s | %-20s%n", name, managerType, department); //Format how it will be displayed. 
    }
}
