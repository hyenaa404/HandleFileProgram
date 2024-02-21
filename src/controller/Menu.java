/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import util.InputUtils;

/**
 *
 * @author nhs
 */
public class Menu {
    public static int chooseInputOption(){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1. Check path");
            System.out.println("2. Get filename with type Java");
            System.out.println("3. Get file with size greater than input");
            System.out.println("4. Write more content to file");
            System.out.println("5. Read file and count charater");
            System.out.println("6. Exit");
            System.out.println("-----------------------------------------------------------------");
        int option = InputUtils.inputOption(1, 6);
        return option;
    }
}
